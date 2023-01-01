module.exports = function(app){
	var api = {};

	api.jogar = function(req, res){
		res.render('game/index');
	}


	api.jquery = function(req, res){

	}

	api.javascript = function(req, res){

	}


	return api;
}