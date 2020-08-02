/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package com.wadhams.image.renamer.service

import com.wadhams.image.renamer.util.ImageFinder
import com.wadhams.image.renamer.util.ImageMetadata

import java.text.SimpleDateFormat
import java.util.regex.Matcher
import java.util.regex.Pattern

class ImageRenamerService {
	SimpleDateFormat sdf = new SimpleDateFormat('yyyyMMdd_HHmmss')
	Pattern stdPattern = ~/(IMG_\d\d\d\d) \d(\.\w\w\w)/
	Pattern perPattern = ~/IMG(_\d\d\d\d\.\w\w\w)/
	
	ImageFinder imageFinder = new ImageFinder()
	ImageMetadata imageMetadata = new ImageMetadata()
	
	def service() {
		List<File> fileList
		
		//MOV
		fileList = imageFinder.findImages('.MOV')
		renameFiles(fileList)
		
		//JPG
		fileList = imageFinder.findImages('.JPG')
		renameFiles(fileList)
	}

	def renameFiles(List<File> fileList) {
		fileList.each {f ->
			println "Found...${f.path}"
			Date creationDate = imageMetadata.findCreationDate(f)
			if (creationDate) {
				String rename = "${f.parent}/${sdf.format(creationDate)}_${personaliseFileName(f.parent, f.name)}"
				println "Renamed....$rename"
				f.renameTo(rename) 
			}
			println ''
		}
	}
	
	String standardiseFileName(String fn) {
		def m1 = fn =~ stdPattern
		if (m1) {
//			println m1[0]
//			println m1[0][1]
//			println m1[0][2]
			fn = m1[0][1] + m1[0][2]
//			println fn
		}
		
		return fn	
	}
	
	String personaliseFileName(String parent, String fn) {
		String prefix = 'IMG'
		if (parent.toUpperCase().contains('ROB')) {
			prefix = 'ROB'
		}
		else if (parent.toUpperCase().contains('MOLLY')) {
			prefix = 'MOLLY'
		}
		
		return prefix + fn.substring(3)	
	}
}