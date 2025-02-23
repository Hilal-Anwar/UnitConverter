package org.helal.unitconvertor.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonElement;

import org.helal.unitconvertor.R;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class CurrencyBottomSheet extends BottomSheetDialogFragment {
    ListOfCurrency listOfCurrency;
    TextView text_view;
    TextInputEditText editText;
    TreeMap<String, JsonElement> data_value, data_name;

    public CurrencyBottomSheet(TextView text_view, TextInputEditText editText, TreeMap<String, JsonElement> data_value,
                               TreeMap<String, JsonElement> data_name)
    {
        this.text_view = text_view;
        this.editText=editText;
        this.data_value = data_value;
        this.data_name = data_name;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.currency_bottom_sheet, container, true);
        RecyclerView recyclerView = view.findViewById(R.id.recy);
        ArrayList<CurrencyInfo> list = new ArrayList<>();
        HashSet<String> currencySet= Currency.getAvailableCurrencies().
                stream().map(Currency::getCurrencyCode).collect(Collectors.toCollection(HashSet::new));
        for (String x : data_value.keySet()) {
            String wt = x.substring(0, x.length() - 1);
            if (currencySet.contains(x.toUpperCase()) && !countryCodeToEmoji(wt).isBlank() && data_name.get(x) != null) {
                list.add(new CurrencyInfo(countryCodeToEmoji(wt) + " " + x.toUpperCase(),
                        Objects.requireNonNull(data_name.get(x)).getAsString()));

            }
        }
        listOfCurrency = new ListOfCurrency(list, text_view,editText,data_name);
        recyclerView.setAdapter(listOfCurrency);
        return view;
    }

    public static String countryCodeToEmoji(String code) {

        int OFFSET = 127397;
        
        if (code == null || code.length() != 2) {
            return "";
        }

        //fix for uk -> gb
        if (code.equalsIgnoreCase("uk")) {
            code = "gb";
        }

        // convert code to uppercase
        code = code.toUpperCase();

        StringBuilder emojiStr = new StringBuilder();

        //loop all characters
        for (int i = 0; i < code.length(); i++) {
            emojiStr.appendCodePoint(code.charAt(i) + OFFSET);
        }

        // return emoji
        return emojiStr.toString();
    }
}
