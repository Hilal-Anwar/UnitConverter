package org.helal.unitconvertor.unitController;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import org.helal.unitconvertor.R;
import org.helal.unitconvertor.converter.currency.Database;
import org.helal.unitconvertor.ui.CurrencyTextFieldLayout;
import org.helal.unitconvertor.controller.CurrencyBottomSheet;

import java.util.Objects;
import java.util.TreeMap;


public class CurrencyFragment extends Fragment {
    CurrencyBottomSheet currencyBottomSheet, currencyBottomSheet1;
    Database database;

    @Nullable
    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.currency_layout, container, false);
        CurrencyTextFieldLayout textView1 = view.findViewById(R.id.currency_1);
        CurrencyTextFieldLayout textView2 = view.findViewById(R.id.currency_2);
        TextView _textView = textView1.findViewById(R.id.sub_unit);
        TextInputEditText tt1View = textView1.findViewById(R.id.textInputEditText);
        TextView __textView = textView2.findViewById(R.id.sub_unit);
        TextInputEditText tt2View = textView2.findViewById(R.id.textInputEditText);
        new Thread(() -> {
            database = new Database(requireContext().getFilesDir().toString());
            currencyBottomSheet = new CurrencyBottomSheet(_textView, tt1View,
                    new TreeMap<>(database.getCurrencyValueData()),
                    new TreeMap<>(database.getCurrencyNameData()));
            currencyBottomSheet1 = new CurrencyBottomSheet(__textView, tt2View,
                    new TreeMap<>(database.getCurrencyValueData()),
                    new TreeMap<>(database.getCurrencyNameData()));
        }).start();
        _textView.setOnClickListener(v -> {
            currencyBottomSheet.show(requireActivity().getSupportFragmentManager(), "loading data ....");
        });
        __textView.setOnClickListener(v -> {
            currencyBottomSheet1.show(requireActivity().getSupportFragmentManager(), "loading data ....");

        });
        tt1View.setOnKeyListener((v, keyCode, event) -> {
            if (database != null) {
                String st1 = _textView.getText().toString().substring(4).trim();
                String st2 = __textView.getText().toString().substring(4).trim();
                double ab = Objects.requireNonNull(database.getCurrencyValueData().get(st1.toLowerCase())).getAsDouble();
                double cd = Objects.requireNonNull(database.getCurrencyValueData().get(st2.toLowerCase())).getAsDouble();
                String s = Objects.requireNonNull(tt1View.getText()).toString();
                if (!s.isEmpty()) {
                    double val = cd / ab * Double.parseDouble(String.valueOf(tt1View.getText()));
                    tt2View.setText(String.valueOf(val));
                }
            }
            return false;
        });
        tt2View.setOnKeyListener((v, keyCode, event) -> {
            if (database != null) {
                String st1 = _textView.getText().toString().substring(4).trim();
                String st2 = __textView.getText().toString().substring(4).trim();
                double ab = Objects.requireNonNull(database.getCurrencyValueData().get(st1.toLowerCase())).getAsDouble();
                double cd = Objects.requireNonNull(database.getCurrencyValueData().get(st2.toLowerCase())).getAsDouble();
                String s = Objects.requireNonNull(tt2View.getText()).toString();
                if (!s.isEmpty()) {
                    double val = ab / cd * Double.parseDouble(String.valueOf(tt2View.getText()));
                    tt1View.setText(String.valueOf(val));
                }
            }
            return false;
        });


        return view;
    }

}
