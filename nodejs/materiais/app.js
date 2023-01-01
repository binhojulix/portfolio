var app = require('./config/express')();
var server = require('http').createServer(app);
var io = require('socket.io').listen(server);
require('./config/mongoConnect')('mongodb://localhost/askeasy');


app.set('io', io);

var porta = process.env.PORT || 3000;

server.listen(porta, function(){
    console.log("Servidor rodando");
});