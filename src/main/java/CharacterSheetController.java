package main.java;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.enums.AbilityType;
import main.java.enums.ClassType;
import main.java.enums.RaceType;
import main.java.enums.SkillType;
import main.java.utils.AbilityUtils;
import main.java.utils.SkillUtils;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class CharacterSheetController implements Initializable{
    @FXML
    TextField name;
    @FXML
    TextField race;
    @FXML
    TextField classType;

    @FXML
    TextField strValue;
    @FXML
    TextField dexValue;
    @FXML
    TextField conValue;
    @FXML
    TextField intValue;
    @FXML
    TextField wisValue;
    @FXML
    TextField chaValue;

    @FXML
    TextField strMod;
    @FXML
    TextField dexMod;
    @FXML
    TextField conMod;
    @FXML
    TextField intMod;
    @FXML
    TextField wisMod;
    @FXML
    TextField chaMod;

    @FXML
    VBox skills;
    private Character character;
    public CharacterSheetController(Character character)
    {
        this.character = character;
    }
    @FXML
    public void initialize(URL location, ResourceBundle resources)
    {
        setAbilities();
        name.setText(character.getName());
        classType.setText(character.getClassType().name());
        race.setText(character.getRaceType().name());
        Map<SkillType, Integer> totalSkills = character.getTotalSkills();
        character.getSkills().forEach((skillType, value) -> {
            int mod = SkillUtils.getModifier(skillType, character.getAbilities());
            HBox skillLine = new HBox();
            Label skillLabel = new Label(skillType.name());
            TextField total = new TextField(totalSkills.get(skillType).toString());
            TextField modifier = new TextField(Integer.toString(mod));
            TextField ranks = new TextField(value.toString());
            if (character.getClassSkills().contains(skillType)) {
                skillLine.getChildren().add(new Text("*"));
            }
            skillLine.getChildren().addAll(skillLabel, total, modifier, ranks);
            skills.getChildren().add(skillLine);
        });
    }

    private void setAbilities()
    {
        Map<AbilityType, Integer> abilities = character.getAbilities();
        Map<AbilityType, Integer> modifiers = AbilityUtils.getModifiers(abilities);

        strValue.setText(abilities.get(AbilityType.STR).toString());
        dexValue.setText(abilities.get(AbilityType.DEX).toString());
        conValue.setText(abilities.get(AbilityType.CON).toString());
        intValue.setText(abilities.get(AbilityType.INT).toString());
        wisValue.setText(abilities.get(AbilityType.WIS).toString());
        chaValue.setText(abilities.get(AbilityType.CHA).toString());

        strMod.setText(modifiers.get(AbilityType.STR).toString());
        dexMod.setText(modifiers.get(AbilityType.DEX).toString());
        conMod.setText(modifiers.get(AbilityType.CON).toString());
        intMod.setText(modifiers.get(AbilityType.INT).toString());
        wisMod.setText(modifiers.get(AbilityType.WIS).toString());
        chaMod.setText(modifiers.get(AbilityType.CHA).toString());
    }
}
