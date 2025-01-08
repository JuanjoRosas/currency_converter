package com.alura.currency_converter.exchange_rate_api;

public class ExchangeAPICurrencyConvertionDoesntExists extends Exception{
    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */
    /*
     * Moneda desde la que se convierte.
     */
    private String originalCurrency;

    /*
     * Moneda a la que se convierte.
     */
    private String destinationCurrency;

    /*
     * -----------------------------------
     * Constructors
     * -----------------------------------
     */
    /**
     * Inicializa la instancia de la clase utilizando la moneda desde la que se convierte y a la que se convierte.
     * @param pOriginalCurrency moneda desde la que se convierte.
     * @param pDestinationCurrency moneda a la que se convierte.
     */
    public ExchangeAPICurrencyConvertionDoesntExists(String pOriginalCurrency, String pDestinationCurrency){
        originalCurrency = pOriginalCurrency;
        destinationCurrency = pDestinationCurrency;
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
        msg = "No existe la conversión de la moneda '%s' a la moneda '%s' dentro de la información del programa.".formatted(originalCurrency, destinationCurrency);
        return msg;
    }

    @Override
    public String getMessage() {
        return buildMessage();
    }

}
