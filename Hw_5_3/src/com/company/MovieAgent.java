package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by poc on 8/7/16.
 */
public class MovieAgent {

    String[] categories = {"animated", "drama", "horror", "scifi"};
    HashMap<String, TreeMap> movieDB = new HashMap<String, TreeMap>();
    MovieListParser parser = new MovieListParser();

    public MovieAgent(String filePath) throws FileNotFoundException {
        prepareMovieDB(filePath);
    }

    private void prepareMovieDB(String filePath) throws FileNotFoundException {
        JsonObject movieList = parser.readFromFile(filePath);
        for(String category: categories){
            TreeMap<Movie, String> treemap = new TreeMap<Movie, String>();
            JsonArray movieTitles = movieList.get(category).getAsJsonArray();
            for(JsonElement title: movieTitles){
                if(title.toString().length()> 1){
                    Movie movie = new Movie(title.toString(), category);
                    treemap.put(movie, title.toString());
                }
            }
            movieDB.put(category,treemap);
        }
    }

    public void pickRecommendList(String category){
        Iterator drama = movieDB.get(category).keySet().iterator();
        while(drama.hasNext()){
            TreeMap<Movie, String> list = movieDB.get(category);
            System.out.println(list.get(drama.next()).toString());
        }
    }

    public static boolean contains(String[] arr, String item) {
        return Arrays.stream(arr).anyMatch(item::equals);
    }

    public String getValidChoice(Scanner sc){
        boolean isValid=false;
        String userInput = "";
        do{
            System.out.printf("Which category are you interested in?");
            userInput = sc.nextLine();
            if(contains(categories, userInput)){
                isValid = true;
            }else{
                System.out.println("Invalid category, try again!");
            }
        }while (!isValid);

        return userInput;
    }


}
