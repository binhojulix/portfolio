from controllers.base.SubfaseController import SubFaseController
from controllers.base.FaseController import FaseController
from flask import Flask, request, Response, json

def routes_sistema(app):

    @app.route("/sistemas", methods=['GET'])
    def lista_sistemas():
        faseController = FaseController()
        response = faseController.get_sistemas()
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/sistema", methods=['POST', 'PATCH'])
    def save_sistema():
        faseController = FaseController()
        req = request.json
        if request.method == 'PATCH':
            response = faseController.update_sistema(req)
        elif request.method == 'POST':
            response = faseController.save_sistema(req)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/sistema/<int:id>", methods=['GET', 'DELETE'])
    def fase(id):
        response = ''
        faseController = FaseController()
        if request.method == 'DELETE':
            response = faseController.delete_sistema(id)
        elif request.method == 'GET':
            response = faseController.find_sistema_by_id(id)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

