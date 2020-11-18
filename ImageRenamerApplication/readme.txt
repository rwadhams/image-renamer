Image Renamer Application
=========================

Build:
------
> distZip

Extract	C:\Mongo\Git_Repositories\image-renamer\ImageRenamerApplication\build\distributions\ImageRenamerApplication.zip
	to:	C:\Temp

Folder structure:
-----------------
	C:\Temp\ImageRenamerApplication\
		bin
			\Rob_20200829_20201020 (place images and videos here for this date range)
			\Molly_yyyyMMdd_yyyyMMdd
			ImageRenamerApplication
			ImageRenamerApplication.bat
		lib
			*.jar

Steps:
------
1a.	Identify the last image or video that was copied from the iPhone.
	>	Look in C:\Grey_Nomad_Media\Image_Files.
	>	Find the last image or video (make a note of the date).

1b.	Plug in the lightning SD reader into iPhone.
	>	Open Files App.
	>	Click on Locations > Untitled.
	>	Select > Select All > Trash (delete)

1c.	Browse photos on the iPhone to find the last+1 image/video.
	>	Select all images/videos you want to copy.
	>	Share > Save to Files > Untitled > Save.

1d.	Remove lightning SD reader from iPhone.

2a.	Plug SD card into computer.

2b.	Copy files.
	>	Create a folder named using date range here: C:\Temp\ImageRenamerApplication\bin\Rob_yyyyMMdd_yyyyMMdd.
	>	Copy all image/video files from D: to above folder.
	>	Eject SD card from computer.

2c.	Verify the copied files.
	>	Browse all files. Delete bad files. Delete unnecessary files.
	>	Rename .JPEG files to .JPG
	>	Note: UUID-like-filename.jpg are images associated with texting (can be renamed IMG_nnnn.JPG).
	>	Note: *.png files are iPhone screenshots (delete, as they won't be renamed).

3a.	Run the ImageRenamerApplication.
	>	Run the batch file: C:\Temp\ImageRenamerApplication\bin\ImageRenamerApplication.bat

4a.	Verify the renamed files.
	>	Delete any unprocessed files (IMG_nnnn.JPG)
	>	Browse all files to ensure they cronologically sequenced.

4b.	Move all renamed files. 
	>	Move  from:	C:\Temp\ImageRenamerApplication\bin\Rob_yyyyMMdd_yyyyMMdd
				to:	C:\Grey_Nomad_Media\Image_Files


Notes:
------
1.	This application only processes JPG and MOV files.
	>	Rename .JPEG files to .JPG

