import User from "./User.js";
import Admin from "./Admin.js";
import Docente from "./Docente.js";

/* 
const novoUser = new User('fabio', 'f@biojulio', '1988-06-15')
console.log(novoUser)
console.log(novoUser.exibirInfos()) */


/* const novoAdmin = new Admin('Rodrigo, "r@.com','2021-01-01')
console.log(novoAdmin)
console.log(novoAdmin.exibirInfos())
console.log(novoAdmin.criarCurso('JS', 20)) */

const novoDocente = new Docente('Rodrigo, "r@.com','2021-01-01')
console.log(novoDocente)
console.log(novoDocente.exibirInfos())
console.log(novoDocente.aprovaEstudante('fabio', 'JS')) 