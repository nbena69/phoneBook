package com.nbena.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {
	public static Scanner scanner = null;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);

			String userLastName    = getUserInput("Entrez un nom de famille : ");
			String userFirstName   = getUserInput("Entrez un prénom : ");
			String userPhoneNumber = getUserInput("Entrez un numéro de tél : ");

			Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);
			
			System.out.println(newContact.toString());
			
			File phoneBookFile = new File("C:\\Users\\naelb\\eclipse-workspace\\nbena-test\\phoneBook.txt");
			
			if(phoneBookFile.exists()) {
				System.out.println("Le fichier existe");
			} else {
				System.out.println("Le fichier n'existe pas");
				try {
					phoneBookFile.createNewFile();
					System.out.println("Le fichier a était créer");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try {
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true));
				fileWriter.append(newContact.toString()+ '\n');
				System.out.println("Contact ajouté");
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			scanner.close();
	}
	
	public static String getUserInput(String userRequest) {
		System.out.println(userRequest);
		return scanner.nextLine();
	}
}