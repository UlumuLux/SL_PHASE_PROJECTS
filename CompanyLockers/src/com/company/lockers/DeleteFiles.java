package com.company.lockers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFiles {
	
	//Variables
	String userInput;
	
	//Reader
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader    br  = new BufferedReader(isr);
	
	public void deleteFiles() throws IOException {
		
		while(true) {
			System.out.print("\nPlease enter Filename of file you want to delete: ");
			userInput = br.readLine();
			userInput += ".txt";
			
			//Create path to file
			Path path = Paths.get("./Files/" + userInput);
			File file = new File("./Files/" + userInput);
			
			//Check if file exists - if yes delete if not try again
			if(Files.exists(path)) {
				if(file.delete()) {
					System.out.println("File successfully deleted!");
					break;
				} 
			} else {
				System.err.println("\nFailed to delete file!");
				continue;
			}
		}
	}
}
