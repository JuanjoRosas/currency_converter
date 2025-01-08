package com.alura.currency_converter.world;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrencyConvertionDoesntExists;

public class Money {
    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */
    /*
     * Monto monetario.
     */
    private String amount;

    /*
     * Moneda.
     */
    private Currency currency;

    /*
     * -----------------------------------
     * Constructor
     * -----------------------------------
     */
    /**
     * Inicializa la instancia de la clase utilizando el monto y la moneda.
     * @param pCurrency moneda.
     * @param pAmount monto.
     */
    public Money(Currency pCurrency, String pAmount){
        currency = pCurrency;
        amount = pAmount;
    }

    /*
     * -----------------------------------
     * Methods
     * -----------------------------------
     */
    /**
     * Devuelve la conversion de la cantidad actual a otra moneda.
     * @param pCurrency moneda a la que se va a convertir.
     * @return cantidad covertida a la moneda indicada.
     * @throws ExchangeAPICurrencyConvertionDoesntExists Cuando no exista una taza de conversión.
     */
    public Money convertTo(Currency pCurrency) throws ExchangeAPICurrencyConvertionDoesntExists{
        BigDecimal amountNumber = new BigDecimal(amount);
        BigDecimal rateConvertionNumber = new BigDecimal(currency.getConvertionRate(pCurrency));
        MathContext mc = new MathContext(6, RoundingMode.HALF_UP);
        String newAmount = amountNumber.multiply(rateConvertionNumber,mc).toString();
        return new Money(pCurrency, newAmount);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(amount, currency.getName());
    }

}
