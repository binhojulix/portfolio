import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Principal {
	/*
	 * public static List<String> strings() { List<String> combinacoes = new
	 * ArrayList<>();
	 * 
	 *
	 * 
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * 
	 * 
	 * combinacoes.add(1 + "-" + 2 + "-" + 4+ "-" + 10 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 7 + "-" + 8);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 5 + "-" + 6);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 7 + "-" + 8);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 5 + "-" + 6);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 7 + "-" + 8);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 5 + "-" + 6);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 7 + "-" + 8);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 5 + "-" + 6);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 7 + "-" + 8);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 5 + "-" + 6);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 7 + "-" + 8);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 5 + "-" + 6);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 4 + "-" + 7 + "-" + 8);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 6 + "-" + 9 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 3 + "-" + 9 + "-" + 11 + "-" + 12);
	 * combinacoes.add(1 + "-" + 2 + "-" + 4 + "-" + 5 + "-" + 7 + "-" + 9);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 01;02;05;06;07;11 01;02;05;08;09;10 01;02;07;08;09;10 01;03;04;08;10;12
	 * 01;03;05;07;09;12 01;03;05;07;10;11 01;03;05;08;09;11 01;03;06;07;09;10
	 * 01;04;05;07;09;12 01;04;06;08;09;11 01;04;06;09;10;11 01;05;06;08;10;12
	 * 01;06;07;08;11;12 02;03;04;05;09;10 02;03;04;07;09;11 02;03;05;07;08;12
	 * 02;03;05;07;10;12 02;03;06;08;10;11 02;04;05;08;11;12 02;04;06;07;10;12
	 * 02;04;06;08;09;12 02;04;06;08;10;11 02;05;06;07;09;11 03;04;05;06;11;12
	 * 02;04;06;07;11;12 03;04;08;09;10;12 03;05;06;07;08;09 03;06;08;10;11;12
	 * 04;05;06;07;08;10 04;05;07;08;10;11 05;06;09;10;11;12 07;08;09;10;11;12
	 * 
	 * return combinacoes; }
	 */
	public static List<String> combina6() {

		List<String> combinacoes = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			for (int j = i + 1; j <= 12; j++) {
				for (int k = j + 1; k <= 12; k++) {
					for (int l = k + 1; l <= 12; l++) {
						for (int m = l + 1; m <= 12; m++) {
							for (int n = m + 1; n <= 12; n++) {

								String combinacao = i + "-" + j + "-" + k + "-" + l + "-" + m + "-" + n;
								combinacoes.add(combinacao);
							}
						}
					}
				}
			}
		}

		return combinacoes;
	}

	public static List<String> combina5() {

		List<String> combinacoes = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			for (int j = i + 1; j <= 12; j++) {
				for (int k = j + 1; k <= 12; k++) {
					for (int l = k + 1; l <= 12; l++) {
						for (int m = l + 1; m <= 12; m++) {

							String combinacao = i + "-" + j + "-" + k + "-" + l + "-" + m;
							combinacoes.add(combinacao);

						}
					}
				}
			}
		}

		return combinacoes;
	}

	public static void main(String[] args) throws InterruptedException {

		List<String> combinacao6 = combina6();
		List<String> combinacao5 = combina5();
		List<Integer> contadores = new ArrayList<>();

		for (String s1 : combinacao6) {
			for (String s2 : combinacao5) {

				int contador = s1.compareTo(s2);

				if (contador <= 2 && contador >= 0) {
					contadores.add(contador);
				}
			}
			break;
		}
		System.out.println(contadores.size());

		System.out.println("finalizou");

	}

}
