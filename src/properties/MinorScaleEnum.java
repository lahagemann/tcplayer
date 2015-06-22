package properties;

public enum MinorScaleEnum {

	AMIN 	("A B C D E F G#", "Amin"),
	EMIN 	("E F# G A B C D#", "Emin"),
	BMIN 	("B C# D E F# G A#", "Bmin"),
	FSMIN 	("F# G# A B C# D E#", "F#min"),
	CSMIN 	("C# D# E F# G# A B#", "C#min"),
	GSMIN 	("G# A# B C# D# E F##", "G#min"),
	DSMIN 	("D# E# F# G# A# B C##", "D#min"),
	ESMIN 	("E# F# G# A# B# C# D##", "E#min"),

	DMIN 	("D E F G A Bb C#", "Dmin"),
	GMIN 	("G A Bb C D Eb F#", "Gmin"),
	CMIN 	("C D Eb F G Ab B", "Cmin"),
	FMIN 	("F G Ab Bb C Db E", "Fmin"),
	BbMIN 	("Bb C Db Eb F Gb A", "Bbmin"),
	EbMIN 	("Eb F Gb Ab Bb Cb D", "Ebmin"),
	AbMIN 	("Ab Bb Cb Db Eb Fb G", "Abmin");
	
	private String scale;
	private String nameOfScale;
	private MinorScaleEnum(String listOfNotes, String nameOfScale){
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
