from models.Processo import Processo


class ProcessoControler:

    def getProcessos(self):
        processo = Processo()
        return processo.get_processos()

