package org.helal.unitconvertor.unitController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.helal.unitconvertor.R;

public class SpeedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.custom_unit_layout, container, false);
        BuildUnitLayout unitLayout=new BuildUnitLayout(this,v,"Speed","metre_per_second");

        return v;
    }
}
