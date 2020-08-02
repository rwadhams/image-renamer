/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package com.wadhams.image.renamer.util

import com.wadhams.image.renamer.app.MainApp

import static groovy.io.FileType.FILES
import com.drew.imaging.ImageMetadataReader
import com.drew.metadata.Metadata
import com.drew.metadata.exif.ExifSubIFDDirectory
import com.drew.metadata.mov.QuickTimeDirectory
import com.drew.imaging.ImageProcessingException

class ImageMetadata {
	Date findCreationDate(File f) {
		Metadata metadata
		try {
			metadata = ImageMetadataReader.readMetadata(f)
		}
		catch(ImageProcessingException ipe) {
			println "${ipe.message}"
			return null
		}
		
//		for (Directory dir : metadata.getDirectories()) {
//			println dir.getClass()
//			for (Tag tag : dir.getTags()) {
//				println tag
//			}
//		}
		
		Date creationDate
		if (f.name.endsWith('.JPG')) {
			ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class)
			creationDate = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL, TimeZone.getDefault())
		}
		else if (f.name.endsWith('.MOV')) {
			QuickTimeDirectory directory = metadata.getFirstDirectoryOfType(QuickTimeDirectory.class)
			creationDate = directory.getDate(QuickTimeDirectory.TAG_CREATION_TIME, TimeZone.getDefault())
		}
		else {
			println "Unable to find creation date for: ${f.absolutePath}"
			println ''
			return null
		}
		
		println "${f.name} has a creation date of: $creationDate"
		
		return creationDate
	}
}