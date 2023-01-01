package combina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Combinacoes {

	private Map<Integer, List<Integer>> combinacoes;
	
	

	public Combinacoes() {
		this.combinacoes = new HashMap<>();
	}

	public void gerarCombinacoes() {
		Integer contador = 0;
		List<Integer> dezenas;

		for (int i = 1; i <= 80; i++) {

			for (int j = i + 1; j <= 80; j++) {

				for (int k = j + 1; k <= 80; k++) {
					dezenas = new ArrayList<>();
					contador++;
					dezenas.add(i);
					dezenas.add(j);
					dezenas.add(k);
					combinacoes.put(contador, dezenas);
				

				}
			}
		}
	}

	public Map<Integer, List<Integer>> getCombinacoes() {
		return combinacoes;
	}


	


}
