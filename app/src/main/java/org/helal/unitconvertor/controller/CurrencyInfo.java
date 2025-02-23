package org.helal.unitconvertor.controller;

public class CurrencyInfo {
    private String unit_code;
    private String unit_name;

    public CurrencyInfo(String unit_code, String unit_name) {
        this.unit_code = unit_code;
        this.unit_name = unit_name;
    }

    public String getUnit_code() {
        return unit_code;
    }

    public void setUnit_code(String unit_code) {
        this.unit_code = unit_code;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }
}
