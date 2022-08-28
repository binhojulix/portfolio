package br.com.printer.fileoperation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.printer.extracttext.FieldCapture;
import br.com.printer.osm.Fields;

public class FileCrud {

	// retorna o nome do diretorio principal
	private File getDiretorioName() {
		String user = System.getProperty("user.name");
		StringBuilder diretorio = new StringBuilder();
		diretorio.append("C:");
		diretorio.append(File.separator);
		diretorio.append("Users");
		diretorio.append(File.separator);
		diretorio.append(user);
		diretorio.append(File.separator);
		diretorio.append("Desktop");
		diretorio.append(File.separator);
		diretorio.append("config");
		File file = new File(diretorio.toString());
		file.mkdir();
		return file;
	}

	public List<String> listarDiretorioCompleto() {
		File file = getDiretorioName();
		File afile[] = file.listFiles();
		List<String> arquivosCSVS = new ArrayList<>();
		for (File f : afile) {
			if (f.getName().endsWith(".csv"))
				arquivosCSVS.add(f.getAbsolutePath());
		}
		
		return arquivosCSVS;
	}

	
	public List<String> listarNomeArquivo() {
		List<String> arquivosCSVS = new ArrayList<>();
		for (String s : listarDiretorioCompleto()) {
			String file = "OSM: " + new FieldCapture(s).getCampo(Fields.NUMERO, 1);
			arquivosCSVS.add(file);

		}
		return arquivosCSVS;
	}

	
	
	public void deletar() {
		List<String> lista = new ArrayList<>(listarDiretorioCompleto());
		for (String arquivo : lista) {
			new File(arquivo).delete();
		}

	}
}
