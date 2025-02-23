package org.helal.unitconvertor.unitController;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import org.helal.unitconvertor.R;

public class AreaFragment extends Fragment {
    @Nullable
    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_unit_layout, container, false);
        BuildUnitLayout unitLayout=new BuildUnitLayout(this,v,"Area","square_metre");
        return v;
    }
}
