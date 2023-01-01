from app.src.models.base.Sistema import Sistema


class SistemaControlle:

    def getSistemas(self):
        sistema = Sistema
        return sistema.get_Ativos()

    def getSistema(self):
        sistema = Sistema
        return sistema.find()

    def deleteAtivo(self):
        sistema = Sistema
        sistema.delete()

    def updateAtivo(self):
        sistema = Sistema
        sistema.update()
