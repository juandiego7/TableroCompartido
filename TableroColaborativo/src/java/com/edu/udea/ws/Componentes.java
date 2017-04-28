package com.edu.udea.ws;

/*CLASE COMPONENTES
La clase componentes nos permite tomar los datos de las coordenadas x e y 
que serán enviados por el canvas y los campos correspondientes a un mensaje 
de chat que son nombre y mensaje.
Dicha clase es un POJO (plain old java object) que se encarga de definir
los componentes de la aplicación.
La clase está conformada por los atributos x e y que representan coordenadas
además de nombre y mensaje que representan los atributos del chat, un constructor
vacío y el constructor de la clase, además cuenta con los métodos get y sed de 
los atributos.
 */
public class Componentes {

    private float x;
    private float y;
    private String nombre;
    private String mensaje;

    public Componentes() {
    }

    public Componentes(float x, float y, String nom, String men) {
        this.x = x;
        this.y = y;
        this.nombre = nom;
        this.mensaje = men;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
