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

    static public void readJSONFile() throws FileNotFoundException {
//        JSONParser parser = new JSONParser();
        Gson gson = new Gson();

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(new FileReader("./data.json")).getAsJsonArray();
        System.out.println(array);
//        gson.fromJson();



    }
}
