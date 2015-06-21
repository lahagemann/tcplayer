package text_handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Text {
	
	private String originalFilePath;
	private List<String> originalText;
	
	
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
	

	
	public List<String> getOriginalText() {
		return originalText;
	}
	
	public void setOriginalText() {
		loadTextFile();
	}

	
	/* CLASS METHODS */
	
	
	private void loadTextFile() {
		try {
			BufferedReader file = new BufferedReader(new FileReader(originalFilePath));
			
			while(file.ready()) {
				String line = file.readLine();
				this.originalText.add(line.trim());
			}
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
