package com.poc;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by poc on 7/17/16.
 */
public class PigLatin_3_3 extends HomeWorkWrapper {

    private Scanner rd = new Scanner(System.in);
    private String userInputLine = "";
    private String[] inputTokens;
    private char[] consonant_chars = "bcdfghjklmnpqrstvwxyz".toCharArray();
    private char[] vowel_chars = "aeiou".toCharArray();

    public PigLatin_3_3() {
    }


    private String[] processTokens(String[] tokens) {
        StringBuffer strBuf = new StringBuffer();
        System.out.println();
        for (int i = 0; i < tokens.length; i++) {
            String tok = tokens[i].toLowerCase();
            strBuf.append(convertToken(tok) + " ");
        }
        System.out.println();
        System.out.println(strBuf);
        return tokens;
    }

    private String convertToken(String token) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9\']");
        boolean hasSpecialChar = p.matcher(token).find();
        if (hasSpecialChar) {
            return token;
        } else if (isVowel(token, 0)) {
            return processVowel(token);
        } else if (isConsonant(token, 0)) {
            return processConsonant(token);
        }

        return token;
    }

    private boolean isVowel(String token, int charIndex) {
        return (new String(vowel_chars).indexOf(token.charAt(charIndex)) == -1) ? false : true;
    }

    private boolean isConsonant(String token, int charIndex) {
        return (new String(consonant_chars).indexOf(token.charAt(charIndex)) == -1) ? false : true;
    }

    private String processVowel(String token) {
        return token + "way";
    }

    private String swapSubString(String token, int charIndex) {
        String endOfToken = token.substring(0, charIndex);
        String startOfToeken = token.substring(charIndex, token.length());
        return startOfToeken + endOfToken;
    }

    private String processConsonant(String token) {
        int indexOfNotConsonant = 0;
        for (indexOfNotConsonant = 0; indexOfNotConsonant < token.length(); indexOfNotConsonant++) {
            if (isVowel(token, indexOfNotConsonant)) {
                break;
            } else {
                continue;
            }
        }
//        System.out.println(token + indexOfNotConsonant);
        String swappedToken = swapSubString(token, indexOfNotConsonant);
        return swappedToken + "ay";
    }

    public void execute() {
        System.out.println("Enter a line to be translated to Pig Latin:");
        userInputLine = rd.nextLine();
        inputTokens = userInputLine.split("\\s+");
        processTokens(inputTokens);
//        processTokens("can't".split("\\s+"));
//        processTokens("123".split("\\s+"));
//        processTokens("bill@micronsoft.com".split("\\s+"));
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        PigLatin_3_3 this_instance = new PigLatin_3_3();
        worker.doIt(this_instance, "Translate another line (y/n)?", "C you!");
    }

}
