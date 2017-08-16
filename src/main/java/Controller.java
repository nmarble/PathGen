package main.java;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.java.enums.ClassType;
import main.java.enums.RaceType;
import main.java.utils.AbilityUtils;

public class Controller {
    @FXML
    TextField nameField;

    @FXML
    ComboBox<RaceType> raceField;

    @FXML
    ComboBox<ClassType> classField;

    @FXML
    Button okButton;

    @FXML
    public void initialize()
    {
        raceField.setItems(FXCollections.observableArrayList(RaceType.values()));
        classField.setItems(FXCollections.observableArrayList(ClassType.values()));
        okButton.setOnAction(event -> onOk());
    }

    private void onOk()
    {
        Character testChar = new Character(nameField.getText());
        testChar.setClassType(classField.getValue());
        testChar.setRaceType(raceField.getValue());
        testChar.setAbilities(AbilityUtils.getRandomStats(testChar.getClassType()));
    }
}
