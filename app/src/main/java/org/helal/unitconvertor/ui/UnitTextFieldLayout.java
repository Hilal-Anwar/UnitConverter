package org.helal.unitconvertor.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.textfield.TextInputEditText;

import org.helal.unitconvertor.R;


public class UnitTextFieldLayout extends LinearLayout {

    private LinearLayoutCompat linearLayout;
    private TextView textView;
    private ImageView endIcon;

    public UnitTextFieldLayout(Context context) {
        super(context);
    }

    public UnitTextFieldLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int focus_color;
        int label_text_fill;
        String unitText,subUnitText;
        String unitTitleText;
        String textFieldTextHint;
        try (TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.UnitTextFieldLayout, 0, 0)) {
            unitText = a.getString(R.styleable.UnitTextFieldLayout_titleText1);
            subUnitText = a.getString(R.styleable.UnitTextFieldLayout_subUnitText);
            unitTitleText = a.getString(R.styleable.UnitTextFieldLayout_unitTitleText);
            textFieldTextHint=a.getString(R.styleable.UnitTextFieldLayout_textFieldTextHint);
            focus_color = a.getColor(R.styleable.UnitTextFieldLayout_focusColorValue1,
                    getResources().getColor(android.R.color.holo_blue_light, context.getTheme()));
            label_text_fill = a.getColor(R.styleable.UnitTextFieldLayout_labelTextFillColor1,
                    getResources().getColor(android.R.color.holo_blue_light, context.getTheme()));
        }
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.unit_text_editor, this, true);
        linearLayout = findViewById(R.id.unit_text_main);
        TextInputEditText textInputEditText = findViewById(R.id.textInputEditText);
        textView = findViewById(R.id.unit_title_lable);
        TextView sub_unit=findViewById(R.id.sub_unit);
        TextView unit=findViewById(R.id.mian_unit);
        sub_unit.setText(subUnitText);
        unit.setText(unitTitleText);
        textInputEditText.setHint(textFieldTextHint);
        textView.setText(unitText);
        textInputEditText.setFocusableInTouchMode(true);
        textInputEditText.setOnFocusChangeListener((v, hasFocus) -> actionOnFocus(hasFocus, focus_color, label_text_fill));

    }

    public UnitTextFieldLayout(Context context, AttributeSet attrs, int defStyleAttr,
                               int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public UnitTextFieldLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void actionOnFocus(boolean hasFocus, int focus_color, int label_text_fill) {
        if (hasFocus) {
            linearLayout.setBackgroundResource(R.drawable.menu_textfield_selected);
            textView.setTextColor(focus_color);
        } else {
            linearLayout.setBackgroundResource(R.drawable.menu_textfield_normal);
            textView.setTextColor(label_text_fill);
        }
    }
}