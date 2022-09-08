from controllers.base.SubresponsavelController import SubresponsavelController
from controllers.base.responsavelController import responsavelController
from flask import Flask, request, Response, json

def routes_responsavel(app):

    @app.route("/responsaveis", methods=['GET'])
    def lista_responsavel():
        responsavelController = responsavelController()
        response = responsavelController.get_responsavel()
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/responsavel", methods=['POST', 'PATCH'])
    def save_responsavel():
        responsavelController = responsavelController()
        req = request.json
        if request.method == 'PATCH':
            response = responsavelController.update_responsavel(req)
        elif request.method == 'POST':
            response = responsavelController.save_responsavel(req)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

    @app.route("/responsavel/<int:id>", methods=['GET', 'DELETE'])
    def responsavel(id):
        response = ''
        responsavelController = responsavelController()
        if request.method == 'DELETE':
            response = responsavelController.delete_responsavel(id)
        elif request.method == 'GET':
            response = responsavelController.find_responsavel_by_id(id)
        return Response(json.dumps(response['result'], ensure_ascii=False), mimetype='application/json'), response['status']

