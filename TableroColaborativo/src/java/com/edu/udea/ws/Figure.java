package com.edu.udea.ws;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;

/*CLASE FIGURE
La clase Figure contiene la definición de los datos que se enviaran
desde y hacia el websocket endpoint con el formato JSON.
La clase está conformada por el atributo json que es un objeto de la clase 
JsonObject, el constructor de la clase y los respectivos get and set del atributo, 
se le agrega un método toString que será el encargado de escribir los onjetos json
que se envíen en el proceso.
 */

public class Figure {

    private JsonObject json;

    public Figure(JsonObject json) {
        this.json = json;
    }

    public JsonObject getJson() {
        return json;
    }

    public void setJson(JsonObject json) {
        this.json = json;
    }

    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
}
