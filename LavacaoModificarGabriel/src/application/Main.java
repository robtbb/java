package application;

import db.DbException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private static Scene mainScene;

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginView.fxml"));
			VBox vBox = loader.load();
			mainScene = new Scene(vBox);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("LavaCar - AutoClean");
			primaryStage.show();
		} catch (IOException e) {
			throw  new DbException("Erro ao carregar a View");
		}
	}

	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
