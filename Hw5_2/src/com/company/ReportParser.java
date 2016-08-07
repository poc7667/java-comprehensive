package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.sun.deploy.util.StringUtils;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by poc on 8/7/16.
 */
public class ReportParser {
    private final int NUM_OF_ROW = 4;
    private final int NUM_OF_COL = 4;
    private double[][] hardCodedData = new double[NUM_OF_ROW][NUM_OF_COL];
    private Gson gson = new Gson();
    private ArrayList<RegionReport> regions = new ArrayList<RegionReport>(NUM_OF_ROW);
    private Locale locale = new Locale("en", "US");
    private NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

    public void doTask() {
        // write your code here
        JsonArray returnRegions = readRegions();
        setupData(returnRegions);
        showFirstSection();
        showSalesByRegion();
        showSalesByQuarter();
        showTotal();
    }

    private JsonArray readRegions() {
        JsonArray returnRegions = null;
        try {
            returnRegions = SalesData.readJSONFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return returnRegions;
    }

    private void setupData(JsonArray returnRegions) {
        int row = 0;
        for (JsonElement i : returnRegions) {
            RegionReport report = gson.fromJson(i, RegionReport.class);
            for (int col = 0; col < report.quarterly_report.length; col++) {
                hardCodedData[row][col] = report.quarterly_report[col];
            }
            row += 1;
        }
//        System.out.println(Arrays.deepToString(hardCodedData));
    }

    private void showFirstSection() {
        String header = String.format("%-12s %-12s %-12s %-12s %-12s",
                "Region",
                "Q1", "Q2", "Q3", "Q4");
        System.out.println(header);
        for (int i = 0; i < hardCodedData.length; i++) {
            ArrayList<String> toks = new ArrayList<String>();
            toks.add(String.format("%-12s ", i+1));
            for (int j = 0; j < hardCodedData[i].length; j++) {
                toks.add(String.format("%-12s ", fmt.format(hardCodedData[i][j])));
            }
            System.out.println(StringUtils.join(toks, ""));
        }
    }

    private void showSalesByRegion() {
        System.out.println("\nSales by region:");
        for (int i = 0; i < hardCodedData.length; i++) {
            double sum = 0;
            for (double val : hardCodedData[i]) {
                sum += val;
            }
            System.out.printf("Region %d: %-12s\n", i+1, fmt.format(sum));
        }
    }

    private void showSalesByQuarter() {
        System.out.println("\nSales by Quarter:");
        for (int i = 0; i < NUM_OF_COL; i++) {
            double sum = 0;
            for (int j = 0; j < NUM_OF_ROW; j++) {
                sum += hardCodedData[j][i];
            }
            System.out.printf("Quarter %d: %-12s\n", i+1, fmt.format(sum));
        }
    }

    private void showTotal() {
        int sum = 0;
        for (double[] i : hardCodedData) {
            for (double j : i) {
                sum += j;
            }
        }
        System.out.printf("\nTotal Revenue: %-12s\n", fmt.format(sum));

    }
}

















