package com.alura.currency_converter.exchange_rate_api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeAPIRequest {
    /*
     * -----------------------------------
     * Constants
     * -----------------------------------
     */
    /*
     * Enlace a la API.
     */
    private final static String API_URI = "https://v6.exchangerate-api.com/v6/";

    /*
     * Modificadores del enlace de la api.
     */
    private final static String API_URI_MODIFIERS = "latest/";

    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */
    /*
     * Key de la api.
     */
    private String apiKey;

    /*
     * Enlace completo de conexion a la api.
     */
    private String fullApiUri;

    /*
     * -----------------------------------
     * Constructors
     * -----------------------------------
     */
    /**
     * Inicializa la instancia de la clase.
     */
    public ExchangeAPIRequest(){
        apiKey = "ee380ebc255a6b3140a7556b";
        fullApiUri = API_URI + apiKey + "/" + API_URI_MODIFIERS;
    }

    /*
     * -----------------------------------
     * Methods
     * -----------------------------------
     */
    /**
     * Deuvelve la respuesta obtenida tras solicitar a la API la información de una moneda inidicad.
     * @param pCurrency Moneda indicada.
     * @return la respuesta obtenida.
     * @throws ExchangeAPICurrencyDoesntExistsException Cuando ocurre algun error en la obtención de la respuesta.
     */
    public ExchangeAPIResponse getCurrency(String pCurrency) throws ExchangeAPICurrencyDoesntExistsException{
        try {
            String uri = fullApiUri + pCurrency;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new ExchangeAPIResponse(response, pCurrency);   
        } catch (InterruptedException | IOException e) {
            throw new ExchangeAPICurrencyDoesntExistsException(pCurrency);
        }
    }
}
