package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String isContinue = "y";
        MovieAgent movieAgent = new MovieAgent("./resources/movie_list.json");
        do{
            movieAgent.pickRecommendList(movieAgent.getValidChoice(sc));
            System.out.printf("Continue? (y/n):");
            isContinue = sc.nextLine();
        }while (isContinue.trim().toLowerCase().equals("y"));

//        System.out.println();
    }
}

