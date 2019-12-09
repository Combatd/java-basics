package com.ga.superhero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static List<Superhero> superheroes = new ArrayList<Superhero>();

	public static void main(String[] args) {
		
		try {
			readFile("input.txt");
		} catch (IOException e) {
			System.out.println("Error while reading the file: " + e.getMessage());
		}
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your superhero name.");
		String name = scanner.nextLine();
		
		String result = playGame();
		
		try {
			writeFile("output.txt", name, result);
		} catch (IOException e) {
			System.out.println("Error while writing into the file: " + e.getMessage());
		}
		
	}
	
	public static void writeFile(String fileName, String name, String result) throws IOException {
		File file = new File(fileName);
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(name+","+result);
		}
		finally {
			writer.close();
		}
	}
	
	public static String playGame() {
		int right = 0, wrong = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		for(Superhero superhero : superheroes) {
			System.out.println("What is " + superhero.getSuperheroName() + "'s real name?");
			String realName = scanner.nextLine();
			if(superhero.getRealName().equalsIgnoreCase(realName))
				right++;
			else {
				wrong++;
				System.out.println("oops! Wrong answer. " + superhero.getSuperheroName() + " is so dissapointed.");
			}
			
			System.out.println("What is " + superhero.getSuperheroName() + "'s place of birth?");
			String place = scanner.nextLine();
			if(superhero.getPlaceOfBirth().equalsIgnoreCase(place))
				right++;
			else {
				wrong++;
				System.out.println("oops! Wrong answer. " + superhero.getSuperheroName() + " is so dissapointed.");
			}
		}
		
		if(right > wrong) {
			System.out.println("Yay!! You won the game.");
			return "won";
		}
		else {
			System.out.println("Sorry you lost the game.");
			return "lost";
		}
	}
	
	
	public static void readFile(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			
			String currentLine = reader.readLine();
		    
		    while(currentLine != null) {
		    	Superhero superhero = new Superhero();
		    	String[] data = currentLine.split(",");
		    	superhero.setSuperheroName(data[0]);
		    	superhero.setRealName(data[1]);
		    	superhero.setPlaceOfBirth(data[2]);
		    	superheroes.add(superhero);
		    	currentLine = reader.readLine();
		    }
		} finally {
			reader.close();
		}
	}

}
