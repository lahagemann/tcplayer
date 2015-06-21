package text_handler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LemmatizedText extends Text {
	
	private String lemmatizedFilePath;
	private String emotionFilePath;
	private String positiveness;
	
	private List<String> lemmatizedText;


	public LemmatizedText(String originalFile) throws IOException {
		super(originalFile);
		setLemmatizedFilePath(originalFile);
		lemmatize(originalFile);
		setLemmatizedText();
		setEmotionFilePath(lemmatizedFilePath);
		setPositiveness();
	}

	/* GETTERS & SETTERS */
	
	public String getLemmatizedFilePath() {
		return lemmatizedFilePath;
	}
	
	public void setLemmatizedFilePath(String path) {
		this.lemmatizedFilePath = path.concat(".lemmatized");
	}
	
	public String getEmotionFilePath() {
		return emotionFilePath;
	}
	
	public void setEmotionFilePath(String path) {
		this.emotionFilePath = path.concat(".emotion");
	}

	public List<String> getLemmatizedText() {
		return lemmatizedText;
	}

	public void setLemmatizedText() {
		loadFile();
	}
	
	public String getPositiveness() {
		return positiveness;
	}
	
	public void setPositiveness() throws IOException {
		extractEmotion();
		extractPositivenessFromFile();
	}
	
	/* CLASS METHODS */
	
	private void lemmatize(String path) throws IOException {
			Process p = Runtime.getRuntime().exec("python lemmatizer.py "+ path);
			//não lembro o que tem que fazer mais
	}
	
	private void loadFile() {
		try {
			BufferedReader file = new BufferedReader(new FileReader(lemmatizedFilePath));
			
			while(file.ready()) {
				String line = file.readLine();
				this.lemmatizedText.add(line.trim());
			}
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void extractEmotion() throws IOException {
			Process p = Runtime.getRuntime().exec("python extract_emotion.py "+ lemmatizedFilePath);
			//não lembro o que tem que fazer mais
	}
	
	private void extractPositivenessFromFile() throws IOException {
			BufferedReader file = new BufferedReader(new FileReader(emotionFilePath));
			int positives = 0;
			int negatives = 0;
			
			while(file.ready()) {
				String line = file.readLine().trim();
				if(!line.matches("\\s")) {
					if(line.equals("positive"))
						positives++;
					else
						negatives++;
				}
			}
			file.close();
			
			if(positives > negatives)
				this.positiveness = "positive";
			else
				this.positiveness = "negative";
	}
}
