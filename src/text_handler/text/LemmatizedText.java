package text_handler.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LemmatizedText extends Text {
	
	private String lemmatizedFilePath;
	private String emotionFilePath;
	private String positiveness;
	private String originalFileName;
	
	private List<String> lemmatizedText;


	public LemmatizedText(String originalFile) throws IOException, InterruptedException {
		super(originalFile);
		setOriginalFileName(originalFile);
		lemmatize(originalFile);
		setLemmatizedFilePath(originalFile);
		setLemmatizedText();
		setEmotionFilePath(lemmatizedFilePath);
		setPositiveness();
	}

	/* GETTERS & SETTERS */
	
	public void setOriginalFileName(String path) {
		String[] pathParts = path.split("/");
		this.originalFileName = pathParts[pathParts.length-1];
	}
	
	public String getLemmatizedFilePath() {
		return lemmatizedFilePath;
	}
	
	public void setLemmatizedFilePath(String path) {
		File textDirectory = new File(System.getProperty("user.dir")+"/data/text/");
		if(textDirectory.exists() && textDirectory.isDirectory()) {
			for (File file : textDirectory.listFiles()) {
				if(file.getName().contains(this.originalFileName) && file.getName().endsWith(".lemmatized"))
					this.lemmatizedFilePath = file.getAbsolutePath();
			}
		}
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
	
	public void setPositiveness() throws IOException, InterruptedException {
		extractEmotion();
		extractPositivenessFromFile();
	}
	
	/* CLASS METHODS */
	
	private void lemmatize(String path) throws IOException, InterruptedException {
		String scriptPath = this.getClass().getResource("/resources/lemmatizer.py").toString().split("\\:")[1];
		String command = "python "+scriptPath+" "+System.getProperty("user.dir")+"/data/text/ " + path;
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();	
	}
	
	private void loadFile() {
		try {
			BufferedReader file = new BufferedReader(new FileReader(lemmatizedFilePath));
			lemmatizedText = new ArrayList<String>();
			while(file.ready()) {
				String line = file.readLine();
				if(!line.matches("\\s"))
					this.lemmatizedText.add(line.trim());
			}
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void extractEmotion() throws IOException, InterruptedException {
		String scriptPath = this.getClass().getResource("/resources/extract_emotion.py").toString().split("\\:")[1];
		String command = "python "+scriptPath+" "+System.getProperty("user.dir")+"/data/text/ " + lemmatizedFilePath;
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
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
