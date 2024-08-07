package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {

	public static void apresentaAlertas( String titulo, String cabeca, String Corpo, AlertType tipo) {
		Alert alerta = new Alert(tipo);
		alerta.setTitle(titulo);
		alerta.setHeaderText(cabeca);
		alerta.setContentText(Corpo);
		alerta.show();		
	}
}
