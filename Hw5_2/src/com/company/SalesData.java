package com.company;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;

/**
 * Created by poc on 8/7/16.
 */
public class SalesData {

    static public JsonArray readJSONFile() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray  reports_by_region = parser.parse(new FileReader("./resources/data.json")).getAsJsonArray();
        return reports_by_region;

    }
}
