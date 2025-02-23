package org.helal.unitconvertor.controller;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.helal.unitconvertor.R;

public class Currency extends RecyclerView.ViewHolder {
    TextView unit_code,unit_name;
    public Currency(@NonNull View itemView) {
        super(itemView);
        unit_code=itemView.findViewById(R.id.unit_code);
        unit_name=itemView.findViewById(R.id.unit_name);
    }

    public TextView getUnit_code() {
        return unit_code;
    }

    public TextView getUnit_name() {
        return unit_name;
    }
}
