module.exports = function(app) {

    var controller = app.controller.produtos;

    app.get('/produtos', controller.listar);

   // app.get('/produtos/json', controller.listarJSON);

    app.get('/produtos/form', controller.formulario);

    app.post('/produtos', controller.salvar);
}
