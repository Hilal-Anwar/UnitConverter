package org.helal.unitconvertor.converter;


import org.helal.unitconvertor.converter.quantities.Metric;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Converter {

    public <T extends Enum<T>> double convertTo(double value, T unit1, T unit2) {
        double m1 = 0, m2 = 0, c1 = 0, c2 = 0;
        try {
            m1 = (double) Objects.requireNonNull(unit1.getClass().getMethod("getV").invoke(unit1));
            m2 = (double) Objects.requireNonNull(unit2.getClass().getMethod("getV").invoke(unit2));

            c1 = (double) Objects.requireNonNull(unit1.getClass().getMethod("getC").invoke(unit1));
            c2 = (double) Objects.requireNonNull(unit2.getClass().getMethod("getC").invoke(unit2));
        } catch (IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException ignored) {
        }
        return (value * m1 + c1 - c2) / m2;
    }

    public <T extends Enum<T>> double convertTo(double value, Metric u1, T unit1, Metric u2, T unit2) {
        return convertTo(value * u1.getV(), unit1, unit2) / u2.getV();
    }
}
