package main.java.fx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.CSVReader;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {
    private static final Logger LOGGER = Logger.getLogger(CSVReader.class.getName());
    @FXML
    Button npcButton;

    @FXML
    public void initialize() {
        npcButton.setOnAction(event -> createNPC());
    }

    private void createNPC() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/npc/createNPC.fxml"));
            Parent charWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(charWindow));
            stage.show();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Cannot open NPC Creation" + e.getMessage());
        }
    }
}
