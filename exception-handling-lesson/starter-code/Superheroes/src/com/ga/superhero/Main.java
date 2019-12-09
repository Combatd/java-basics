package com.ga.superhero;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

public class Main {

	private static String name;
	private static List<String[]> questions = new ArrayList<>();;
    private static List<Boolean> answersCorrect;
	private static List questionsHistory;
    private static List answersHistory;
    private static List correctAnswersHistory;


	private static List importQuestions(String path) throws IOException{
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(path)));
			String line = reader.readLine();
			while (line != null) {
				String[] q = line.split("\\? ", 2);
				questions.add(q);
				line = reader.readLine();
			}
		} finally {
            reader.close();
        }
		return questions;
	}

    public static void writeResults(String path) throws IOException{
        String quizResult = "";
        quizResult += ("Results for " + name + "\n");
        for (int i = 0; i < questionsHistory.size(); i++) {
            String qResult = "Question " + i + " (" + ((answersCorrect.get(i)) ? "correct" : "incorrect") + "). " + questionsHistory.get(i) + "? Your answer was " +
                    answersHistory.get(i) + " and the correct answer was " + correctAnswersHistory.get(i);
            quizResult += (qResult + "\n");
        }
        List answersCorrectInt = answersCorrect.stream().map(x->(x?1:0)).collect(Collectors.toList());
        int sum = answersCorrectInt.stream().mapToInt(num->(int)num).sum();
        quizResult +="You have " + ((sum >= answersCorrect.size() / 2) ? "won!" : "lost!");
        System.out.println(quizResult);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(path)));
            writer.write(quizResult);
        }
        finally {
            writer.close();
        }
    }

    private static String getInput(String context){
		System.out.print(context+": ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static void main(String[] args) {
        try {
            questions = importQuestions("input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        answersCorrect = new ArrayList();
        questionsHistory = new ArrayList();
        answersHistory = new ArrayList();
        correctAnswersHistory = new ArrayList();
		name = getInput("What is your name?");

		for (String[] question: questions) {
		    if (question.length == 2) {
		        questionsHistory.add(question[0]);
                String answer = getInput(question[0]);
                answersHistory.add(answer);
                correctAnswersHistory.add(question[1]);
                boolean answerCorrect = answer.toLowerCase().equals(question[1].toLowerCase());
                answersCorrect.add(answerCorrect);
            }
		}
        System.out.println(answersCorrect);
		try {
            writeResults("/Users/davisallen/mindroot/txtmindroot/projects/generalassembly/javatraining/instructional-repos/foundational-java/java-basics/exception-handling-lesson/starter-code/Superheroes/output.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
	}
	
}
