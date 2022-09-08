import pandas as pd
import json
class FiltroController:


    def __init__(self, conteudo):
        self.conteudo = conteudo

    # funca
    def getResponse(self):
        df = pd.read_csv('connection/fake_database/Descarga_GB.csv')

        ano = self.conteudo['ano']
        data_min_inicial = self.conteudo['data_min_inicial']
        data_min_final = self.conteudo['data_min_final']
        cenario = self.conteudo['cenario']
        site = self.conteudo['site']
        meses = self.conteudo['mes']
      #  if ano:
       #     df.query('ANO!={}'.format(ano))
#        df.query('data_min >={} && data_min <= {}'.format(data_min_inicial, data_min_final))
        #if meses:
        #    df.query('mes not in ({})'.format(meses))
        #if cenario:
        #    df.query('cenario = {}'.format(cenario))
        #if site:
         #   df.quer('site = {}'.format(site))
        return df.to_json('data')



    def connecToDataBricks(self):
        return "conectado com databricks"

    def sendDataToDatabricks(self):
        return "enviando dados para databricks"