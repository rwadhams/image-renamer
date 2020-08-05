package com.wadhams.image.renamer.type

enum FileExtension {
	JPG(['JPG','JPEG']),
	MOV(['MOV']),
	Unknown(['Unknown']);
	
	private static EnumSet<FileExtension> allEnums = EnumSet.allOf(FileExtension.class)
	
	private final List<String> extensions

	FileExtension(List<String> extensions) {
		this.extensions = extensions
	}
	
	public static FileExtension findByExtension(String text) {
		if (text) {
			text = text.toUpperCase()
			for (FileExtension e : allEnums) {
				if (e.extensions.contains(text)) {
					return e
				}
			}
		}
		else {
			return FileExtension.Unknown
		}
		
		println "Unknown extension text: $text"
		return FileExtension.Unknown
	}

}
