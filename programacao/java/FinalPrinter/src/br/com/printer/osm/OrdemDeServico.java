package br.com.printer.osm;

import br.com.printer.extracttext.FieldCapture;

public class OrdemDeServico {

	private String numero;
	private String area;
	private String data;
	private String centroDeCusto;
	private String sistema;
	private String equipe;
	private String tipoDeIntervencao;
	// Documento de origem
	private String tipo;
	private String ssm;
	private String data2;
	private String nivelFalha;
	private String area2;
	private String centroDeCusto2;
	private String solicitante;
	private String telefone;
	// Localizacao
	private String linha;
	private String trecho;
	private String localidade;

	// Servico a ser executado
	private String avaria;
	private String servico;

	private FieldCapture fieldCapture;

	public OrdemDeServico(String nomeArquivo) {
		this.fieldCapture = new FieldCapture(nomeArquivo);
	}

	public String getNumero() {
		this.numero = fieldCapture.getCampo(Fields.NUMERO, 1);
		return numero;
	}

	public String getArea() {
		this.area = fieldCapture.getCampo(Fields.AREA, 1);
		return area;
	}

	public String getData() {
		this.data = fieldCapture.getCampo(Fields.DATA_HORA, 1);
		return data;
	}

	public String getCentroDeCusto() {
		this.centroDeCusto = fieldCapture.getCampo(Fields.CENTRO_CUSTO, 1);
		return centroDeCusto;
	}

	public String getSistema() {
		this.sistema = fieldCapture.getCampo(Fields.SISTEMA, 1);
		return sistema;
	}

	public String getEquipe() {
		this.equipe = fieldCapture.getCampo(Fields.EQUIPE, 1);
		return equipe;
	}

	public String getTipoDeIntervencao() {
		this.tipoDeIntervencao = fieldCapture.getCampo(Fields.TIPO_DE_INTERVENCAO, 1);
		return tipoDeIntervencao;
	}

	private String getTipo() {
		this.tipo = fieldCapture.getCampo(Fields.TIPO, 3);
		return tipo;
	}

	public String getSsm() {
		this.ssm= fieldCapture.getCampo(Fields.NUMERO_SSM, 1);
		return ssm;
	}

	public String getData2() {
		this.data2= fieldCapture.getCampo(Fields.DATA_HORA2, 2);
		return data2;
	}

	public String getNivelFalha() {
		this.nivelFalha = fieldCapture.getCampo(Fields.NIVEL_FALHA, 1);
		return nivelFalha;
	}

	public String getArea2() {
		this.area2 = fieldCapture.getCampo(Fields.AREA2, 2);
		return area2;
	}

	public String getCentroDeCusto2() {
		this.centroDeCusto2= fieldCapture.getCampo(Fields.CENTRO_CUSTO2, 2);
		return centroDeCusto2;
	}

	public String getSolicitante() {
		this.solicitante = fieldCapture.getCampo(Fields.SOLICITANTE, 3);
		return solicitante;
	}
	
	public String getTelefone() {
		this.telefone = fieldCapture.getCampo(Fields.TELEFONE, 1);
		return telefone;
	}

	public String getLinha() {
		this.linha = fieldCapture.getCampo(Fields.LINHA, 1);
		return linha;
	}

	public String getTrecho() {
		this.trecho = fieldCapture.getCampo(Fields.TRECHO, 1);
		return trecho;
	}

	public String getLocalidade() {
		this.localidade = fieldCapture.getCampo(Fields.LOCALIDADE, 3);
		return localidade;
	}

	public String getAvaria() {
		this.avaria = fieldCapture.getCampo(Fields.AVARIA, 1);
		return avaria;
	}

	public String getServico() {
		this.servico = fieldCapture.getCampo(Fields.SERVICO, 1);
		return servico;
	}
	


	@Override
	public String toString() {
		return "OrdemDeServico [numero=" + getNumero() + ", area=" + getArea() + ", data=" + getData()
				+ ", centroDeCusto=" + getCentroDeCusto() + "\nsistema=" + getSistema() + "," + " equipe="
				+ getEquipe() + "\ntipoDeIntervencao=" + getTipoDeIntervencao() + "\ntipo=" + getTipo() + ", ssm="
				+ getSsm() + ", data2=" + getData2() + ", nivelFalha=" + getNivelFalha() + "\narea2=" + getArea2()
				+ ", centroDeCusto2=" + getCentroDeCusto2() + "\nsolicitante=" + getSolicitante() + ",Telefone" + getTelefone()+"\nlinha="
				+ getLinha() + ", trecho=" + getTrecho() + ",localidade=" + getLocalidade() + "\navaria=" + getAvaria()
				+ "\nservico=" + getServico() + "]";
	}

}
