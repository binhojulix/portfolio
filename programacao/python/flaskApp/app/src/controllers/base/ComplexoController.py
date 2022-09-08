from math import fabs
from models.base.complexo import complexo
from models.base.Subcomplexo import Subcomplexo


class ComplexoController:
    def __init__(self):
        self.complexo_model = complexo()

    def get_complexos(self):
        result = []
        try:
            complexos = self.complexo_model.get_complexos()
            result = [item.obj_to_dict() for item in complexos]
            status = 200
        except Exception as e:
            print(e)
            result = []
            status = 400
        finally:
            return {
                'result': result,
                'status': status
            }

    def find_complexo_by_id(self, id):
        result = {}
        try:
            self.complexo_model.id = id
            res = self.complexo_model.find()
            if res != None:
                result = {
                    "id": res.id,
                    "descricao": res.descricao,
                    'subcomplexo': {
                        'id': res.subcomplexo.id,
                        'descricao': res.subcomplexo.descricao
                    }
                }
            status = 200
        except Exception as e:
            print(e)
            result = []
            status = 400
        finally:
            return {
                'result': result,
                'status': status
            }

    def delete_complexo(self, id):
        self.complexo_model.id = id
        try:
            result = self.complexo_model.delete()
            status = 200
        except Exception as e:
            print(e)
            result = []
            status = 400
        finally:
            return {
                'result': result,
                'status': status
            }

    def update_complexo(self, request):
        self.complexo_model.id = request['id']
        try:
            obj = {'descricao': request['descricao'], 'fk_sub_complexo': request['fk_sub_complexo']}
            status = 200
            result = self.complexo_model.update(obj)
        except Exception as e:
            print(e)
            result = []
            status = 400
        finally:
            return {
                'result': result,
                'status': status
            }

    def save_complexo(self, complexoRequest):
        descricao = complexoRequest['descricao']
        fk_sub_complexo = complexoRequest['fk_sub_complexo']
        subcomplexo = Subcomplexo(id=complexoRequest['subcomplexo']['id'], descricao=complexoRequest['subcomplexo']['descricao'])
        subcomplexo.find()
        self.complexo_model = complexo(descricao=descricao, fk_sub_complexo=fk_sub_complexo)
        try:
            self.complexo_model.save()
            status = 200
            result = []
        except Exception as e:
            print(e)
            result = []
            status = 400
        finally:
            return {
                'result': result,
                'status': status
            }






