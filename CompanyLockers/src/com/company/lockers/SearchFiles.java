package com.company.lockers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchFiles {

	public void searchFiles() throws IOException {
		
		//Variables
		String userInput;
		
		//Reader
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader    br  = new BufferedReader(isr);
		
		while(true) {
			System.out.print("\nPlease enter Filename for search: ");
			userInput = br.readLine();
			userInput += ".txt";
			
			//Create path to file
			Path path = Paths.get("./Files/" + userInput);
			File file = new File("./Files/" + userInput);
			
			//Check if file exists - if yes delete if not try again
			if(Files.exists(path)) {
					System.out.println("\nFile found: ");
					System.out.println(file.getName());
					System.out.println("\nContent of file: ");
					
					FileReader fr  = new FileReader(file);
					@SuppressWarnings("resource")
					BufferedReader fbr = new BufferedReader(fr);
					
					String line;
					while((line = fbr.readLine()) != null) {
						System.out.println(line);
					}
					System.out.println();
					break;
			} else {
				System.err.println("Failed to delete file!");
				continue;
			}
		}
	}
}
