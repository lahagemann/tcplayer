package properties;

public enum MajorScaleEnum {

	CMAJ	("C D E F G A B", "Cmaj"),
	GMAJ	("G A B C D E F#", "Gmaj"),
	DMAJ	("D E F# G A B C#", "Dmaj"),
	AMAJ	("A B C# D E F# G#", "Amaj"),
	EMAJ	("E F# G# A B C# D#", "Emaj"),
	BMAJ	("B C# D# E F# G# A#", "Bmaj"),
	FSMAJ 	("F# G# A# B C# D# E#", "F#maj"),
	CSMAJ 	("C# D# E# F# G# A# B#", "C#maj"),

	FMAJ 	("F G A Bb C D E", "Fmaj"),
	BbMAJ 	("Bb C D Eb F G A", "Bbmaj"),
	EbMAJ 	("Eb F G Ab Bb C D", "Ebmaj"),
	AbMAJ 	("Ab Bb C Db Eb F G", "Abmaj"),
	DbMAJ 	("Db Eb F Gb Ab Bb C", "Dbmaj"),
	GbMAJ 	("Gb Ab Bb Cb Db Eb F", "Gbmaj"),
	CbMAJ 	("Cb Db Eb Fb Gb Ab Bb", "Cbmaj");

	
	private String scale;
	private String nameOfScale;
	private MajorScaleEnum(String listOfNotes, String nameOfScale){
		this.scale = listOfNotes;
		this.nameOfScale = nameOfScale;
	}
	
	public String getScale() {
		return this.scale;
	}
	
	public String getNameOfScale() {
		return this.nameOfScale;
	}
}
