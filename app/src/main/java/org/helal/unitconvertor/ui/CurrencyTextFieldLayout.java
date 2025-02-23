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


public class CurrencyTextFieldLayout extends LinearLayout {

    private LinearLayoutCompat linearLayout;
    private TextView textView;

    public CurrencyTextFieldLayout(Context context) {
        super(context);
    }


    public CurrencyTextFieldLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int focus_color;
        int label_text_fill;
        try (TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CurrencyTextFieldLayout, 0, 0)) {
            String titleText = a.getString(R.styleable.CurrencyTextFieldLayout_titleText);
            focus_color = a.getColor(R.styleable.CurrencyTextFieldLayout_focusColorValue,
                    getResources().getColor(android.R.color.holo_blue_light, context.getTheme()));
            label_text_fill = a.getColor(R.styleable.CurrencyTextFieldLayout_labelTextFillColor,
                    getResources().getColor(android.R.color.holo_blue_light, context.getTheme()));
        }
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.menu_text_editor, this, true);
            linearLayout = findViewById(R.id.currency_text_main);
        TextInputEditText textInputEditText = findViewById(R.id.textInputEditText);
            textView = findViewById(R.id.unit_title_label);
        ImageView endIcon = findViewById(R.id.endIcon);
            textInputEditText.setFocusableInTouchMode(true);
            textInputEditText.setOnFocusChangeListener((v, hasFocus) -> actionOnFocus(hasFocus, focus_color, label_text_fill));

    }

    public CurrencyTextFieldLayout(Context context, AttributeSet attrs, int defStyleAttr,
                                   int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CurrencyTextFieldLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
