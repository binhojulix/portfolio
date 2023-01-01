var mongoose = require('mongoose');

module.exports = function () {

    var schema = mongoose.Schema({

        nome: {
            type: String,
            required: true
        },
        preco: {
            type: Number,
            required: true
        },
        categoria: {
            type: String,
            required: true
        },
        descricao: {
            type: String,
            required: true
        }
    });

  return  mongoose.model('Pedido', schema);

}



