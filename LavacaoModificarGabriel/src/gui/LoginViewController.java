package gui;

import application.Main;
import gui.util.Alertas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

public class LoginViewController implements Initializable {

	@FXML
	private VBox vBoxUsuarioImg;
	@FXML
	private VBox vBoxPrincipal;
	@FXML
	private TextField lbEmailLogin;
	@FXML
	private PasswordField passWordSenha;
	@FXML
	private ToggleButton togleBtEntrar;

	@FXML
	public void onToggleBtEntrarAction() {
		loadView("/gui/InteracaoMainView.fxml");
	}

	@FXML
	private ToggleButton toggleBtCadastrar;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		addImagemAoVBox(vBoxUsuarioImg, "/resources/img/Usuario.png");

		// Caminho para a imagem de fundo
		String caminhoImagem = "/resources/img/lavacaoFosco.jpg";
		// Carregue a imagem
		Image imagem = new Image(getClass().getResource(caminhoImagem).toExternalForm());
		// Crie o BackgroundImage com a imagem carregada
		BackgroundImage backgroundImage = new BackgroundImage(
						imagem,
						BackgroundRepeat.NO_REPEAT, // Não repetir a imagem
						BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, // Centralizar a imagem
						BackgroundSize.DEFAULT // Manter o tamanho original da imagem
		);
		Background background = new Background(backgroundImage);
		// Definindo o Background no VBox
		vBoxPrincipal.setBackground(background);
	}

	public void addImagemAoVBox(VBox vBox, String caminhoImagem) {
		URL imageUrl = getClass().getResource(caminhoImagem);
		Image imagem = new Image(imageUrl.toExternalForm());
		// Cria ImageView para a imagem
		ImageView imageView = new ImageView(imagem);
		Platform.runLater(() -> {
			double largura = 50;
			double altura = 50;
			imageView.setFitWidth(largura);
			imageView.setFitHeight(altura);
		});
		imageView.setPreserveRatio(true);
		vBox.getChildren().add(imageView);
	}

	private synchronized void loadView(String caminhoView) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoView));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) mainScene.getRoot();
			mainVBox.getChildren().clear();
			mainVBox.getChildren().addAll(newVBox.getChildren());
			VBox.setVgrow(newVBox, javafx.scene.layout.Priority.ALWAYS);
		} catch (IOException e) {
			Alertas.apresentaAlertas("IO Exception", "Erro ao carregar a View", e.getMessage(), Alert.AlertType.ERROR);
		}
	}

}
