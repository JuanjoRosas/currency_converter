package com.alura.currency_converter.interfaz;

import java.math.BigDecimal;
import java.util.Scanner;

import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrencyConvertionDoesntExists;
import com.alura.currency_converter.exchange_rate_api.ExchangeAPICurrencyDoesntExistsException;
import com.alura.currency_converter.world.Converter;
import com.alura.currency_converter.world.Currency;
import com.alura.currency_converter.world.Money;

public class Menu {

    private Scanner scanner;
    private Converter converter;

    public Menu(){
        scanner = new Scanner(System.in);
        converter = new Converter();
    }

    public void run(){
        System.out.println("¡Reciba una bienvenida al conversor de monedas!");
        MenuOptions selectedOption;
        boolean keepGoing = true;
        while (keepGoing) {
            selectedOption = askForOptions();
            keepGoing = executeOption(selectedOption);
        }
        System.out.println("¡Hasta luego!");
    }

    private MenuOptions askForOptions(){
        String response = "";
        while (true) {
            printMenu();
            response = scanner.nextLine();
            try {
                return getOption(response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printMenu(){
        System.out.println("*****************************************************************");
        for (MenuOptions menuOption : MenuOptions.values()) {
            System.out.println(menuOption.toString());
        }
        System.out.println("Por favor, elija un opción válida.");
        System.out.println("*****************************************************************");
    }

    private boolean executeOption(MenuOptions pOption){
        if(pOption == MenuOptions.EXIT)
            return false;
        if(pOption == MenuOptions.CUSTOM)
            runCustomConvertion();
        else
            runStandardConvertion(pOption.getCurrencyFrom().getCurrency(), pOption.getCurrencyTo().getCurrency());
        return true;
    }

    private void runCustomConvertion(){
        Currency currencyFrom = askForCurrency("Escriba la moneda que desea convertir:");
        String currencyFromName = currencyFrom.getName();
        String amount = askForAmount("Escriba la cantidad de la moneda '%s' que desea convertir:".formatted(currencyFromName));
        System.out.println("Escriba la moneda a la que desa convertir desde '%s':".formatted(currencyFromName));
        String currencyTo = scanner.nextLine();
        try {
            System.out.println(converter.convert(new Money(currencyFrom, amount), currencyTo));
        } catch (ExchangeAPICurrencyConvertionDoesntExists | ExchangeAPICurrencyDoesntExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private void runStandardConvertion(String pCurrencyFrom, String pCurrencyTo){
        String amount = askForAmount("Escriba la cantidad de '%s' que desea convertir en '%s':".formatted(pCurrencyFrom, pCurrencyTo));
        try {
            System.out.println(converter.convert(new Money(converter.getCurrency(pCurrencyFrom), amount), pCurrencyTo));
        } catch (ExchangeAPICurrencyConvertionDoesntExists | ExchangeAPICurrencyDoesntExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private MenuOptions getOption(String pOptionId) throws Exception{
        for (MenuOptions menuOption : MenuOptions.values()) {
            if(menuOption.getOptionId().equals(pOptionId))
                return menuOption;
        }
        throw new Exception("'%s' no es una opción valida.".formatted(pOptionId));
    }

    private Currency askForCurrency(String pMessage){
        String response= "";
        while (true) {
            System.out.println(pMessage);
            response = scanner.nextLine();
            try {
                return converter.getCurrency(response);
            } catch (ExchangeAPICurrencyDoesntExistsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String askForAmount(String pMessage){
        String response= "";
        BigDecimal big;
        while (true) {
            System.out.println(pMessage);
            response = scanner.nextLine();
            try {
                big = new BigDecimal(response);
                return response;
            } catch (Exception e) {
                System.out.println("'%s' no es una cantidad válida.".formatted(response));
            }
        }
    }

}
