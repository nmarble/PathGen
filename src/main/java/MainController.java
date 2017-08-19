package main.java;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.enums.ClassType;
import main.java.enums.RaceType;
import main.java.utils.*;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {
    private static final Logger LOGGER = Logger.getLogger( CSVReader.class.getName() );
    @FXML
    Button npcButton;

    @FXML
    public void initialize()
    {
        npcButton.setOnAction(event -> createNPC());
    }

    private void createNPC()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/createNPC.fxml"));
            Parent charWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(charWindow));
            stage.show();
        }catch (IOException e) {
            LOGGER.log(Level.WARNING, "Cannot open NPC Creation" + e.getMessage());
        }
    }
}
