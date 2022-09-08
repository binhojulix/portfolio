from models.base.Ativo import Ativo

class AtivoControlle:


    def getAtivos(self):
        ativo = Ativo()
        return ativo.get_Ativos()

    def getAtivo(self):
        ativo = Ativo()
        return ativo.find()

    def deleteAtivo(self):
        ativo = Ativo()
        ativo.delete()

    def updateAtivo(self):
        ativo = Ativo()
        ativo.update()
