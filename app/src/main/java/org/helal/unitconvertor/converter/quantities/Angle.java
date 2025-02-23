package org.helal.unitconvertor.converter.quantities;

public enum Angle
{
    Degree(1.0),Radian(57.295779513082323402053960025447),Grade(1.1111111);
    private final double v;
    Angle(double v) {
        this.v=v;
    }
    public double getV() {
        return this.v;
    }
}
