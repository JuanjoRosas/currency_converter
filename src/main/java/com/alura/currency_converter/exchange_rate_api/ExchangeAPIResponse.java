package com.alura.currency_converter.exchange_rate_api;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

public class ExchangeAPIResponse {
    /*
     * -----------------------------------
     * Atributes
     * -----------------------------------
     */
    /*
     * Devuelve los parametros utilizados en la request que provocó la respuesta.
     */
    private String requestParameters;
    /*
     * Encabezados de la respuesta 
     */
    private HttpHeaders headers;
    /*
     * El cuerpo de la resuesta.
     */
    private String body;

    /*
     * -----------------------------------
     * Constructors
     * -----------------------------------
     */
    /**
     * Inicializa la instancia de la clase utilizando una respuesta devuelta por la API.
     * @param pResponse respuesta devuelta por la API.
     * @param pRequestParamenters parametros utilizados en la petición de la API.
     */
    public ExchangeAPIResponse(HttpResponse<String> pResponse, String pRequestParameters){
        headers = pResponse.headers();
        body = pResponse.body();
        requestParameters = pRequestParameters;
    }

    /*
     * -----------------------------------
     * Methods
     * -----------------------------------
     */
    /*GETTERS*/
    /**
     * Devuelve el cuerpo de la respuesta.
     * @return el cuerpo de la respuesta.
     */
    public String getBody() {
        return body;
    }

    /**
     * Devuelve los parametros utilizados en la requests.
     * @return parametros utilizados en la request.
     */
    public String getRequestParameters() {
        return requestParameters;
    }

    /*OTHER METHODS*/
    /**
     * Verifica la respuesta obtenida fue exitosa.
     * @return True si sí y false si no.
     */
    public boolean wasSuccesful(){
        int statusCode = Integer.parseInt(headers.allValues(":status").get(0));
        return statusCode > 199 && statusCode < 300;
    }
}
