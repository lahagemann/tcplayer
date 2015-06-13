package hyphenator;

import java.util.List;

public class Text {
	
	private String originalFilePath;
	private String lemmatizedFilePath;
	
	private List<Syllable> syllabifiedText; //ver se vai ser assim ou se vamos splittar por frase também
	//se for por frase, melhor fazer uma matriz
	
	public Text(String originalFile) {
		setOriginalFilePath(originalFile);
		
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
		this.lemmatizedFilePath = path;
	}
	
	
	/* CLASS METHODS */
	
	private void lemmatize() {
		//chamada de sistema para o nltk
		//tem que criar um lugar onde vai ter o arquivo lematizado
		return;
	}
	
	private void extractEmotion() {
		//chamada de sistema para o nltk
		//tem que criar um lugar onde vai ter o arquivo
	}
	
	private void loadFile() {
		//implementar depois
	}
	

	
}
