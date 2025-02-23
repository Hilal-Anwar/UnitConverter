package org.helal.unitconvertor.converter.quantities;

public enum Temperature {
    kelvin(9 / 5.0, -9.0 / 5 * 273 + 32), degree_Celsius(9 / 5.0, 32),
    degree_Rankine(1, 459.67), degree_Fahrenheit(1, 0);


    private final double v;
    private final double c;

    Temperature(double v, double c) {
        this.v = v;
        this.c = c;
    }

    public double getV() {
        return this.v;
    }

    public double getC() {
        return c;
    }
}
