package org.helal.unitconvertor.converter.quantities;

public enum Density {
    kilogram_per_cubic_meter(1.0),
    gram_per_cubic_meter(0.001),
    slug_per_cubic_centimeter(515.4),
    pound_per_cubic_foot(16.02),
    pound_per_cubic_inch(27680.0);
    private final double v;

    Density(double v) {
        this.v = v;
    }

    public double getV() {
        return this.v;
    }
}
