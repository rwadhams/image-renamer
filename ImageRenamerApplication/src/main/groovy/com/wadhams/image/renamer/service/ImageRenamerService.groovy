/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package com.wadhams.image.renamer.service

import com.wadhams.image.renamer.util.ImageFinder
import com.wadhams.image.renamer.util.ImageMetadata

import java.text.SimpleDateFormat

class ImageRenamerService {
	SimpleDateFormat sdf = new SimpleDateFormat('yyyyMMdd_HHmmss')
	
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
				String rename = "${f.parent}/${sdf.format(creationDate)}_${f.name}"
				println "Renamed....$rename"
				f.renameTo(rename) 
			}
			println ''
		}
	}
}
