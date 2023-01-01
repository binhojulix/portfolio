var http = require('http');

var porta = 3000;
var ip = 'localhost';

var server = http.createServer(function(req, res){
	res.writeHead(200, {'Content-Type':'text/html'});
	if(req.url=='/produtos'){
		res.end("<h1>produsot</h1>");

	}else{
		res.end("<h1>Inicio</h1>");		
	}
});

server.listen(porta, ip, function(){
	console.log('rodando na porta 3000')
});
