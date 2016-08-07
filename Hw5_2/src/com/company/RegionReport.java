package com.company;

import com.sun.deploy.util.StringUtils;
import com.sun.javafx.binding.DoubleConstant;
import com.sun.javafx.binding.StringFormatter;

/**
 * Created by poc on 8/7/16.
 */
public class RegionReport {
    int region;
    double[] quarterly_report;

    @Override
    public String toString() {
        String report = "";
        for(double i: quarterly_report){
            report+= Double.toString(i)+" : ";
        }

        return String.format("Region %d, Quarter: %s",
                region, report);
    }
}
