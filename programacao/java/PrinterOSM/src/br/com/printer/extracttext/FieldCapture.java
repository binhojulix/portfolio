package br.com.printer.extracttext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FieldCapture {

	private static String texto;

	public FieldCapture(String nomeArquivo) {
		texto = lerCSV(nomeArquivo);

	}

	public String getCampo(String campo, int index) {

		String workString = texto;

		String retorno = "";
		int indexInicio, indexInicioDoValor, finalIndex;

		if (index == 1) {
			indexInicio = workString.indexOf(campo, 0);
			indexInicioDoValor = workString.indexOf(":", indexInicio);
			finalIndex = workString.indexOf(",", indexInicioDoValor);
		} else if(index==2) {
			indexInicio = workString.lastIndexOf(campo);
			indexInicioDoValor = workString.indexOf(":", indexInicio);
			finalIndex = workString.indexOf(",", indexInicioDoValor);
		
		}else{
			indexInicio = workString.lastIndexOf(campo);
			indexInicioDoValor = workString.indexOf(":", indexInicio);
			finalIndex = workString.indexOf(",", indexInicioDoValor);
			finalIndex = workString.indexOf(",", finalIndex+1);
		}

		retorno = workString.substring(indexInicioDoValor + 1, finalIndex);
		if(index==3){
			retorno = retorno.replaceAll(",\"", " ");
			retorno = retorno.replaceAll("\"", "");
			retorno = retorno.replaceAll(",", " ");
		}

		return retorno;

	}

	private static String lerCSV(String nomeArquivo) {
		BufferedReader bufferedReader = null;
		StringBuilder builderLinha = new StringBuilder();

		try {
			bufferedReader = new BufferedReader(new FileReader(nomeArquivo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				builderLinha.append(linha);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String linhaLimpa = builderLinha.toString();
		

		String retorno = linhaLimpa.replaceAll("\"ORDEM  DE SERVIÇO DA MANUTENÇAO\",", "")
				.replaceAll("\"Documento de Origem\",", "").replaceAll("\"Localizaçao\",", "")
				.replaceAll("\"Serviço a ser Executado\",", "").replaceAll("\"Solicitação de Acesso\",", "")
				.replaceAll(",00", "").replaceAll(":\",", "\":").replaceAll(": \",", "\":").replaceAll(",,", ",")
				.replaceAll(" \"", "\"").replaceAll(",\"/\",", "/").replaceAll("  ", " ").replaceAll("L - E", " L - E");

	

		return retorno;
	}

}
