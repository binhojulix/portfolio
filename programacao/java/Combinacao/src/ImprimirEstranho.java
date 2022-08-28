package Prinicipal;

public class ImprimirEstranho {

	public static void main(String[] args) {
		int numeros[] = new int[94];
		int posicao = 0;

		for (int i = 1; i < 90; i += 4) {

			numeros[posicao + 0] = i + 0; // impar
			numeros[posicao + 1] = i + 2; // impar
			numeros[posicao + 2] = i + 3; // par invertido
			numeros[posicao + 3] = i + 1; // par invertido

			posicao += 4;
		}

		numeros[92] = 93;
		numeros[93] = 95;

		for (Integer n : numeros)
			System.out.println(n);
	}
}
