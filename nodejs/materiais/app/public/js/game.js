var tela = document.getElementById('tela');
var pincel = tela.getContext('2d');


pincel.fillStyle="green";
pincel.fillRect(0, 0, 200, 400);

tela.onclick = function(evento){
	 var x = evento.pageX;
	 var y = evento.pageY;
	 pincel.strokeStyle="black";
     pincel.strokeRect(x, y, 50, 50);
}
//this.parentNode.parentNode.parentNode;


setInterval(function(){
	pincel.fillStyle="gray";
	pincel.beginPath();
	pincel.moveTo(300, 200);
	pincel.lineTo(200, 400);
	pincel.lineTo(400, 400);
	pincel.fill();
}, 10);

setInterval(function(){
	 pincel.clearRect(0, 0, 600, 400);
}, 1000);

