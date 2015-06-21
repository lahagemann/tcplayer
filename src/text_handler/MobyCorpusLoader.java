package text_handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobyCorpusLoader {
	
	/*
	 * MOBY CORPUS is a syllable separation corpus
	 * each word collected is splitted into syllables by the character "¥"
	 * this class loads the corpus file and transforms it into a dictionary
	 * with the whole word a key and the splitted word as its value
	 */
	
	private Map<String,List<Syllable>> syllableDictionary;
	private String mobyFilePath;
	
	public MobyCorpusLoader(String mobyFilePath) {
		setMobyFilePath(mobyFilePath);
		setSyllableDictionary();
	}
	
	/* GETTERS & SETTERS */
	
	public Map<String,List<Syllable>> getSyllableDictionary() {
		return syllableDictionary;
	}
	
	public void setSyllableDictionary() {
		this.syllableDictionary = new HashMap<String,List<Syllable>>();
		loadFile();
	}
	
	public String getMobyFilePath() {
		return mobyFilePath;
	}
	
	public void setMobyFilePath(String path) {
		this.mobyFilePath = path;
	}
	
	
	/* CLASS METHODS */
	
	//OBSERVAÇÃO: TEM QUE TRATAR ERROS DE CODIFICAÇÃO
	
	private void loadFile(){
		try {
			BufferedReader file = new BufferedReader(new FileReader(mobyFilePath));
			
			while(file.ready()) {
				String word = file.readLine();
				addWordToDictionary(word);
			}
			file.close();
		} 
		catch(IOException exception) {
			/* catch padrão, arrumar dps */
			System.err.println("Moby corpus file does not exist, please reinput path");
			System.exit(0);
		}
	}
	
	private void addWordToDictionary(String word) {
		String wordWithoutSeparator = word.replace("¥", "");		
		List<Syllable> syllables = separate(word);
		syllableDictionary.put(wordWithoutSeparator, syllables);
	}
	
	private List<Syllable> separate(String word) {
		List<Syllable> splittedWord = new ArrayList<Syllable>();
		
		if(isMonosyllable(word)) 
			splittedWord.add(new Syllable(word));
		else
			for (String syllable : word.split("¥"))
				splittedWord.add(new Syllable(syllable));
		
		return splittedWord;
	}
	
	private boolean isMonosyllable(String word) {
		if(word.contains("¥"))
			return true;
		return false;
	}
	
	public List<Syllable> split(Text text) {
		List<Syllable> syllabifiedText = new ArrayList<Syllable>();
		
		for (String word : text.getOriginalText()) {
			if(syllableDictionary.containsKey(word))
				syllabifiedText.addAll(syllableDictionary.get(word));
			else {
				//definir criterios de separação
			}
		}
		
		return syllabifiedText;
	}
}