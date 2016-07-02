package com.poc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by poc on 7/2/16.
 */
public class ForEachTest {



    public static void main(String[] args) {
        System.out.println("hihi");
        List<String> names = new LinkedList<String>();
        names.add("poc");
        names.add("stef");
        names.forEach(name-> System.out.println("yoyo:"+name));

    }
}
