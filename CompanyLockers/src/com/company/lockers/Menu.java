package com.company.lockers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Menu {
	
	//Components
	DisplayFiles display = new DisplayFiles();
	CreateFiles  create  = new CreateFiles();
	DeleteFiles  delete  = new DeleteFiles();
	SearchFiles  search  = new SearchFiles();
	
	//Variables
	int userInput;
	Path path = Paths.get("./Files");
	
	//Reader
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader    br  = new BufferedReader(isr);
	
	//Display menu
	public void printMenu() throws IOException {
		
		System.out.println("************************************");
		System.out.println("*\tWelcome to LockedMe\t   *");
		System.out.println("************************************");
		
		System.out.println("* Developer: Yannick Vollmer  v1.0 *");
		System.out.println("************************************");
		
		System.out.println(" - Display all files [1]");
		
		System.out.println("\tSelect an option");
		System.out.println("\t----------------");
		
		System.out.println();
		
		System.out.println(" - Display all files [1]");
		System.out.println(" - Create new files  [2]");
		System.out.println(" - Delete files      [3]");
		System.out.println(" - Search files      [4]");
		System.out.println(" - Exit              [5]");
		
		System.out.println();
		
		System.out.print(" Enter your choice > ");
		
		
		//Get first User Input
		while(true) {
			try {
				userInput = Integer.parseInt(br.readLine());
				if(userInput >= 1 && userInput <= 5)
					if(Files.exists(path)) {
						break;
					} else {
						System.err.println("No Files exist yet! Please create one first!");
						throw new IOException();
					}
			} catch(IOException | NumberFormatException e) {
				System.err.println("Input not accepted! Please Enter a value of 1 - 5!\n");
				printMenu();
			}
		}
				
		//Run actions dependent on userInput
		switch(userInput) {
		case 1:
			display.displayAllFiles();
			printMenu();
			break;
		case 2: 
			create.createFiles();
			printMenu();
			break;
		case 3: 
			delete.deleteFiles();
			printMenu();
			break;
		case 4:
			search.searchFiles();
			printMenu();
			break;
		case 5:
			exit();
			break;
		default:
			System.err.println("Something went wrong!");
		}
	}
	
	//Close Application
	public static void exit() {
		System.exit(0);
	}
}
