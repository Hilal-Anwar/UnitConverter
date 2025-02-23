package org.helal.unitconvertor.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonElement;

import org.helal.unitconvertor.R;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class ListOfCurrency extends RecyclerView.Adapter<Currency> {
    TextView selected_text_view;
    ArrayList<CurrencyInfo> localDataSet;
    TextInputEditText edit;
    TreeMap<String, JsonElement> name;

    public ListOfCurrency(ArrayList<CurrencyInfo> localDataSet, TextView selected_text_view, TextInputEditText edit,
                          TreeMap<String, JsonElement> name) {
        this.localDataSet = localDataSet;
        this.name = name;
        this.edit = edit;
        this.selected_text_view = selected_text_view;
    }

    @NonNull
    @Override
    public Currency onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.currency_recycle_view, parent, false);
        view.setOnClickListener(v ->
        {
            TextView t = view.findViewById(R.id.unit_code);
            selected_text_view.setText(t.getText());
            String st = t.getText().toString().substring(4).trim();
            edit.setHint(Objects.requireNonNull(name.get(st.toLowerCase())).getAsString());
        });
        return new Currency(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Currency holder, int position) {
        holder.getUnit_code().setText(localDataSet.get(position).getUnit_code());
        holder.getUnit_name().setText(localDataSet.get(position).getUnit_name());
    }

    @Override
    public int getItemCount() {
        //System.out.println("Size of list is : "+localDataSet.size());
        return localDataSet.size();
    }

    public TextView getSelected_text_view() {
        return selected_text_view;
    }

    public void setSelected_text_view(TextView selected_text_view) {
        this.selected_text_view = selected_text_view;
    }
}
