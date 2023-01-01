module.exports = function(app){
	var controller = app.controller.game;

	app.get('/jogar', controller.jogar);

}