package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by poc on 8/17/16.
 */
public class CountriesApp {
    private final String countryFileName = "countries.txt";
    private String[] menus = {"List countries", "Add a country", "Delete a country", "Exit"};
    private ArrayList<String> contryList = null;
    private Path countriesFilePath = null;
    private File contriesFile = null;
    private Scanner userInput = new Scanner(System.in);


    public CountriesApp() {
        this.readTextFile();
    }



    private void readTextFile() {

        countriesFilePath = Paths.get(countryFileName);
        contriesFile = countriesFilePath.toFile();

        if (Files.exists(countriesFilePath))  // prevent the FileNotFoundException
        {
            contryList = new ArrayList<String>();
            try (BufferedReader in = new BufferedReader(
                    new FileReader(contriesFile))) {
                String line = in.readLine();
                while (line != null) {
                    contryList.add(line.trim());
                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            contryList = new ArrayList<String>() {{
                add("India");
                add("Japan");
                add("Mexico");
                add("Spain");
                add("United States");
            }};
        }
    }

    public void doTask() {
        showMenu();
        int choice = getMenuChoice();
        while (true) {
            switch (choice) {
                case 1:
                    System.out.println();
                    for (int i = 0; i < getCountries().size() ; i++) {
                        System.out.printf("%s\n", getCountries().get(i));
                    }
                    break;
                case 2:
                    addCountry();
                    break;
                case 3:
                    removeFromCountryList();
                    break;
            }
            if ( menus.length != choice) {
                choice = getMenuChoice();
            } else {
                SaveCountriesToFile();
                System.out.println("Good Bye");
                break;
            }
        }
    }

    public void showMenu() {
        for (int i = 0; i < menus.length ; i++) {
            System.out.printf("%d: %s\n", i + 1, menus[i]);
        }
    }

    private void removeFromCountryList() {
        String country = Validator.getString(userInput, "\nEnter a country name that you want to delete: ");
        boolean hasDeletedFlag = false;
        for (String item : getCountries()) {
            if (country.equals(item)) {
                contryList.remove(item);
                hasDeletedFlag = true;
            }
        }

        if (!hasDeletedFlag) {
            System.out.printf("\nCan not found %s from country list", country);
        }

    }

    private int getMenuChoice() {
        return Validator.getInt(userInput, "\nEnter menu Number: ", 1 - 1, getCountries().size() + 1);
    }

    public ArrayList<String> getCountries() {
        return contryList;
    }

    private void addCountry() {
        String country = Validator.getString(userInput, "\nEnter country: ");
        contryList.add(country);
        System.out.printf("\nThis country: %s has been save.\n", country);
    }

    private void SaveCountriesToFile() {
        File outfile = new File(countryFileName);
        PrintWriter out = null;
        try {
            // open output stream for overwriting
            out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(outfile)));
            for (String p : getCountries()) {
                out.println(p);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            this.close(out);
        }
    }


    private void close(Closeable stream) {
        try {
            if (stream != null)
                stream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }



}
