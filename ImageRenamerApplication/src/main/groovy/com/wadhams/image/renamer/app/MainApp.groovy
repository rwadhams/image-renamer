/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package com.wadhams.image.renamer.app

import com.wadhams.image.renamer.service.ImageRenamerService
import com.wadhams.image.renamer.util.ImageFinder
import com.wadhams.image.renamer.util.ImageMetadata

class MainApp {
	ImageRenamerService imageRenamerService = new ImageRenamerService()
	
    static void main(String[] args) {
		println 'MainApp started...'
		println ''

		MainApp app = new MainApp()
		app.execute()

		println ''
		println 'MainApp ended.'
    }
	
	def execute() {
		imageRenamerService.service()
	}

	//test-only method
    String getGreeting() {
        return 'Hello world.'
    }

}
