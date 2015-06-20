package properties;

public enum Scales {
	CMAJ	("C D E F G A B"),
	GMAJ	("G A B C D E F#"),
	DMAJ	("D E F# G A B C#"),
	AMAJ	("A B C# D E F# G#"),
	EMAJ	("E F# G# A B C# D#"),
	BMAJ	("B C# D# E F# G# A#"),
	FSMAJ 	("F# G# A# B C# D# E#"),
	CSMAJ 	("C# D# E# F# G# A# B#"),

	FMAJ 	("F G A Bb C D E"),
	BbMAJ 	("Bb C D Eb F G A"),
	EbMAJ 	("Eb F G Ab Bb C D"),
	AbMAJ 	("Ab Bb C Db Eb F G"),
	DbMAJ 	("Db Eb F Gb Ab Bb C"),
	GbMAJ 	("Gb Ab Bb Cb Db Eb F"),
	CbMAJ 	("Cb Db Eb Fb Gb Ab Bb"),

	AMIN 	("A B C D E F G#"),
	EMIN 	("E F# G A B C D#"),
	BMIN 	("B C# D E F# G A#"),
	FSMIN 	("F# G# A B C# D E#"),
	CSMIN 	("C# D# E F# G# A B#"),
	GSMIN 	("G# A# B C# D# E F##"),
	DSMIN 	("D# E# F# G# A# B C##"),
	ESMIN 	("E# F# G# A# B# C# D##"),

	DMIN 	("D E F G A Bb C#"),
	GMIN 	("G A Bb C D Eb F#"),
	CMIN 	("C D Eb F G Ab B"),
	FMIN 	("F G Ab Bb C Db E"),
	BbMIN 	("Bb C Db Eb F Gb A"),
	EbMIN 	("Eb F Gb Ab Bb Cb D"),
	AbMIN 	("Ab Bb Cb Db Eb Fb G");
	
	private String listOfNotes;
	Scales(String listOfNotes){
		this.listOfNotes = listOfNotes;
	}
}
