package com.poc;

import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Created by poc on 7/16/16.
 */
public class Worker {
    private static Scanner rd = new Scanner(System.in);

    public void doIt(HomeWorkWrapper child){
        String isContinue="y";
        do{
            child.execute();
            System.out.printf("continue? (y/n)");
            isContinue = rd.next();
        } while (isContinue.compareToIgnoreCase("y") == 0);
        System.out.println();
        System.out.println("Good bye!! See u soon");
    }

    public void doIt(HomeWorkWrapper child, String continueMsg, String goodByeMsg){
        String isContinue="y";
        do{
            child.execute();
            System.out.print(continueMsg);
            isContinue = rd.next();
            rd.nextLine();
        } while (isContinue.compareToIgnoreCase("y") == 0);
        System.out.println();
        System.out.println(goodByeMsg);
    }

}
