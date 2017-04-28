/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.udea.ws;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/*CLASE FIGUREENCODER
La clase está encargada de codificar el mensaje que llega como parámetro 
convirtiéndolo de un objeto Figure en un String usando su correspondiente valor
como JsonObject.
La clase FigureDecoder implementa la interfaz Encoder.text<Figure> que la cual
define cómo proporcionar una forma de convertir un objeto personalizado en un
mensaje de texto.
*/
public class FigureEncoder implements Encoder.Text<Figure>{
    
    /*Método encode
    Codifica el objeto pasado como parámetro en un Stirng, para nuestro caso
    el objeto a codificar será figure.
    */
    @Override
    public String encode(Figure figure) throws EncodeException {
    return figure.getJson().toString();    
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
     System.out.println("destroy");    
    }
    
}
