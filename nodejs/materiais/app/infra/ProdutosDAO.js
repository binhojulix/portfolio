function ProdutosDAO(connection) {
    this._connection = connection;
}

ProdutosDAO.prototype.lista = function(callback) {
    this._connection.query('select * from produtos',callback);
}


ProdutosDAO.prototype.salva = function(produto,callback) {
    this._connection.query('INSERT INTO produtos SET ?', produto, callback);
}

ProdutosDAO.prototype.excluir = function(_id, callback){
	this._connection.query('DELETE from produtos where id ?',_id, callback);
}

ProdutosDAO.prototype.atualizar = function(produto, callback){
	this._connection.query('UPDATE PRODUTOS SET ? where id ?',produto, callback);
}

ProdutosDAO.prototype.buscar = function(_id){
	this.connection.query('select *from produtos where id ?', _id, callback);
}


module.exports = function(){
    return ProdutosDAO;
};