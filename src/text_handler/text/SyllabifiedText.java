package text_handler.text;

import java.util.ArrayList;
import java.util.List;

public class SyllabifiedText extends Text {
	
	private List<Syllable> syllabifiedText;

	public SyllabifiedText(String originalFile) {
		super(originalFile);
		// TODO Auto-generated constructor stub
	}
	
	public List<Syllable> getSyllabifiedText() {
		return syllabifiedText;
	}
	
	public void setSyllabifiedText() {
		this.syllabifiedText = new ArrayList<Syllable>();
	}
	
	public void setSyllabifiedText(List<Syllable> text) {
		this.syllabifiedText = text;
	}
	

}
