package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/17/16.
 */
public class NumberToWordsConverter_3_4 extends HomeWorkWrapper {
    private Scanner rd = new Scanner(System.in);
    private String userInput = "";
    private int inputNumber = 0;
    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };


    public void execute() {
        boolean validInput = false;
        while (validInput == false) {
            try {
                System.out.print("\nPls input number that you want to convert it into words: ");
                inputNumber = parseUserInputToNumber(rd.nextLine());
                if (inputNumber > 0 && inputNumber < 10000) {
                    validInput = true;
                } else {
                    System.out.println("number range should be >0 and <9999");
                }
            } catch (Exception ex) {
                System.out.println("\nnumber format not invalid");
            }
        }
        System.out.println(processNumberToWords(inputNumber).trim());
    }

    private int parseUserInputToNumber(String userInputString) {
        return Integer.parseInt(userInputString.replace(",", "").trim());
    }

    private String processNumberToWords(int numOfValue) {
        int remainingValue = numOfValue;
        StringBuilder numberInWords = new StringBuilder("");
        while (remainingValue > 0) {
            if (remainingValue >= 1000 && remainingValue < 10000) {
                remainingValue = processThousnad(numberInWords, remainingValue);
            } else if (remainingValue >= 100 && remainingValue < 1000) {
                remainingValue = processHundred(numberInWords, remainingValue);
            } else if (remainingValue >= 10 && remainingValue < 100) {
                remainingValue = processTenth(numberInWords, remainingValue);
            } else {
                numberInWords.append(numNames[remainingValue]);
                remainingValue = -1;
            }
        }
        return numberInWords.toString();
    }

    private int processThousnad(StringBuilder words, int value) {
        words.append(numNames[value / 1000] + " thousand");
        return value % 1000;
    }

    private int processHundred(StringBuilder words, int value) {
        words.append(numNames[value / 100] + " hundred");
        return value % 100;
    }

    private int processTenth(StringBuilder words, int value) {
        if (value > 20) {
            words.append(tensNames[value / 10]);
            return value % 10;
        } else {
            words.append(numNames[value]);
            return 0;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        NumberToWordsConverter_3_4 converter = new NumberToWordsConverter_3_4();
        worker.doIt(converter, "Convert another number? (y/n)", "C ya!");
    }


}
