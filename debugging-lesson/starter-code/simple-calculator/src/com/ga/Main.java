package com.ga;

import java.util.Scanner;

/**
 * Created by drewmahrt on 5/4/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== CALCULATOR ===\n");
        System.out.println("Choose an operation: \n1. add\n2. subtract\n3. multiply\n4. divide\n");

        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();

        if(answer.equals("1") || answer.equals("add")){
            add();
        } else if(answer.equals("2") || answer.equals("subtract")){
            subtract();
        } else if(answer.equals("3") || answer.equals("multiply")){
            multiply();
        } else if(answer.equals("4") || answer.equals("divide")){
            divide();
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static String getInput(String context){
        System.out.print(context+": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean isInt(String s){
        Scanner scanner = new Scanner(s);
        return scanner.hasNextInt();
    }

    public static void add(){
        String firstInput = getInput("First number");
        String secondInput = getInput("Second number");

        // We can check to see if the string is either an int or a float, and then parseInt or parseFloat depending
//        int num1, num2;
        if (isInt(firstInput)&& isInt(secondInput)) {
//            num1 = Integer.parseInt(firstInput);
//            num2 = Integer.parseInt(secondInput);
//            int result = num1 + num2;
//            System.out.println("Result: "+result);
            int result = Integer.parseInt(firstInput) + Integer.parseInt(secondInput);
            System.out.println("Result: "+result);
        }
        else{
            System.out.println("You must enter NUMBERS!");
        }
    }

    public static void subtract(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum - secondNum;
        System.out.println("Result: "+result);
    }

    public static void multiply(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum + secondNum;
        System.out.println("Result: "+result);
    }

    public static void divide(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        float result = firstNum / secondNum;
        System.out.println("Result: "+result);
    }
}


