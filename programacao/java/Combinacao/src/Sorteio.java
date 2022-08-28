package combina;

import java.util.ArrayList;
import java.util.List;

public class Sorteio {

	private int numeroDoSorteio;
	private List<Integer> dezenas;
	private int numeroDeGanhadores;
	

	public Sorteio() {
		this.dezenas = new ArrayList<>();
	}

	
	
	public void add(Integer dezena) {
		this.dezenas.add(dezena);
	}

	public boolean contemDezena(Integer dezena) {
		return dezenas.contains(dezena);
	}

	public int getNumeroDoSorteio() {
		return numeroDoSorteio;
	}

	public void setNumeroDoSorteio(int numeroDoSorteio) {
		this.numeroDoSorteio = numeroDoSorteio;
	}

	public int getNumeroDeGanhadores() {
		return numeroDeGanhadores;
	}

	public void setNumeroDeGanhadores(int numeroDeGanhadores) {
		this.numeroDeGanhadores = numeroDeGanhadores;
	}

	public List<Integer> getDezenas() {
		return dezenas;
	}
	
}
