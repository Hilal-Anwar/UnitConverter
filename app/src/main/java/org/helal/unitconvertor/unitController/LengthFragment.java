package org.helal.unitconvertor.unitController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.helal.unitconvertor.R;


public class LengthFragment extends Fragment {


    public LengthFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.custom_unit_layout, container, false);
        BuildUnitLayout unitLayout=new BuildUnitLayout(this,view,"Length","meter");

        return view;

    }
}