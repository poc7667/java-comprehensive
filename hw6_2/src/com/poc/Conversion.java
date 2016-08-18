package com.poc;

import java.util.ArrayList;

public class Conversion {

    private String name = null;
    private double convertionRate = 0;

    public Conversion(String name, double conversionRate){
        setName(name);
        setConvertionRate(conversionRate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConvertionRate() {
        return convertionRate;
    }

    public void setConvertionRate(double convertionRate) {
        this.convertionRate = convertionRate;
    }

    @Override
    public String toString() {
        return String.format("%s:%f", getName(), getConvertionRate());
    }
}
