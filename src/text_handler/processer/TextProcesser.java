package text_handler.processer;

import java.io.IOException;
import java.util.List;

import text_handler.corpus.MobyCorpusLoader;
import text_handler.text.LemmatizedText;
import text_handler.text.Syllable;

public class TextProcesser {
	
	private MobyCorpusLoader moby;
	private String mobyPath;
	private LemmatizedText text;
	private List<Syllable> syllabifiedText;
	
	public TextProcesser(String filePath) throws IOException, InterruptedException {
		this.mobyPath = System.getProperty("user.dir")+"/data/corpus/mhyph.txt";
		setup(filePath);
	}
		
	
	/* SETUP */
	
	public void setup(String filePath) throws IOException, InterruptedException {
		setupMoby();
		setupText(filePath);
	}
	
	public List<Syllable> getSyllabifiedText() {
		return syllabifiedText;
	}
	
	public String getPositiveness() {
		return this.text.getPositiveness();
	}
	
	
	private void setupText(String path) throws IOException, InterruptedException {
		this.text = new LemmatizedText(path);
	}


	private void setupMoby() {
		this.moby = new MobyCorpusLoader(this.mobyPath);
	}


	/* RUN */
	
	public void process() {
		this.syllabifiedText = this.moby.split(this.text);
	}

	
	public static void main(String[] args) throws IOException, InterruptedException {
		TextProcesser tp = new TextProcesser("/home/luiza/workspace/player/tcp_tp/data/text/test.txt");
		tp.process();
		for (Syllable syl : tp.syllabifiedText) {
			System.out.println(syl.getSyllable());
		}
	}
}
