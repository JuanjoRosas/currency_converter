package com.alura.currency_converter.world;

import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrency;
import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrencyConvertionDoesntExists;

public class Currency {
    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */
    /*
     * Información de la moneda obtenida desde la API.
     */
    private ExchangeAPICurrency currencyInformation;

    /*
     * -----------------------------------
     * Constructor
     * -----------------------------------
     */
    /**
     * Inicializa la instancia de la clase utilizando la información de la moneda indicada.
     * @param pCurrencyInformation información de la moneda.
     */
    public Currency(ExchangeAPICurrency pCurrencyInformation){
        currencyInformation = pCurrencyInformation;
    }

    /*
     * -----------------------------------
     * Methods
     * -----------------------------------
     */
    /**
     * Devuelve el nombre de la moneda.
     * @return nombre de la moneda.
     */
    public String getName(){
        return currencyInformation.getName();
    }

    /**
     * Devuelve la taza de conversion de la moneda a otra moneda.
     * @param pCurrency moneda a la que se va a convertir.
     * @return taza de conversion.
     * @throws ExchangeAPICurrencyConvertionDoesntExists Cuando la taza de conversion no exista.
     */
    public String getConvertionRate(Currency pCurrency) throws ExchangeAPICurrencyConvertionDoesntExists{
        return currencyInformation.getConvertionRateTo(pCurrency.getName());
    }


}
