package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("You can modify input data in this file 'data.json' under reosurces folder");
        ReportParser rp = new ReportParser();
        rp.doTask();
    }
}
