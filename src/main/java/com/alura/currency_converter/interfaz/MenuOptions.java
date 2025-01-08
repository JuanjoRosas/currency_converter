package com.alura.currency_converter.interfaz;

import com.alura.currency_converter.world.StandardCurrencies;

public enum MenuOptions {
    USD_TO_ARS("1","Dolar =>> Peso argentino.", StandardCurrencies.DOLAR, StandardCurrencies.PERO_ARGENTINO),
    ARS_TO_USD("2", "Peso argentino =>> Dolar.", StandardCurrencies.PERO_ARGENTINO, StandardCurrencies.DOLAR),
    USD_TO_BRL("3", "Dolar =>> Real brasileño.", StandardCurrencies.DOLAR, StandardCurrencies.REAL_BRASILENIO),
    BRL_TO_USD("4", "Real brasileño =>> Dolar.", StandardCurrencies.REAL_BRASILENIO, StandardCurrencies.DOLAR),
    USD_TO_COP("5", "Dolar =>> Peso colombiano.", StandardCurrencies.DOLAR, StandardCurrencies.PESO_COLOMBIANO),
    COP_TO_USD("6","Peso colombiano =>> Dolar.", StandardCurrencies.PESO_COLOMBIANO, StandardCurrencies.DOLAR),
    CUSTOM("7", "Elegir monedas."),
    EXIT("8", "Salir.");

    private StandardCurrencies currencyFrom;
    private StandardCurrencies currencyTo;
    private String optionId;
    private String description;

    private MenuOptions(String pOptionId, String pDescription){
        optionId = pOptionId;
        description = pDescription;
    }

    private MenuOptions(String pOptionId, String pDescription, StandardCurrencies pCurrencyFrom, StandardCurrencies pCurrencyTo){
        optionId = pOptionId;
        description = pDescription;
        currencyFrom = pCurrencyFrom;
        currencyTo = pCurrencyTo;
    }

    public String getOptionId() {
        return optionId;
    }

    public StandardCurrencies getCurrencyFrom() {
        return currencyFrom;
    }

    public StandardCurrencies getCurrencyTo() {
        return currencyTo;
    }

    @Override
    public String toString() {
        return optionId + ") " + description;
    }
}
