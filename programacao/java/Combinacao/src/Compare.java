package combina;

import java.util.List;

public class Compare {

	public static int item;
	public List<Integer> combinacao;
	public int quantidade;

	public Compare(List<Integer> possivel) {
		this.quantidade = 0;
		item += 1;
		this.combinacao = possivel;
	}

	public void isTerno(List<Integer> a) {
		int contador = 0;
		for (Integer l1 : a) {
			for (Integer l2 : combinacao) {
				if (l1 == l2)
					contador++;

			}
		}
		if (contador >= 3) {
			this.quantidade++;
		}

	}

	@Override
	public String toString() {
		int contador = 0;
		StringBuilder retorno = new StringBuilder();
		retorno.append(item).append(";");
		for (Integer i : combinacao)
			retorno.append(i).append(";");
		

		retorno.append(quantidade);

		return retorno.toString();
	}

}
