package com.company;

import java.util.ArrayList;

/**
 * Created by poc on 8/17/16.
 */
public class CountriesApp {
    private String[] menus = {"List countries", "Add a country", "Exit"};
    private ArrayList<String> contryList = new ArrayList<String>(){{
        add("India");
        add("Japan");
        add("Mexico");
        add("Spain");
        add("United States");
    }};

    public void showMenu(){
        for(String item: menus){
            System.out.println(item);
        }
    }
    public ArrayList<String> getCountries(){
        return contryList;
    }

    public void showCountries(){
        contryList.forEach(item ->
                System.out.println(item)
        );
    }

}
