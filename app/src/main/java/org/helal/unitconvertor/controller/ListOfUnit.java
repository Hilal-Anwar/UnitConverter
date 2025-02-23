package org.helal.unitconvertor.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import org.helal.unitconvertor.R;

import java.util.ArrayList;

public class ListOfUnit extends RecyclerView.Adapter<Unit> {
    TextView selected_text_view;
    ArrayList<UnitInfo> localDataSet;
    TextInputEditText edit;

    public ListOfUnit(ArrayList<UnitInfo> localDataSet,
                      TextView selected_text_view, TextInputEditText edit) {
        this.localDataSet = localDataSet;
        this.edit = edit;
        this.selected_text_view = selected_text_view;
    }

    @NonNull
    @Override
    public Unit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.unit_recycle_view, parent, false);
        view.setOnClickListener(v ->
        {

            TextView t = view.findViewById(R.id.unit_name_text);
            if (selected_text_view != null)
                selected_text_view.setText(t.getText());
            String st = t.getText().toString();
            if (edit != null)
                edit.setHint(st);
        });
        return new Unit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Unit holder, int position) {
        holder.getUnit_name().setText(localDataSet.get(position).getUnit_name());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void setSelected_text_view(TextView selected_text_view) {
        this.selected_text_view = selected_text_view;
    }
}
