package com.wadhams.image.renamer.type

import spock.lang.Specification

class FileExtensionTest extends Specification {
    
	def "findByExtension()"() {
		expect:
		FileExtension.findByExtension('jpg') == FileExtension.JPG
		FileExtension.findByExtension('jpeg') == FileExtension.JPG
		FileExtension.findByExtension('JPG') == FileExtension.JPG
		FileExtension.findByExtension('JPEG') == FileExtension.JPG
		FileExtension.findByExtension('Jpeg') == FileExtension.JPG
		
		FileExtension.findByExtension('mov') == FileExtension.MOV
		FileExtension.findByExtension('MOV') == FileExtension.MOV
		FileExtension.findByExtension('Mov') == FileExtension.MOV
		
		FileExtension.findByExtension('txt') == FileExtension.Unknown
	}
	

} 
