from controllers.base.SubfaseController import SubFaseController
from controllers.base.FaseController import FaseController
from flask import Flask, request, Response, json

def routes_complexo(app):

    @app.route("/complexo", methods=['GET'])
    def lista_complexo():
        faseController = FaseController()
        response = faseController.get_fases()
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/complexo", methods=['POST', 'PATCH'])
    def save_complexo():
        faseController = FaseController()
        req = request.json
        if request.method == 'PATCH':
            response = faseController.update_fase(req)
        elif request.method == 'POST':
            response = faseController.save_fase(req)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/complexo/<int:id>", methods=['GET', 'DELETE'])
    def complexo(id):
        response = ''
        faseController = FaseController()
        if request.method == 'DELETE':
            response = faseController.delete_fase(id)
        elif request.method == 'GET':
            response = faseController.find_fase_by_id(id)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

