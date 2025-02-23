package org.helal.unitconvertor.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;

import org.helal.unitconvertor.R;
import org.helal.unitconvertor.converter.quantities.*;
import org.helal.unitconvertor.unitController.BuildUnitLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UnitBottomSheet extends BottomSheetDialogFragment {
    ListOfUnit listOfUnit;
    TextView text_view1, text_view2;
    TextInputEditText editText1, editText2;
    String layoutId;
    TextView subUnit1, subUnit2;
    int num;

    public UnitBottomSheet(BuildUnitLayout layout, int num) {
        this.layoutId = layout.getFieldName();
        this.text_view1 = layout.getMainUnit1();
        this.editText1 = layout.getTt1View();
        this.subUnit2 = layout.getSubUnit1();
        this.text_view2 = layout.getMainUnit2();
        this.editText2 = layout.getTt2View();
        this.subUnit1 = layout.getSubUnit2();
        this.num = num;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unit_bottom_sheet, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle2);
        ArrayList<UnitInfo> list = new ArrayList<>();
        switch (layoutId) {
            case "Length": {
                var l = Length.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Angle": {
                var l = Angle.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Area": {
                var l = Area.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Mass": {
                var l = Mass.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Density": {
                var l = Density.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Temperature": {
                var l = Temperature.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Pressure": {
                var l = Pressure.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Torque": {
                var l = Torque.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Energy": {
                var l = Energy.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Speed": {
                var l = Speed.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Viscosity": {
                var l = Viscosity.Kinematic.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Volume": {
                var l = Volume.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Time": {
                var l = Time.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "Power": {
                var l = Power.values();
                list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).collect(Collectors.toCollection(ArrayList::new));
                break;
            }
        }
        if (num == 1)
            listOfUnit = new ListOfUnit(list, text_view1, editText1);
        else
            listOfUnit = new ListOfUnit(list, text_view2, editText2);
        recyclerView.setAdapter(listOfUnit);
        return view;

    }


}
