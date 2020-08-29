

# Currency Picker for Android

This fork adds German. For that in some methods the parameter land is necessary. For German set it to DE and for English to null.

 [![](https://jitpack.io/v/midorikocak/currency-picker-android.svg)](https://jitpack.io/#midorikocak/currency-picker-android)  [![](https://travis-ci.org/midorikocak/currency-picker-android.svg?branch=master)](https://travis-ci.org/midorikocak/currency-picker-android) [![](https://img.shields.io/badge/paypal-donate-yellow.svg)](https://www.paypal.me/midorikocak)

CurrencyPicker is a simple library that can be show a currency picker. See the example to see more detail. Heavily inspired by https://github.com/mukeshsolanki/country-picker-android

Flags are from https://github.com/transferwise/currency-flags.

![](https://raw.githubusercontent.com/midorikocak/currency-picker-android/master/screenshot.png)

## How to use

### Integration

Integrating the project is simple a refined all you need to do is follow the below steps

Step 1\. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```

Step 2\. Add the dependency

```java
dependencies {
        compile 'com.github.JoChef2:currency-picker-android-german:1.2.18'
}
```

### Usage

Once the project has been added to gradle, the dialog can be easily used.
***NOTE:*** The newInstance() method needs an additional parameter. The following parameters are available: <br>
"DE" -> sets the language of the picker to German <br>
null -> sets the language to English

```java
CurrencyPicker picker = CurrencyPicker.newInstance("Select Currency", "DE");  // dialog title
picker.setListener(new CurrencyPickerListener() {
    @Override
    public void onSelectCurrency(String name, String code, String symbol, int flagDrawableResID) {
        // Implement your code here
    }
});
picker.show(getSupportFragmentManager(), "CURRENCY_PICKER");
```

That's it, all done.

### Generic operations with countries

```java
ExtendedCurrency[] currencies = ExtendedCurrency.CURRENCIES; //Array of all currencies in Englisch
ExtendedCurrency[] currencies = ExtendedCurrency.CURRENCIES_DE; //Array of all currencies in German
ExtendedCurrency currency = ExtendedCurrency.getCurrencyByName(currencyName, language); //Get currency by its name and language(DE for German and null for Englisch)


String name = currency.getName();
String code = currency.getCode();
int flag = currency.getFlag();  // returns android resource id of flag or -1, if none is associated
String symbol = currency.getSymbol();

currency.loadFlagByCode();  // attempts to associate flag to currency based on its ISO code. Used if you create your own instance of Currency.class
```


