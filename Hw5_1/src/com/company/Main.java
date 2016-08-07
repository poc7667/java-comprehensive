package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();
        int numOfStudents = 0;
        final int MIX_SCORE = 0;
        final int MAX_SCORE = 100;
	
        System.out.println("Scores Application");
        numOfStudents = validator.getIntWithinRange(sc, "Enter number of students :", 0, 100);
        Student[] students = new Student[numOfStudents];
        for(int i=0; i < numOfStudents;i++){
            students[i] = new Student();
            String promptPrefix = String.format("Student %d ", i+1);
            System.out.printf(promptPrefix+" last name:");
            students[i].setLastName(sc.nextLine().trim());
            System.out.printf(promptPrefix+" first name:");
            students[i].setFirstName(sc.nextLine().trim());
            String  enterScorePrompt = promptPrefix + "scores:";
            students[i].setScore(validator.getIntWithinRange(sc,
                    enterScorePrompt,
                    MIX_SCORE,
                    MAX_SCORE));
        }
        Arrays.sort(students);
        for(Student i: students){
            System.out.println(i);
        }

    }
}
