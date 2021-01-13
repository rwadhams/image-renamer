package com.wadhams.image.renamer.service

import java.text.SimpleDateFormat
import java.util.regex.Pattern

import com.wadhams.image.renamer.type.FileExtension
import com.wadhams.image.renamer.util.ImageFinder
import com.wadhams.image.renamer.util.ImageMetadata

class ImageRenamerService {
	SimpleDateFormat sdf = new SimpleDateFormat('yyyyMMdd_HHmmss')
	
	ImageFinder imageFinder = new ImageFinder()
	ImageMetadata imageMetadata = new ImageMetadata()
	
	def service() {
		List<File> fileList
		
		//MOV
		fileList = imageFinder.findImages(FileExtension.MOV)
		renameFiles(fileList, FileExtension.MOV)
		
		//JPG
		fileList = imageFinder.findImages(FileExtension.JPG)
		renameFiles(fileList, FileExtension.JPG)
		
		//HEIC
		fileList = imageFinder.findImages(FileExtension.HEIC)
		renameFiles(fileList, FileExtension.HEIC)
	}

	def renameFiles(List<File> fileList, FileExtension fileExtension) {
		fileList.each {f ->
			println "Found...${f.path}"
			Date creationDate = imageMetadata.findCreationDate(f, fileExtension)
			if (creationDate) {
				String rename = "${f.parent}/${sdf.format(creationDate)}_${personaliseFileName(f.parent, f.name)}"
				println "Renamed....$rename"
				f.renameTo(rename) 
			}
			println ''
		}
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
