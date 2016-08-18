package com.poc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by poc on 8/17/16.
 */
public class ConversionsTextFile {
    private final String conversionFileName = "conversion_types.txt";
    private Path conversionFilePath = null;
    private File conversionFile = null;
    private Scanner userInput;
    private ArrayList<Conversion> conversionList = new ArrayList<Conversion>();


    public ArrayList<Conversion> getConversions() {
        conversionFilePath = Paths.get(conversionFileName);
        conversionFile = conversionFilePath.toFile();

        if (Files.exists(conversionFilePath))  // prevent the FileNotFoundException
        {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(conversionFile))) {
                String line = in.readLine();
                while (line != null) {
                    addNewConversion(line);
                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return conversionList;
    }

    public ArrayList<Conversion> addNewConversion(String line) {
        String[] toks = line.split(":");
        Conversion newConversion = new Conversion(toks[0],
                Double.parseDouble(toks[1]));
        conversionList.add(newConversion);
        return conversionList;
    }

    public boolean saveConversions(){
        File outfile = new File(conversionFileName);
        PrintWriter out = null;
        try {
            // open output stream for overwriting
            out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(outfile)));
            for (Conversion p : conversionList) {
                out.println(p);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        } finally {
            this.close(out);
        }
        return true;
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
