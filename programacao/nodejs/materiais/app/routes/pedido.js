
var path = require('path');

module.exports  = function(app) {

    var api = app.controller.pedido;

/*
    app.route('/produtos/:produtoId').
        delete(api.removePorId);
*/

/*
    app.route('/v1/fotos/:fotoId')
        .delete(api.remove)
        .get(api.busca)
        .put(api.atualiza);
    app.get('/v1/grupos', api.listaGrupos)
    app.get('/v1/fotos/grupo/:grupoId', api.listaPorGrupo);
    */

    app.get('/listar/pedidos', api.listarPedidos);

/*
    // habilitando HTML5MODE
    app.all('/*', function(req, res) {
        res.sendFile(path.resolve('public/index.html'));
    });
*/

};