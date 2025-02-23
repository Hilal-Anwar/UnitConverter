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

import org.helal.unitconvertor.R;
import org.helal.unitconvertor.converter.quantities.Metric;
import org.helal.unitconvertor.unitController.BuildUnitLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SubUnitBottomSheet extends BottomSheetDialogFragment {
    private final TextView subUnit1,subUnit2;
    int num;

    public SubUnitBottomSheet(BuildUnitLayout layout, int num) {
        this.subUnit1 = layout.getSubUnit1();
        this.subUnit2 = layout.getSubUnit2();
        this.num = num;
    }

    ListOfUnit listOfUnit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unit_bottom_sheet, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle2);
        ArrayList<UnitInfo> list;
        var l = Metric.values();
        list = Arrays.stream(l).map(z -> new UnitInfo(z.name(), z.getV())).
                collect(Collectors.toCollection(ArrayList::new));
        if (num == 1)
            listOfUnit = new ListOfUnit(list, subUnit1, null);
        else
            listOfUnit = new ListOfUnit(list, subUnit2, null);
        recyclerView.setAdapter(listOfUnit);
        return view;
    }

    public TextView getSubUnit1() {
        return subUnit1;
    }
    public TextView getSubUnit2() {
        return subUnit2;
    }
}
