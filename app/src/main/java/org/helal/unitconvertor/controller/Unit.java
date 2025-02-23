package org.helal.unitconvertor.controller;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.helal.unitconvertor.R;

public class Unit extends RecyclerView.ViewHolder {

    TextView unit_name;
    public Unit(View itemView) {
        super(itemView);
        unit_name=itemView.findViewById(R.id.unit_name_text);
    }

    public TextView getUnit_name() {
        return unit_name;
    }

}
