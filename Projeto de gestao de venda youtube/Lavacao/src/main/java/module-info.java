module robert.lavacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens robert.lavacao to javafx.fxml;
    exports robert.lavacao;
}