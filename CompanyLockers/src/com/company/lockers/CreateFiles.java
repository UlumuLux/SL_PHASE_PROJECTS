package com.company.lockers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateFiles {
	
	//Variables
	String filename;
	String content = "";
	
	//Reader
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader    br  = new BufferedReader(isr);
	
	//Get Folder content
	File[] files = new File("./Files").listFiles();
	
	public void createFiles() throws IOException {
		
		while(true) {
			//Get file values
			System.out.println();
			System.out.print("Enter filename: ");
			filename = br.readLine();
			
			//Check if file already exists
			boolean check = true;
			while(check) {
				if(files.length <= 0) {
					break;
				}
				for(File file : files) {
					if(file.getName().equals(filename + file.getName().substring(file.getName().lastIndexOf('.')))) {
						System.err.println("File already exists!");
						System.out.print("Enter new filename: ");
						filename = br.readLine();
					} else {
						check = false;
					}
				}
			}
			
			//Read user input for file content until user enters specific string
			System.out.print("Enter File Content (End input by typing 'end:input' and hit enter): ");
			String line;
			while(!(line = br.readLine()).equals("end:input")) {
				content += line + "\n";
			}
			
			//Create file
			File newFile = new File("./Files/" + filename + ".txt");
			
			//Writer
			FileWriter fw = new FileWriter(newFile, false);
			
			//Write content to file
			fw.write(content);	
			fw.close();
			
			//Check if user wants to create another file
			System.out.print("\n Do you want to create another file? (y/n): ");
			if(br.readLine().equals("y")) {
				continue;
			} else {
				return;
			}
		}
		
	}
	
}
