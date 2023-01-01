from controllers.base.SubfaseController import SubFaseController
from controllers.base.FaseController import FaseController
from flask import Flask, request, Response, json
import logging
def routes_fases(app):

    @app.route("/fases", methods=['GET'])
    def lista_fases():
        args = request.args
        fase_controller = FaseController()
        response = fase_controller.get_fases(args = args)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/fase", methods=['POST', 'PATCH'])
    def save_fase():
        faseController = FaseController()
        req = request.json
        if request.method == 'PATCH':
            response = faseController.update_fase(req)
        elif request.method == 'POST':
            response = faseController.save_fase(req)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/fase/<int:id>", methods=['GET', 'DELETE'])
    def fase(id):
        response = ''
        faseController = FaseController()
        if request.method == 'DELETE':
            response = faseController.delete_fase(id)
        elif request.method == 'GET':
            response = faseController.find_fase_by_id(id)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/fase/search/<string:descricao>", methods=['GET'])
    def search_fase(descricao):
        response = ''
        fase_controller = FaseController()
        if request.method == 'GET':
            response = fase_controller.find_fase_by_descricao(descricao)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/fase/total", methods=['GET'])
    def total():
        fase_controller = FaseController()
        response = fase_controller.get_total_fases()
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']
