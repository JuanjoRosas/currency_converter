package com.alura.currency_converter.exchange_rate_api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ExchangeAPICurrency {
    /*
     * -----------------------------------
     * Constants
     * -----------------------------------
     */
    /*
     * Nobre del elemento del json con el nombre de la moneda.
     */
    private final static String CURRENCY_NAME_ELEMENT_NAME = "base_code";
    /*
     * Nombre del elemento del json con las tazas de conversion.
     */
    private final static String CONVERTION_RATE_ELEMENT_NAME = "conversion_rates";
    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */
    /*
     * Objeto que contiene todos los elementos de la moneda devuelta por la API. 
     */
    private JsonObject currency;

    /*
     * -----------------------------------
     * Constructors
     * -----------------------------------
     */
    /**
     * Inicializa la instancia de la clase utilizando la respuesta obtenida en la petición a la API.
     * @param pResponse respuesta obtenida en la petición a la API.
     * @throws ExchangeAPICurrencyDoesntExistsException Cuando la petición no devulvió un código de exito en sus encabezados.
     */
    public ExchangeAPICurrency(ExchangeAPIResponse pResponse) throws ExchangeAPICurrencyDoesntExistsException{
        if (!pResponse.wasSuccesful())
            throw new ExchangeAPICurrencyDoesntExistsException(pResponse.getRequestParameters());
        Gson gson = new GsonBuilder()
                .create();
        currency = gson.fromJson(pResponse.getBody(), JsonObject.class);
    }

    /*
     * -----------------------------------
     * Methods
     * -----------------------------------
     */
    /*GETTERS*/
    /**
     * Devuelve el nombre de la moneda.
     * @return nombre de la moneda.
     */
    public String getName(){
        return currency.get(CURRENCY_NAME_ELEMENT_NAME).getAsString();
    }

    /**
     * Devuelve la taza de conversion a la moneda indicada.
     * @param pCurrency moneda indicada.
     * @return taza de conversion a la moneda indicada.
     * @throws ExchangeAPICurrencyConvertionDoesntExists Cuando no exista la taza de conversión a la moneda indicada.
     */
    public String getConvertionRateTo(String pCurrency) throws ExchangeAPICurrencyConvertionDoesntExists{
        if (!hasConvertionRateTo(pCurrency))
            throw new ExchangeAPICurrencyConvertionDoesntExists(getName(), pCurrency);
        return currency.getAsJsonObject(CONVERTION_RATE_ELEMENT_NAME).get(pCurrency).getAsString();
    }

    /*OTHER METHODS*/
    /**
     * Verifica si dentro de las tazas de conversión existe la taza para la moneda indicada.
     * @param pCurrency moneda indicada.
     * @return True si sí y false si no.
     */
    public Boolean hasConvertionRateTo(String pCurrency){
        return currency.getAsJsonObject(CONVERTION_RATE_ELEMENT_NAME).has(pCurrency);
    }
}
