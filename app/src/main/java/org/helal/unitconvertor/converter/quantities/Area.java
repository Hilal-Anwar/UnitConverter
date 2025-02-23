package org.helal.unitconvertor.converter.quantities;
public enum Area{
    square_metre(1), hectare(10000), square_mile(2.59e+6), acre(4046.86),
    square_yard(0.836127), square_foot(0.092903), square_inch(0.00064516), square_nautical_mile(3.43e+6),
    dunam(1000), tsubo(3.30579), pyeong(3.30579), cuerda(3930);
    private final double v;
    Area(double v) {
        this.v = v;
    }

    public double getV() {
        return this.v;
    }
}
