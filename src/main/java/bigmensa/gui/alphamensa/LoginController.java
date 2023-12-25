package bigmensa.gui.alphamensa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button login;

    @FXML
    protected void onButtonClick(ActionEvent event) throws IOException {
        try {
            // Carica la nuova pagina da un altro file FXML
            FXMLLoader loader = new FXMLLoader(LoginAvvio.class.getResource("home.fxml"));
            Parent root = loader.load();

            // Crea la nuova scena
            Scene nuovaScena = new Scene(root);

            // Ottieni il palcoscenico corrente
            Stage stage = (Stage) login.getScene().getWindow();

            // Imposta la nuova scena sul palcoscenico
            stage.setScene(nuovaScena);

        } catch (IOException e) {
            e.printStackTrace();
            // Gestisci l'eccezione se il caricamento della nuova pagina fallisce
        }
    }
}
