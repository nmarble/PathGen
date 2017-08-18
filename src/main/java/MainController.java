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
import main.java.utils.AbilityUtils;
import main.java.utils.ClassUtils;
import main.java.utils.RaceUtils;
import main.java.utils.SkillUtils;

import java.io.IOException;

public class MainController {
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
        okButton.setText("CREATE");
    }

    private void onOk()
    {
        Character newChar = new Character(nameField.getText());
        if (classField.getValue() != null)
        {
            newChar.setClassType(classField.getValue());
        }else
        {
            newChar.setClassType(ClassUtils.getRandomClass());
        }
        if (raceField.getValue() != null)
        {
            newChar.setRaceType(raceField.getValue());
        }else
        {
            newChar.setRaceType(RaceUtils.getRandomRace());
        }
        newChar.setAbilities(AbilityUtils.getRandomStats(newChar.getClassType()));
        newChar.setSkills(SkillUtils.getRandomSkills(newChar));
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/characterSheet.fxml"));
            CharacterSheetController controller = new CharacterSheetController(newChar);
            fxmlLoader.setController(controller);
            Parent charWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(charWindow));
            stage.show();
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
