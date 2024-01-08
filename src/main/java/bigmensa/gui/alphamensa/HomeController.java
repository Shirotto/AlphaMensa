package bigmensa.gui.alphamensa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button prenota;

    @FXML
    private Button posti;

    @FXML
    protected void onPrenotaClick(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(LoginAvvio.class.getResource("prenota.fxml"));
            Parent root = loader.load();
            Scene nuovaScena = new Scene(root);
            Stage stage = (Stage) prenota.getScene().getWindow();
            stage.setScene(nuovaScena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onPostiClick(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(LoginAvvio.class.getResource("posti.fxml"));
            Parent root = loader.load();
            Scene nuovaScena = new Scene(root);
            Stage stage = (Stage) posti.getScene().getWindow();
            stage.setScene(nuovaScena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
