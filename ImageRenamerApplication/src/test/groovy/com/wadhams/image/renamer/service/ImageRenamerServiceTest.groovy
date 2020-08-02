package com.wadhams.image.renamer.service

import spock.lang.Specification

class ImageRenamerServiceTest extends Specification {
    
	def "standardiseFileName() with trailing digit"() {
        setup:
        def service = new ImageRenamerService()

        when:
        def result = service.standardiseFileName('IMG_7131 2.MOV')

        then:
        result == 'IMG_7131.MOV'
    }
	
    def "standardiseFileName() without trailing digit"() {
        setup:
        def service = new ImageRenamerService()

        when:
        def result = service.standardiseFileName('IMG_1234.JPG')

        then:
        result == 'IMG_1234.JPG'
    }
	
    def "personaliseFileName() for Rob"() {
        setup:
        def service = new ImageRenamerService()

        when:
        def result = service.personaliseFileName('ab_Rob_xyz', 'IMG_1234.JPG')

        then:
        result == 'ROB_1234.JPG'
    }
	
    def "personaliseFileName() for ROB"() {
        setup:
        def service = new ImageRenamerService()

        when:
        def result = service.personaliseFileName('ab_ROB', 'IMG_2345.JPG')

        then:
        result == 'ROB_2345.JPG'
    }
	
    def "personaliseFileName() for rob"() {
        setup:
        def service = new ImageRenamerService()

        when:
        def result = service.personaliseFileName('rob_xyz', 'IMG_3456.JPG')

        then:
        result == 'ROB_3456.JPG'
    }
	
    def "personaliseFileName() for Molly"() {
        setup:
        def service = new ImageRenamerService()

        when:
        def result = service.personaliseFileName('ab_Molly_xyz', 'IMG_1234.JPG')

        then:
        result == 'MOLLY_1234.JPG'
    }
	
    def "personaliseFileName() for neither Rob or Molly"() {
        setup:
        def service = new ImageRenamerService()

        when:
        def result = service.personaliseFileName('ab_xyz', 'IMG_1234.JPG')

        then:
        result == 'IMG_1234.JPG'
    }
	
} 
