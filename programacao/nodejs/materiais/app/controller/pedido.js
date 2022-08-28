
module.exports = function(app) {

    var api = {};

    var Pedido = app.models.pedido;


    api.listarPedidos = function (req, res) {

        Pedido.find().exec()
            .then(function (pedido) {
                res.json(pedido);
            }, function (error) {
                res.sendStatus(500);
            });
    };


    api.adiciona = function(req, res) {

        Pedido.create(req.body)
            .then(function(pedido) {
                res.json(pedido);
            }, function(error) {
                res.sendStatus(500);
        });
    };



    api.buscaPorId = function(req, res) {

        Pedido.findById(req.params.id)
            .then(function(pedido) {
                if (!pedido) throw new Error('Produto não encontrada');
                res.json(pedido);
            }, function(error) {
                console.log(error);
                res.sendStatus(500);
            });
    };


    api.removePorId = function(req, res) {

        Pedido.remove({'_id' : req.params.id})
            .then(function() {
                res.sendStatus(200);
            }, function(error) {
                res.sendStatus(500);
            });

    };



    api.atualiza = function(req, res) {

        Pedido.findByIdAndUpdate(req.params.id, req.body)
            .then(function(pedido) {
                res.json(pedido);
            }, function(error) {
                console.log(error);
                res.sendStatus(500);
            })
    };

    api.lista=function (req, res) {

    }

    return api;
};