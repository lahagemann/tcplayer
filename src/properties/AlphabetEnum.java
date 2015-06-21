package properties;

public enum AlphabetEnum {
	H ("H", "A"),
	I ("I", "B"),
	J ("J", "C"),
	K ("K", "D"),
	L ("L", "E"),
	M ("M", "F"),
	N ("N", "G"),
	O ("O", "A"),
	P ("P", "B"),
	Q ("Q", "C"),
	R ("R", "D"),
	S ("S", "E"),
	T ("T", "F"),
	U ("U", "G"),
	V ("V", "A"),
	W ("W", "B"),
	X ("X", "C"),
	Y ("Y", "D"),
	Z ("Z", "E");
	
	private String key;
	private String correspondent;
	
	private AlphabetEnum(String key, String correspondent){
		this.key = key;
		this.correspondent = correspondent;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public String getCorrespondent(){
		return this.correspondent;
	}
}
