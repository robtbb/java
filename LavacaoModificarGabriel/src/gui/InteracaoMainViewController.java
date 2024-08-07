package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alertas;
import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class InteracaoMainViewController implements Initializable {

	@FXML
	private VBox mainVBox;
	@FXML
	private MenuBar mainMenuBar;
	@FXML
	private StackPane stackPaneLogin;

	@FXML
	private StackPane stackPanePgPrincipal;

	@FXML
	private MenuItem menuItemServico;

	@FXML
	private MenuItem menuItemProduto;

	@FXML
	private MenuItem menuItemInformacoes;

	@FXML
	private MenuItem menuItemTerceiro;

	@FXML
	public void onMenuItemServico() {
		loadViewSemFilhos("/gui/ServicoListView.fxml" ,x -> {} );
	}

	@FXML
	public void onMenuItemProduto() {
		loadView("/gui/LoginView.fxml", x-> {});
	}

	@FXML
	public void onMenuItemInformacoes() {
		loadView("/gui/InformacoesView.fxml", x -> {});
	}

	@FXML
	public void onMenuItemTerceiro() {
		System.out.println("Terceiro");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		URL imageUrl = getClass().getResource("/resources/img/lavacao.jpg");
		Image imagem = new Image(imageUrl.toExternalForm());
		// Cria ImageView para a imagem
		ImageView imageView = new ImageView(imagem);
		
		Platform.runLater(() -> {
			imageView.setFitWidth(780);
			imageView.setFitHeight(473);
		});
		imageView.setPreserveRatio(true);
		stackPanePgPrincipal.getChildren().add(imageView);
	}

	private synchronized <T> void loadView(String caminhoView , Consumer<T> acaoInicializadora) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoView));
			VBox newVBox = loader.load();

			//REFERENCIA DO MAINSCENE PRINCIPAL
			Scene mainScene = Main.getMainScene();
			Node root = mainScene.getRoot();
			mainVBox = (VBox) root;
			//PRIMEIRO FILHO DO VBOX DA JANELA PRINCIPAL(GUARDANDO UMA REFERENCIA)
			Node mainMenu = mainVBox.getChildren().get(0);
			//LIMPANDO TODOS OS FILHOS DO MAINVBOX
			mainVBox.getChildren().clear();
			//ADD O MAINMENU NO MAINVBOX PARA MANTER A BARRA DE NAVEGAÇÃO
			mainVBox.getChildren().add(mainMenu);
			//ADD NO VBOX PRINCIPAL OS FILHOS DO NEWVBOX PARA SOBREPOR A TELA GERANDO UMA SCENA
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			acaoInicializadora.accept(controller);

		} catch (IOException e) {
			Alertas.apresentaAlertas("IO Exception", "Erro ao carregar a View", e.getMessage(), AlertType.ERROR);
		}
	}
	private synchronized <T> void loadViewSemFilhos(String caminhoView, Consumer<T> acaoInicializadora) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoView));
			VBox newVBox = loader.load();

			//REFERENCIA DO MAINSCENE PRINCIPAL
			Scene mainScene = Main.getMainScene();
			Node root = mainScene.getRoot();
			mainVBox = (VBox) root;
			mainVBox.getChildren().clear();
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			acaoInicializadora.accept(controller);

		} catch (IOException e) {
			Alertas.apresentaAlertas("IO Exception", "Erro ao carregar a View", e.getMessage(), AlertType.ERROR);
		}
	}
}
