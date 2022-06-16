package com.company.lockers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DisplayFiles {
	
	public void displayAllFiles() {
		//Create path to Files-Folder
		Path path = Paths.get("./Files");
		
		//Check if folder exists
		if(Files.exists(path)) {
			//Get all files in folder
			File[] files = new File("./Files").listFiles();
			
			if(files.length <= 0) {
				System.out.println("\nNo files exist yet!\n");
			} else {
				//Print all filenames
				System.out.println();
				for(File file : files) {
					System.out.println(file.getName());
				}
				System.out.println();
			}
		} else {
			//Create folder
			new File("./Files").mkdirs();
			System.out.println("\nNo files exist yet!\n");
		}
	}
}
