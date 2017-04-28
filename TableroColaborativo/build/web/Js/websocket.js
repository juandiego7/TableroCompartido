/*
 *Declarámos las variables a utilizar 
 *Definímos la URI con el endpoint creado en el backend
 *Creamos un nuevo webSocket con la URI definida
 *Cargamos en variables los elementos a utilizar del DOM
 */

var wsUri = "ws://" + document.location.host + document.location.pathname + "tablero";
var websocket = new WebSocket(wsUri);
var output = document.getElementById("output");
var mensajes = document.getElementById('conversacion');
var boton = document.getElementById('btnEnviar');
var nombre = document.getElementById('usuario');
var mensaje = document.getElementById('mensaje');

//Definímos la implementación para los métodos correspondientes a un websocket
websocket.onerror = function (evt) {
    onError(evt);
};

websocket.onmessage = function (evt) {
    onMessage(evt);
};

websocket.onopen = function (evt) {
    onOpen(evt);
};

//Agregamos el evento click al botón enviar
boton.addEventListener('click', enviar);

//writeToScreen muestra en la consola el mensaje pasádo como parámetro
function writeToScreen(message) {
    console.log(message + "<br>");
}

//onError muestra en consola cualquier posible error que pueda ocurrir
function onError(evt) {
    console.log(evt.data);
}

//Muestra en consola la URI a la cual se conecta un websocket
function onOpen() {
    console.log("Connected to:" + wsUri);
}

//onMessage estará encargado de dibujar en el canvas la figura pasada como objeto 
//JSON por parámetro, además será el encargado de agregar los mensajes en el chat.
function onMessage(evt) {
    console.log('Received ==>' + evt.data);
    var obj = JSON.parse(evt.data);
    var i = 0;
    for (var key in obj) {
        console.log(' key==>' + key + ' value==>' + obj[key]);
        i += 1;
    }
    console.log(i);
    if (i === 9 || i === 11) {
        draw(evt.data);
    } else if (i === 2) {
        mensajes.innerHTML += '<div class="well well-sm"><strong>' + obj.nombre + '</strong>:' + obj.mensaje + '</div>';
    }
}

//sendText será el encargado de enviar mensajes entre conexiones de ws
//dichos mensajes serán json(s) y además mostrará en consola el mensaje enviado
function sendText(json) {
    console.log("sending text: " + json);
    websocket.send(json);
}

//enviar será el método encargado de gestionar el envío de mensajes del chat
//dichos mensajes serán enviados en json(s), además mostrará el mensaje enviado
//por consola y por últomo lo agregará al DOM de la sesión de la cual es enviado.
function enviar() {
    var msg = {
        nombre: nombre.value,
        mensaje: mensaje.value
    };
    websocket.send(JSON.stringify(msg));
    console.log('Mensaje: Nombre: ' + msg.nombre + ' ==> Mensaje: ' + msg.mensage);
    mensajes.innerHTML += '<div class="well well-sm"\n\
                            style="overflow:auto"><strong>' + msg.nombre + '</strong>:' + msg.mensaje + '</div>';
    mensaje.value = '';
}