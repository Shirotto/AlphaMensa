package bigmensa.gui.alphamensa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrenotaController implements Initializable {
    @FXML
    private ChoiceBox<String> ora;
    @FXML
    private ChoiceBox<String> posto;
    @FXML
    private Button prenota;
    private ObservableList<String> listaOra = FXCollections.observableArrayList("12:00", "12:30", "13:00", "13:30");
    private ObservableList<String> listaPosto = FXCollections.observableArrayList("1A", "1B", "1C", "1D", "1E");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ora.setItems(listaOra);
        posto.setItems(listaPosto);
        prenota.setDisable(true);
        ora.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updatePrenotaButton());
        posto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updatePrenotaButton());
    }

    @FXML
    protected void onPrenotaClick(ActionEvent event) {
        if (isValidSelection()) {
            showAlert("Hai prenotato!");
            PostiController.numeroPosti--;
        } else {
            showAlert("Seleziona un'ora e un posto prima di prenotare.");
        }
    }

    private void updatePrenotaButton() {
        prenota.setDisable(!isValidSelection());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle("Prenotazione");
        alert.setHeaderText(null);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    FXMLLoader loader = new FXMLLoader(LoginAvvio.class.getResource("home.fxml"));
                    Parent root = loader.load();
                    Scene nuovaScena = new Scene(root);
                    Stage stage = (Stage) prenota.getScene().getWindow();
                    stage.setScene(nuovaScena);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean isValidSelection() {
        return ora.getValue() != null && posto.getValue() != null;
    }
}
