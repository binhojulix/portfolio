module.exports = function(app) {
	
	var controller = app.controller.home;

    app.get('/', controller.home);
}
