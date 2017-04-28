/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.udea.ws;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/*CLASE FIGUREDECODER
La clase está encargada de retornar un objeto de tipo Figure a partir de un
String de datos que le llegan como parámetro, dicho parámetro es tomado como
un JsonObject y es decodificado creando así un objeto Figure.
La clase FigureDecoder implementa la interfaz Decoder.text<Figure> que la cual
define cómo se decodifica un objeto personalizado a partir de un mensaje websocket 
en forma de un String.
*/
public class FigureDecoder implements Decoder.Text<Figure> {
    
    /*Método Decode
    Decodifica la cadena dada en un objeto de tipo Figure
    */
    @Override
    public Figure decode(String string) throws DecodeException {
        JsonObject jsonObject = Json.createReader(new StringReader(string)).readObject();
        return new Figure(jsonObject);
    }
    
    /*Método willDecode
    Responde si la cadena dada como parámetro puede ser decodificada en un
    objeto tipo Figure
    */
    @Override
    public boolean willDecode(String string) {
        try {
            Json.createReader(new StringReader(string)).readObject();
            return true;
        } catch (JsonException ex) {
            ex.printStackTrace();
            return false;
        }
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
