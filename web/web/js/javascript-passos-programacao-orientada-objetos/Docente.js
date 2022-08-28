import User from "./User.js";

export default  class Admin extends User{
    constructor(nome, email, nascimento, role="admin", ativo=true){
        super(nome, email, nascimento, role, ativo)
    }

    aprovaEstudante(estudante, curso){
        return `estudante ${estudante} passou no  curso de ${curso}`
    }
}