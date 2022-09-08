from controllers.base.SubfaseController import SubFaseController
from controllers.base.FaseController import FaseController
from flask import Flask, request, Response, json

def routes_unidade_operacional(app):

    @app.route("/unidade_operacionais", methods=['GET'])
    def lista_unidade_operacionals():
        unidade_controller = FaseController()
        response = unidade_controller.get_unidade_operacionals()
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/unidade_operacional", methods=['POST', 'PATCH'])
    def save_unidade_operacional():
        faseController = FaseController()
        req = request.json
        if request.method == 'PATCH':
            response = faseController.update_unidade_operacional(req)
        elif request.method == 'POST':
            response = faseController.save_unidade_operacional(req)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/unidade_operacional/<int:id>", methods=['GET', 'DELETE'])
    def fase(id):
        response = ''
        faseController = FaseController()
        if request.method == 'DELETE':
            response = faseController.delete_unidade_operacional(id)
        elif request.method == 'GET':
            response = faseController.find_unidade_operacional_by_id(id)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

