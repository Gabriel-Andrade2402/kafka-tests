function connection(){

    // var sock = new SockJS("http://localhost:8080/messaging");
    // sock.onopen = function(){
    //     console.log('open');
    // }
    // sock.onmessage = function(e){
    //     console.log(e.data);
    // }
    // sock.onclose = function(){
    //     console.log("close");
    // }
    var websocket = new WebSocket("ws://localhost:8080/messaging");
    websocket.onopen = function (event) {
        console.log('open');
        websocket.send("Teste",{"atributo":"valor"});
    }
    websocket.onmessage = function (event) {
        console.log(event.data);
    }
    websocket.onclose = function () {
        console.log('close');
    }
}