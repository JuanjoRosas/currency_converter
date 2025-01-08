package com.alura.currency_converter.exchange_rate_api;

public class ExchangeAPICurrencyDoesntExistsException extends Exception{
    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */
    /*
     * Moneda que buscada que ocasiono el problema.
     */
    private String currency;

    /*
     * -----------------------------------
     * Constructors
     * -----------------------------------
     */
    /**
     * Inicializa la instancia de la clase utilizando la moneda buscada.
     * @param pCurrency moneda buscada.
     */
    public ExchangeAPICurrencyDoesntExistsException(String pCurrency){
        currency = pCurrency;
    }

    /*
     * -----------------------------------
     * Methods
     * -----------------------------------
     */
    /**
     * Construye el mensaje de error.
     * @return mensaje de error.
     */
    private String buildMessage(){
        String msg = "";
        msg = "No se pudo encontrar la moneda '%s' dentro de la información de la aplicación".formatted(currency);
        return msg;
    }

    @Override
    public String getMessage() {
        return buildMessage();
    }
}
