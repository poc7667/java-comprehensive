package com.company;

import java.util.Scanner;

/**
 * Created by poc on 8/7/16.
 */
public class Student implements Comparable{

    private String lastName="";
    private String firstName="";
    private int score = 0;
    Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();

    public  String getLastName() {
        return lastName;
    }

    public  void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public  String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public  int getScore() {
        return score;
    }

    public  void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %d", firstName, lastName, score);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student i = (Student) o;
            if(this.getScore() > i.getScore()){
                return 1;
            }else  if(this.getScore() < i.getScore()){
                return -1;
            }else{
                return 0;
            }
        }
        return 0;
    }
}
