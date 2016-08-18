package com.poc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by poc on 8/17/16.
 */
public class ConversionsApp {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Conversion> conversionList = new ArrayList<Conversion>();
    ConversionsTextFile txtFile = null;
    private int menuChoiceNumber = -1;

    private String[] menu = {"Convert a length",
            "Add a type of conversion",
            "Delete a type of conversion",
            "Exit",
    };

    public int getChosenFromMenu(){
        System.out.printf("\n");
        for(int i=0; i < menu.length; i++){
            System.out.printf("%d - %s\n", i+1, menu[i]);
        }
        return Validator.getInt(sc, "\nEnter menu number: ", 0, 5);
    }

    public ConversionsApp(){
        txtFile = new ConversionsTextFile();
        conversionList  = txtFile.getConversions();
    }

    public void doTask(){
        menuChoiceNumber = getChosenFromMenu();
        while(menuChoiceNumber!=4){
            performTask(menuChoiceNumber);
            menuChoiceNumber = getChosenFromMenu();
        }
        txtFile.saveConversions();
        System.out.printf("\nGood bye\n");
    }

    public void performTask(int userChoice){
        switch (userChoice){
            case 1:
                doConvertLength();
                break;
            case 2:
                addConversion();
                break;
            case 3:
                removeConversion();
                break;
        }
    }

    private void addConversion(){
        String fromUnit = Validator.getString(sc, "Enter 'From' unit: ");
        String toUnit = Validator.getString(sc, "Enter 'To' unit: ");
        String conversionRate = Validator.getString(sc, "Enter the conversion ratio: ");
        txtFile.addNewConversion(String.format("%s to %s: %s",fromUnit, toUnit, conversionRate));
    }

    private void doConvertLength(){
        showConversionList();
        int conversionChoice = Validator.getInt(sc, "Enter Conversion number", 0, conversionList.size()+1) -1 ;
        String fromUnit = conversionList.get(conversionChoice).getName().split(" ")[0];
        String ToUnit = conversionList.get(conversionChoice).getName().split(" ")[2];
        double convertRation = conversionList.get(conversionChoice).getConvertionRate();
        String prompt = String.format("Enter %s: ", fromUnit);
        double valueToConvert = Validator.getInt(sc, prompt, 0, 999999);
        System.out.printf("%f %s = %f %s\n", valueToConvert,fromUnit, valueToConvert * convertRation , ToUnit);
    }

    private void showConversionList(){
        int i=1;
        for(Conversion item: conversionList  ){
            System.out.printf("%d - %s:%f\n", i, item.getName(), item.getConvertionRate());
            i++;
        }
    }

    private void removeConversion(){
        int choice = Validator.getInt(sc, "\nEnter a number to delete a conversion: ", 0, conversionList.size()+1)-1;
        conversionList.remove(choice);
    }

    public static void main(String[] args) {
        ConversionsApp app = new ConversionsApp();
        app.doTask();
    }
}
