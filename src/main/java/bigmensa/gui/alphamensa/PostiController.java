package bigmensa.gui.alphamensa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;


public class PostiController {
    @FXML
    private Button visualizza;
    public static int numeroPosti = 100;

    public void OnvisualClick(ActionEvent e) {
        showAlert("Ci sono " + numeroPosti + " posti disponibili");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle("Posti disponibili");
        alert.setHeaderText(null);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    FXMLLoader loader = new FXMLLoader(LoginAvvio.class.getResource("home.fxml"));
                    Parent root = loader.load();
                    Scene nuovaScena = new Scene(root);
                    Stage stage = (Stage) visualizza.getScene().getWindow();
                    stage.setScene(nuovaScena);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
