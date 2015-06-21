package text_handler;

import java.io.IOException;
import java.util.List;

public class TextProcesser {
	
	private MobyCorpusLoader moby;
	private String mobyPath;
	private LemmatizedText text;
	private List<Syllable> syllabifiedText;
	
	public TextProcesser(String filePath) throws IOException {
		this.mobyPath = "/data/corpus/mhyph.txt";
		setup(filePath);
	}
		
	
	/* SETUP */
	
	public void setup(String filePath) throws IOException {
		setupMoby();
		setupText(filePath);
	}
	
	public List<Syllable> getSyllabifiedText() {
		return syllabifiedText;
	}
	
	
	private void setupText(String path) throws IOException {
		this.text = new LemmatizedText(path);
	}


	private void setupMoby() {
		this.moby = new MobyCorpusLoader(this.mobyPath);
	}


	/* RUN */
	
	public void process() {
		this.syllabifiedText = this.moby.split(this.text);
	}

}
