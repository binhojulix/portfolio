package br.com.printer.jasper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

public class Jasper  {

	private String fileName;
	private List<Object> objetos;

	public Jasper(String fileName, List<Object> objetos) {
		this.fileName = fileName;
		this.objetos = objetos;
	}
	

	public void gerarPDF() {

		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(objetos);
		try {

			JasperCompileManager.compileReport("ordemdeservico.jrxml");

			Map<String, Object> parametros = new HashMap<String, Object>();

			JasperPrint print = JasperFillManager.fillReport("ordemdeservico.jasper", parametros,
					beanCollectionDataSource);

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			FileOutputStream out = new FileOutputStream("C:/Users/fabiolu/Desktop/config/" + fileName + ".pdf");
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			
			exporter.exportReport();
			out.close();
		
			JasperViewer.viewReport(print, false);

		} catch (JRException jre) {
			throw new RuntimeException();
		} catch (IOException io) {
			throw new RuntimeException();

		}

	}

	
}
