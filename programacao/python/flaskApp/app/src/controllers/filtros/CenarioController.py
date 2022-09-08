from models.Cenario import Cenario


class CenarioContoler:

    def getControllers(self):
        cenario = Cenario()
        return cenario.get_cenarios()