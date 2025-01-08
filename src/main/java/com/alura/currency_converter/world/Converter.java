package com.alura.currency_converter.world;

import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrency;
import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrencyConvertionDoesntExists;
import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrencyDoesntExistsException;
import com.alura.currency_converter.exchange_rate_api.ExchangeAPIRequest;

public class Converter {
    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */

    /*
     * -----------------------------------
     * Constructor
     * -----------------------------------
     */

    /*
     * -----------------------------------
     * Methods
     * -----------------------------------
     */
    /**
     * Devuelve la moneda con el nombre indicado.
     * @param pCurrency nombre indicado.
     * @return moneda devuelta.
     * @throws ExchangeAPICurrencyDoesntExistsException Cuando no exista información de la moneda en la API utilizada.
     */
    public Currency getCurrency(String pCurrency) throws ExchangeAPICurrencyDoesntExistsException{
        return new Currency(new ExchangeAPICurrency(new ExchangeAPIRequest().getCurrency(pCurrency)));
    }

    /**
     * Devuelve un string con la conversión entre la monedas indicadas.
     * @param pMoney Cantidad de conversion inicial.
     * @param pCurrency Moneda a la que se convierte.
     * @return conversion entre monedas.
     * @throws ExchangeAPICurrencyConvertionDoesntExists Cuando no exista información de la moneda a la que se va a convertir.
     * @throws ExchangeAPICurrencyDoesntExistsException Cuando no exista la taza de covnersión entre monedas.
     */
    public String convert(Money pMoney, String pCurrency) throws ExchangeAPICurrencyConvertionDoesntExists, ExchangeAPICurrencyDoesntExistsException{
        Money newMoney = pMoney.convertTo(getCurrency(pCurrency));
        return pMoney.toString() + " ==> " + newMoney.toString();
    }
    
}
