package br.com.printer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import br.com.printer.fileoperation.FileCrud;
import br.com.printer.jasper.Jasper;
import br.com.printer.osm.OrdemDeServico;

public class Printer {

	final static FileCrud crud = new FileCrud();
	static JList<Object> list = new JList<>(crud.listarNomeArquivo().toArray());

	public static void main(String[] args) {
		start();
	}

	public static void start() {

		JPanel pane = new JPanel();
		pane.setLayout(
				  new BoxLayout(pane, BoxLayout.Y_AXIS));
	

		
		
		JButton btImprimir = new JButton("Imprimir");
		JButton btAtualizar = new JButton("Atualizar");
		JPanel painelButton = new JPanel();
		painelButton.add(btImprimir);
		painelButton.add(btAtualizar);
		

		

		
		pane.add(list);
		pane.add(painelButton);


		JFrame janela = new JFrame("Ordens de Serviços a Ser impressas");
		janela.setResizable(false);
		janela.setIconImage(new ImageIcon("logo.png").getImage());
		janela.add(pane);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);

		btAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 list = new JList<>(crud.listarNomeArquivo().toArray());
				
			}
		});

		btImprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				imprimirOSM();
				 list = new JList<>(crud.listarNomeArquivo().toArray());
			}
		});

	}

	public static void imprimirOSM() {

		List<String> lista = crud.listarDiretorioCompleto();
		List<OrdemDeServico> ordemDeServicos = new ArrayList<>();
		for (String s : lista) {
			ordemDeServicos.add(new OrdemDeServico(s));

		}
		if (!ordemDeServicos.isEmpty()) {
			Jasper jasper = new Jasper("OSMS", new ArrayList<Object>(ordemDeServicos));
			jasper.gerarPDF();
			crud.deletar();
		}

	}

}
