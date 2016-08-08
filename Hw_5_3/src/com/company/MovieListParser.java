package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by poc on 8/7/16.
 */
public class MovieListParser {

    public JsonObject readFromFile(String filePath) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        return parser.parse(new FileReader(filePath)).getAsJsonObject();
    }
}
