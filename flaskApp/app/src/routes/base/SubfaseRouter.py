from controllers.base.SubfaseController import SubFaseController
from flask import Flask, request, Response, json

def routes_subfases(app):
    @app.route("/subfases", methods=['GET'])
    def subfases():
        sub_faseController = SubFaseController()
        result = sub_faseController.list_subfase()
        return Response(json.dumps(result, ensure_ascii=False), mimetype='application/json')

    @app.route("/subfase", methods=['POST', 'GET', 'PATCH'])
    def subfase():
        result = ''
        json = request.json
        subfaseController = SubFaseController()
        if request.method == 'POST':
            result = subfaseController.save_subfase(json)
        elif request.method == 'GET':
            result = subfaseController.find_subfase_by_id(request.json)
        elif request.method == 'PATCH':
            result = subfaseController.update_subfase(json)
        return Response(result, mimetype='application/json')

    @app.route("/subfase", methods=['DELETE'])
    def delete_subfase():
        descricao = request.json
        subfaseController = SubFaseController()
        return subfaseController.delete_subfase(descricao)