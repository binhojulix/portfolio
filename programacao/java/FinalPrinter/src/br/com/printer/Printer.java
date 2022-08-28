package br.com.printer;

import java.util.ArrayList;
import java.util.List;
import br.com.printer.fileoperation.FileCrud;
import br.com.printer.jasper.Jasper;
import br.com.printer.osm.OrdemDeServico;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Printer extends Application {

	final FileCrud crud = new FileCrud();
	final ListView<String> lista = new ListView<>();

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		pane.setMinWidth(400);

		Button btImprimir = new Button("Imprimir");
		Button btAtualizar = new Button("Atualizar");

		lista.setItems(FXCollections.observableArrayList(crud.listarNomeArquivo()));

		pane.getChildren().addAll(lista, btImprimir, btAtualizar);

		stage.getIcons().add(new Image(getClass().getResourceAsStream("img/logo.PNG")));
		stage.setTitle("ORDENS DE SERVIÇOS A SER IMPRESSAS");

		Scene scene = new Scene(pane);
		scene.getStylesheets().add("style.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

		btImprimir.setPrefWidth(pane.getWidth());
		btAtualizar.setPrefWidth(pane.getWidth());
		btAtualizar.setLayoutY(btImprimir.getHeight());
		btAtualizar.getStyleClass().add("button-red");
		lista.setPrefWidth(pane.getWidth());
		lista.setLayoutY(btImprimir.getHeight() + btAtualizar.getHeight());

		btAtualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				lista.setItems(FXCollections.observableArrayList(crud.listarNomeArquivo()));
			}
		});

		btImprimir.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				imprimirOSM();
				lista.setItems(FXCollections.observableArrayList(crud.listarNomeArquivo()));
			}

		});

	}

	
	
	public void imprimirOSM() {

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
