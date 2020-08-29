package com.mynameismidori.currencypickerexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.mynameismidori.currencypicker.CurrencyPicker;
import com.mynameismidori.currencypicker.CurrencyPickerListener;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurrencyPicker picker = CurrencyPicker.newInstance("Select Currency", "DE");  // dialog title
        picker.setListener(new CurrencyPickerListener() {
            @Override
            public void onSelectCurrency(String name, String code, String symbol, String slug, int flagDrawableResID, int pos) {
                Toast.makeText(MainActivity.this, name + code + symbol, Toast.LENGTH_SHORT).show();
            }
        });
        picker.show(getSupportFragmentManager(), "CURRENCY_PICKER");
    }
}