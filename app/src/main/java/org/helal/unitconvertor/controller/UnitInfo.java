package org.helal.unitconvertor.controller;

public class UnitInfo {

    private String unit_name;
    private double value;

    public UnitInfo(String unit_name, double value) {
        this.value = value;
        this.unit_name = unit_name;
    }


    public String getUnit_name() {
        return unit_name;
    }

    public double getValue() {
        return value;
    }


}
