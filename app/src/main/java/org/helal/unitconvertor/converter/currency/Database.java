package org.helal.unitconvertor.converter.currency;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class Database {


    private final JsonElement currencyValueData;
    private final JsonElement currencyNameData;

    public Map<String, JsonElement> getCurrencyValueData() {
        return currencyValueData.getAsJsonObject().getAsJsonObject("eur").asMap();
    }

    public Map<String, JsonElement> getCurrencyNameData() {
        return currencyNameData.getAsJsonObject().asMap();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Database(String rootPath) {
        String CURRENCY_VALUE_URL = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/eur.json";
        String CURRENCY_NAME_URL = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies.json";
        String PATH1 = rootPath + "/currency.json";
        String PATH2 = rootPath + "/currency_name.json";
        currencyValueData = readFile(PATH1, CURRENCY_VALUE_URL);
        currencyNameData = readFile(PATH2, CURRENCY_NAME_URL);
    }

    private void createFile(String PATH, String url) throws MalformedURLException {
        try {
            FileUtils.copyURLToFile(
                    URI.create(url).toURL(),
                    new File(PATH),
                    300,
                    500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private JsonElement readFile(String PATH, String url) {
        try {
            return JsonParser.parseReader(new InputStreamReader(new FileInputStream(PATH)));
        } catch (FileNotFoundException e) {
            try {
                createFile(PATH, url);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                return JsonParser.parseReader(new InputStreamReader(new FileInputStream(PATH)));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}