package main.java.npc.fx;

import javafx.collections.FXCollections;
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
import main.java.enums.Sex;
import main.java.npc.NPCCharacter;
import main.java.utils.*;

import java.io.IOException;

public class CreateNPCController {
    @FXML
    TextField nameField;

    @FXML
    ComboBox<RaceType> raceField;

    @FXML
    ComboBox<ClassType> classField;

    @FXML
    ComboBox<Sex> sexField;

    @FXML
    Button okButton;

    @FXML
    public void initialize() {
        sexField.setItems(FXCollections.observableArrayList(Sex.values()));
        raceField.setItems(FXCollections.observableArrayList(RaceType.values()));
        classField.setItems(FXCollections.observableArrayList(ClassType.values()));
        okButton.setOnAction(event -> onCreate());
    }

    private void onCreate() {
        NPCCharacter newChar = new NPCCharacter();
        newChar.setClassType(classField.getValue() != null ? classField.getValue() : ClassUtils.getRandomClass());
        newChar.setRaceType(raceField.getValue() != null ? raceField.getValue() : RaceUtils.getRandomRace());
        newChar.setSex(sexField.getValue() != null ? sexField.getValue() : SexUtils.getRandomSex());
        newChar.setName(nameField.getText().equals(null) ? nameField.getText() : NameUtils.getRandomName(newChar.getSex(), newChar.getRaceType()));
        newChar.setAbilities(AbilityUtils.getRandomStats(newChar.getClassType()));
        newChar.setSkills(SkillUtils.getRandomSkills(newChar));
        newChar.setStartingHP();
        newChar.setAlignmentType(AlignmentUtils.getRandomAlignmentType());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/characterSheet.fxml"));
            NPCSheetController controller = new NPCSheetController(newChar);
            fxmlLoader.setController(controller);
            Parent charWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(charWindow));
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
