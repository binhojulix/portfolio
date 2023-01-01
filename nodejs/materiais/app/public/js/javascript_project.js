
		document.querySelector('#botao').addEventListener('click', function(event){
			var titulo = document.querySelector('#titulo');
			titulo.textContent= 'Bem Vindo ao meu jogo!' + Math.round(Math.random() * 100) ;
			titulo.style.color='red';
			titulo.classList.add('changeColor');
			//titulo.classList.remove('changeColor');
			
			event.preventDefault();
			//formulario.reset();
			//formulario.nome.value
			//formulario.nome.focus();
			//this.remove();

			var xhr = new XMLHttpRequest();

		    xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes");

		    xhr.addEventListener("load", function() {

		    	if(xhr.status=200){

			    	var resposta = xhr.responseText;
			        var pacientes = JSON.parse(resposta);
			        //document.getElementByID
			        //document.getElemetnByTagName
			        //document.getElementByClassName
			        pacientes.forEach(function(paciente) {
			        var h2 = document.createElement('h2');
					h2.textContent = paciente.nome;
					document.querySelector('#sub').appendChild(h2);
			        });

		    	}else{

		    		alert('erro');

		    	}	
		    });

		    xhr.send();
			
		});
		

		var array = ['fabio', 'julio', 'miguel', 'joana'];
		var size = array.length;

		console.log('array: ' + array);
		console.log('tamanho:' + size);
		array.pop();
		console.log('array: ' + array);
		array.push('joana');
		console.log('array: ' + array);

function post (argument) {
	 let xhr = new XMLHttpRequest();
                xhr.open("POST", url, true);
                xhr.setRequestHeader("Content-type", "application/json");
                xhr.onreadystatechange = () => {

                    if (xhr.readyState == 4) {

                        if (xhr.status == 200) {

                            resolve(JSON.parse(xhr.responseText));
                        } else {

                            reject(xhr.responseText);
                        }
                    }
                };
                xhr.send(JSON.stringify(dado)); // usando JSON.stringifly para converter objeto em uma string no formato JSON.
            });
}




function filter(){
	var alunos = [
		{
			{nome:'fabio', idade:28},
			{nome:'luiz', idade:21},
			{nome:'joana', idade:50}			
		}
	];

	var alunosMaior =alunos.filter(function(aluno){
		return aluno.idade>18;
	});

	var fabio = alunos.find(function(aluno){
		aluno.nome=='fabio';
	});
}











