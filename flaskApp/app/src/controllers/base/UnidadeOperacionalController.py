from app.src.models.base import UnidadeOperacional


class UnidadeOperacionalControlle:

    def getUnidadeOperacionais(self):
        unidade_operacional = UnidadeOperacional()
        return unidade_operacional.get_UnidadesOperacionais()

    def getUnidadeOperacional(self):
        unidade_operacional = UnidadeOperacional()
        return unidade_operacional.find()

    def deleteUnidadeOpercional(self):
        unidade_operacional = UnidadeOperacional()
        unidade_operacional.delete()

    def updateUnidadeOperacional(self):
        unidade_operacional = UnidadeOperacional()
        unidade_operacional.update()
