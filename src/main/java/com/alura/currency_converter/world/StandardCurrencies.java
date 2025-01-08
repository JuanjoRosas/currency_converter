package com.alura.currency_converter.world;

public enum StandardCurrencies {
    DOLAR("USD"),
    PERO_ARGENTINO("ARS"),
    REAL_BRASILENIO("BRL"),
    PESO_COLOMBIANO("COP");

    private String currency;

    private StandardCurrencies(String pCurrency){
        currency = pCurrency;
    }

    public String getCurrency() {
        return currency;
    }
}
