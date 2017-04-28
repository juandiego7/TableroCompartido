package com.edu.udea.sever;

import com.edu.udea.ws.Figure;
import com.edu.udea.ws.FigureDecoder;
import com.edu.udea.ws.FigureEncoder;
import java.io.IOException;
import static java.lang.String.format;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*CLASE MYWHITEBOARD
La clase MyWhiteboard hará la función de servidor en la aplicación,
dicho servidor estará en la facultad de gestionar los diferentes clientes que se
conecten, además será el encargado de cargar los métodos onOpen, OnMessage y OnClose,
por último permitirá orquestar los diferentes clientes que se carguen en cada 
sesión desde el navegador web.
La clase utiliza las siguientes notaciones notaciones 
==> @ServerEnpoint: 
==> @OnMessage: 
==> @OnOpen
==> @OnClose
*/

/*
@ServerEnpoint: Declara el inicio de la clase, indica que es un punto final
    del websocket, permite definir la dirección que se publicará en el punto final.
    Recibe como parámetros los encoders, los decoders y la URI.
*/
@ServerEndpoint(value = "/tablero",
        encoders = {FigureEncoder.class},
        decoders = {FigureDecoder.class})
public class MyWhiteboard {

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    
    /*
    @OnMessage: permite crear un método java que reciva los mensajes entrantes 
    desde un websocket, cada websocket endpoint sólo puede tener un @OnMensagge 
    por cada uno de los formatos de websocket nativos.
    */
    @OnMessage
    public void broadcastFigure(Figure figure, Session session) throws IOException, EncodeException {
        for (Session peer : peers) {
            if (!peer.equals(session)) {
                peer.getBasicRemote().sendObject(figure);
            }
        }
    }

    /*
    @OnOpen: Éste método a nivel de anotación puede ser usado para decorar un método
    java el cual será llamado cada vez que se abra una nueva sesión de websocket.
    */
    @OnOpen
    public void onOpen(Session peer) {
        System.out.println(format("%s joined:", peer.getId()));
        peers.add(peer);
    }
    
    /*
    @OnClose: Éste método a nivel de anotación puede ser usado para decorar un método
    java el cual será llamado cada vez que se cierre una nueva sesión de websocket.
    */
    @OnClose
    public void onClose(Session peer) {
        System.out.println(format("%s left:", peer.getId()));
        peers.remove(peer);
    }

}
