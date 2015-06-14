package hyphenator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text {
	
	private String originalFilePath;
	private String lemmatizedFilePath;
	private String emotionFilePath;
	
	private String positiveness;
	
	private List<String> originalText;
	private List<Syllable> syllabifiedText; 
	
	
	public Text(String originalFile) {
		setOriginalFilePath(originalFile);
		setLemmatizedFilePath(originalFile);
		setEmotionFilePath(lemmatizedFilePath);
		setPositiveness();
		setSyllabifiedText();
		setOriginalText();
	}

	
	/* GETTERS & SETTERS */
	
	public String getOriginalFilePath() {
		return originalFilePath;
	}
	
	public void setOriginalFilePath(String path) {
		this.originalFilePath = path;
	}
	
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
	
	public String getPositiveness() {
		return positiveness;
	}
	
	public void setPositiveness() {
		extractEmotion();
		extractPositivenessFromFile();
	}
	
	public List<String> getOriginalText() {
		return originalText;
	}
	
	public void setOriginalText() {
		loadTextFile();
		lemmatize();
	}
	
	public List<Syllable> getSyllabifiedText() {
		return syllabifiedText;
	}
	
	public void setSyllabifiedText() {
		this.syllabifiedText = new ArrayList<Syllable>();
	}
	
	
	/* CLASS METHODS */
	
	private void lemmatize() {
		try {
			Process p = Runtime.getRuntime().exec("python lemmatizer.py "+ originalFilePath);
			//não lembro o que tem que fazer mais
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void extractEmotion() {
		try {
			Process p = Runtime.getRuntime().exec("python extract_emotion.py "+ lemmatizedFilePath);
			//não lembro o que tem que fazer mais
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadTextFile() {
		try {
			BufferedReader file = new BufferedReader(new FileReader(lemmatizedFilePath));
			
			while(file.ready()) {
				String line = file.readLine();
				this.originalText.add(line.trim());
			}
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void extractPositivenessFromFile() {
		try {
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
