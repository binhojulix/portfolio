module.exports = function(app) {

    var controller = app.controller.promocoes;
    
    app.get("/promocoes/form", controller.formulario);

    app.post("/promocoes", controller.salvar);

}
