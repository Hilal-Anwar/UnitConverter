package org.helal.unitconvertor.unitController;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import org.helal.unitconvertor.R;
import org.helal.unitconvertor.controller.SubUnitBottomSheet;
import org.helal.unitconvertor.controller.UnitBottomSheet;
import org.helal.unitconvertor.converter.Converter;
import org.helal.unitconvertor.converter.quantities.Angle;
import org.helal.unitconvertor.converter.quantities.Area;
import org.helal.unitconvertor.converter.quantities.Density;
import org.helal.unitconvertor.converter.quantities.Energy;
import org.helal.unitconvertor.converter.quantities.Force;
import org.helal.unitconvertor.converter.quantities.Length;
import org.helal.unitconvertor.converter.quantities.Mass;
import org.helal.unitconvertor.converter.quantities.Metric;
import org.helal.unitconvertor.converter.quantities.Power;
import org.helal.unitconvertor.converter.quantities.Pressure;
import org.helal.unitconvertor.converter.quantities.Speed;
import org.helal.unitconvertor.converter.quantities.Temperature;
import org.helal.unitconvertor.converter.quantities.Time;
import org.helal.unitconvertor.converter.quantities.Torque;
import org.helal.unitconvertor.converter.quantities.Viscosity;
import org.helal.unitconvertor.converter.quantities.Volume;
import org.helal.unitconvertor.ui.UnitTextFieldLayout;

import java.util.LinkedHashMap;
import java.util.Objects;

public class BuildUnitLayout {
    private final String fieldName;
    private final String unitName;
    private final String subUnitName;
    private final UnitTextFieldLayout textView1;
    private final UnitTextFieldLayout textView2;
    private final TextView mainUnit1, mainUnit2, subUnit1, subUnit2,
            titleLabel1, titleLabel2;
    private final TextInputEditText tt1View, tt2View;
    UnitBottomSheet bottomSheet1, bottomSheet2;
    SubUnitBottomSheet subUnitBottomSheet1, subUnitBottomSheet2;
    Converter converter = new Converter();
    LinkedHashMap<String, Class> cl = new LinkedHashMap<>();

    public BuildUnitLayout(Fragment f, View view, String fieldName,
                           String unitName) {
        this.fieldName = fieldName;
        this.unitName = unitName;
        this.subUnitName = "unit";
        textView1 = view.findViewById(R.id.unitTextFieldLayout1);
        textView2 = view.findViewById(R.id.unitTextFieldLayout2);
        titleLabel1 = textView1.findViewById(R.id.unit_title_lable);
        titleLabel2 = textView2.findViewById(R.id.unit_title_lable);
        subUnit1 = textView1.findViewById(R.id.sub_unit);
        tt1View = textView1.findViewById(R.id.textInputEditText);
        subUnit2 = textView2.findViewById(R.id.sub_unit);
        tt2View = textView2.findViewById(R.id.textInputEditText);
        mainUnit1 = textView1.findViewById(R.id.mian_unit);
        mainUnit2 = textView2.findViewById(R.id.mian_unit);
        init();
        bottomSheet1 = new UnitBottomSheet(this,1);
        bottomSheet2 = new UnitBottomSheet(this,2);
        subUnitBottomSheet1 = new SubUnitBottomSheet(this,1);
        subUnitBottomSheet2 = new SubUnitBottomSheet(this,2);
        getMainUnit1().setOnClickListener(c -> {
            bottomSheet1.show(f.requireActivity().getSupportFragmentManager(), "loading data ....");

        });
        getMainUnit2().setOnClickListener(c -> {
            bottomSheet2.show(f.requireActivity().getSupportFragmentManager(), "loading data ....");

        });
        getSubUnit1().setOnClickListener(c -> {
            subUnitBottomSheet1.show(f.requireActivity().getSupportFragmentManager(), "loading data ....");

        });
        getSubUnit2().setOnClickListener(c -> {
            subUnitBottomSheet2.show(f.requireActivity().getSupportFragmentManager(), "loading data ....");

        });
        tt1View.setOnKeyListener((v, keyCode, event) -> {
            String s = Objects.requireNonNull(tt1View.getText()).toString();
            if (!s.isEmpty()) {
                String st1 = mainUnit1.getText().toString();
                String st2 = mainUnit2.getText().toString();
                String sut1 = subUnit1.getText().toString();
                String sut2 = subUnit2.getText().toString();
                double x = Double.parseDouble(String.valueOf(tt1View.getText()));
                var b = cl.get(fieldName);
                double val = converter.convertTo(x, Enum.valueOf(Metric.class, sut1), Enum.valueOf(b, st1),
                        Enum.valueOf(Metric.class, sut2), Enum.valueOf(b, st2));
                tt2View.setText(String.valueOf(val));
            }
            return false;
        });
        tt2View.setOnKeyListener((v, keyCode, event) -> {
            String s = Objects.requireNonNull(tt2View.getText()).toString();
            if (!s.isEmpty()) {
                String st1 = getMainUnit1().getText().toString();
                String st2 = getMainUnit2().getText().toString();
                String sut1 = subUnit1.getText().toString();
                String sut2 = subUnit2.getText().toString();
                double x = Double.parseDouble(String.valueOf(tt2View.getText()));
                var b = cl.get(fieldName);
                double val = converter.convertTo(x, Enum.valueOf(Metric.class, sut1), Enum.valueOf(b, st1),
                        Enum.valueOf(Metric.class, sut2), Enum.valueOf(b, st2));
                tt1View.setText(String.valueOf(val));
            }
            return false;
        });

    }

    private void init() {
        titleLabel1.setText(this.fieldName);
        titleLabel2.setText(this.fieldName);
        subUnit1.setText(this.subUnitName);
        subUnit2.setText(this.subUnitName);
        mainUnit1.setText(this.unitName);
        mainUnit2.setText(this.unitName);
        tt1View.setHint(this.unitName);
        tt2View.setHint(this.unitName);
        cl.put("Time", Time.class);
        cl.put("Torque", Torque.class);
        cl.put("Viscosity", Viscosity.class);
        cl.put("Volume", Volume.class);
        cl.put("Angle", Angle.class);
        cl.put("Area", Area.class);
        cl.put("Density", Density.class);
        cl.put("Force", Force.class);
        cl.put("Length", Length.class);
        cl.put("Mass", Mass.class);
        cl.put("Power", Power.class);
        cl.put("Energy", Energy.class);
        cl.put("Pressure", Pressure.class);
        cl.put("Speed", Speed.class);
        cl.put("Temperature", Temperature.class);
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getUnitName() {
        return unitName;
    }

    public String getSubUnitName() {
        return subUnitName;
    }

    public UnitTextFieldLayout getTextView1() {
        return textView1;
    }

    public UnitTextFieldLayout getTextView2() {
        return textView2;
    }

    public TextView getMainUnit1() {
        return mainUnit1;
    }

    public TextView getMainUnit2() {
        return mainUnit2;
    }

    public TextView getSubUnit1() {
        return subUnit1;
    }

    public TextView getSubUnit2() {
        return subUnit2;
    }

    public TextInputEditText getTt1View() {
        return tt1View;
    }

    public TextInputEditText getTt2View() {
        return tt2View;
    }

    public TextView getTitleLabel1() {
        return titleLabel1;
    }

    public TextView getTitleLabel2() {
        return titleLabel2;
    }
}
