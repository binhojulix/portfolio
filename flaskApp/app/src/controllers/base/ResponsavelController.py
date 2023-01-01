from models.base import Responsavel


class ResponsavelControlle:

    def getAtivos(self):
        responsavel = Responsavel()
        return responsavel.get_Ativos()

    def getAtivo(self):
        responsavel = Responsavel()
        return responsavel.find()

    def deleteAtivo(self):
        responsavel = Responsavel()
        responsavel.delete()

    def updateAtivo(self):
        responsavel = Responsavel()
        responsavel.update()
