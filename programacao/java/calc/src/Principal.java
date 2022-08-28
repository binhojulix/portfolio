import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		// até aqui não faz nada além de pegar o número informado pelo usuário
		System.out.println("Digite um número");
		Scanner entrada = new Scanner(System.in);
		int tamanhoOriginal = entrada.nextInt();
		// fim

		// até aqui so preenche uma lista
		List<Integer> lista = new ArrayList<>();
		for (int i = 1; i <= tamanhoOriginal; i++) {
			lista.add(i);
		}
		// fim

		// booleano de interação
		boolean remover = false;
		//boolean para imprimir  a primeira vez
		boolean primeiraVez = true;

		while (lista.size() >= 2) {
			
			//Lista criada para os elementos que deverão ser removidos
			List<Integer> toRemove = new ArrayList<>();

			for (Integer l : lista) {

				//verifica se a primeira interacao do loop se for cai no break e imprime a lista completa
				if (primeiraVez) {
					primeiraVez = false;
					break;
				}

				// alterna o variavel boolean de interacao
				remover = !remover;

				if (remover) {
					//adiciona todos os elementos que deverão ser eliminados
					toRemove.add(l);
				}

			}
			
			//remove todos os elementos da lista original
			lista.removeAll(toRemove);
			//faz a impressao
			System.out.println(lista.toString());

		}
	}

}
