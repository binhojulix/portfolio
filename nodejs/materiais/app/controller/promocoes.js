module.exports = function(app){
	var api ={};

	api.formulario = function(req, res) {
        var connection = app.infra.connectionFactory();
        var produtosDAO = new app.infra.ProdutosDAO(connection);
        produtosDAO.lista(function(erros, resultados) {
            res.render('promocoes/form', {lista: resultados});
        });
        connection.end();
    }

    api.salvar = function(req, res) {
        var promocao = req.body;
        app.get('io').emit('novaPromocao', promocao);
        res.redirect('promocoes/form');
    }


	return api;
}