package main.java.fx;

import com.sun.corba.se.impl.orb.ParserTable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.Character;
import main.java.enums.AbilityType;
import main.java.enums.SaveType;
import main.java.enums.SkillType;
import main.java.utils.AbilityUtils;
import main.java.utils.AlignmentUtils;
import main.java.utils.SkillUtils;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

public class CharacterSheetController implements Initializable {
    @FXML
    TabPane tabPane;

    @FXML
    Tab npcDetailsTab;

    @FXML
    TextField name;
    @FXML
    TextField race;
    @FXML
    TextField classType;
    @FXML
    TextField sex;
    @FXML
    TextField hp;
    @FXML
    TextField level;
    @FXML
    TextField speed;
    @FXML
    private TextField alignment;

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
    @FXML
    VBox saves;
    @FXML
    HBox baseAttack;
    @FXML
    VBox combatManeuvers;



    private Character character;

    public CharacterSheetController(Character character) {
        this.character = character;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        removeExtraTabs();
        setAbilities();
        name.setText(character.getName());
        classType.setText(character.getClassType().name());
        race.setText(character.getRaceType().name());
        sex.setText(character.getSex().getName());
        level.setText(Integer.toString(character.getLevel()));
        hp.setText(Integer.toString(character.getHP()));
        speed.setText(Integer.toString(character.getSpeed()));
        alignment.setText(character.getAlignmentType().toString());
        setSkills();
        setSaves();
        setBaseAttack();
        setCombatManeuvers();
    }

    private void removeExtraTabs() {
        tabPane.getTabs().removeAll(npcDetailsTab);
    }
    private void setAbilities() {
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

    private void setSkills() {
        Map<SkillType, Integer> totalSkills = character.getTotalSkills();
        character.getSkills().forEach((skillType, value) -> {
            int mod = SkillUtils.getModifier(skillType, character.getAbilities());
            HBox skillLine = new HBox();
            Label skillLabel = new Label(skillType.name());
            skillLabel.setPrefWidth(200);
            TextField total = new TextField(totalSkills.get(skillType).toString());
            TextField modifier = new TextField(Integer.toString(mod));
            TextField ranks = new TextField(value.toString());
            total.setMaxWidth(50);
            modifier.setMaxWidth(50);
            ranks.setMaxWidth(50);
            if (character.getClassSkills().contains(skillType)) {
                skillLabel.setText("*" + skillLabel.getText());
            }
            skillLine.getChildren().addAll(skillLabel, total, modifier, ranks);
            skills.getChildren().add(skillLine);
        });
    }

    private void setSaves() {
        Map<SaveType, Integer> baseSaves = character.getBaseSaves();
        Map<AbilityType, Integer> modifiers = character.getAbilityMods();
        baseSaves.forEach(((saveType, integer) -> {
            HBox saveLine = new HBox();;
            Label saveLabel = new Label(saveType.getName());
            saveLabel.setPrefWidth(50);
            TextField modifier = new TextField(Integer.toString(modifiers.get(saveType.getPrimStat())));
            TextField base = new TextField(baseSaves.get(saveType).toString());
            TextField total = new TextField(Integer.toString(baseSaves.get(saveType) + modifiers.get(saveType.getPrimStat())));
            total.setMaxWidth(50);
            modifier.setMaxWidth(50);
            base.setMaxWidth(50);
            saveLine.getChildren().addAll(saveLabel, total, base, modifier);
            saves.getChildren().add(saveLine);
        }));
    }

    private void setBaseAttack() {
        Label baseLabel = new Label("Base Attack Bonus: ");
        TextField base = new TextField();
        for(Iterator iterator = character.getBaseAttack().iterator(); iterator.hasNext();)
        {
            int value = (int) iterator.next();
            if (iterator.hasNext())
            {
                base.setText(base.getText() + Integer.toString(value) + "/");
            } else
            {
                base.setText(base.getText() + Integer.toString(value));
            }
        }
        baseAttack.getChildren().addAll(baseLabel, base);
    }

    private void setCombatManeuvers() {
        Map<AbilityType, Integer> modifiers = character.getAbilityMods();
        int baseA = character.getBestBaseAttack();
        int strMod = modifiers.get(AbilityType.STR);
        int dexMod = modifiers.get(AbilityType.DEX);
        int sizeMod = character.getSize().getCombatMod();

        Label cmbLabel = new Label("CMB");
        Label cmdLabel = new Label("CMD");
        TextField cmbBaseAttack = new TextField(Integer.toString(baseA));
        TextField cmbSTRMod = new TextField(Integer.toString(strMod));
        TextField cmbSize = new TextField(Integer.toString(sizeMod));
        TextField cmbTotal = new TextField(Integer.toString(sizeMod + strMod + baseA));
        TextField cmdBaseAttack = new TextField(Integer.toString(baseA));
        TextField cmdSTRMod = new TextField(Integer.toString(strMod));
        TextField cmdDEXMod = new TextField(Integer.toString(dexMod));
        TextField cmdSize = new TextField(Integer.toString(sizeMod));
        TextField cmdTotal = new TextField(Integer.toString(sizeMod+ dexMod + strMod + baseA + 10));
        HBox cmb = new HBox(cmbLabel, cmbTotal, cmbBaseAttack, cmbSTRMod, cmbSize);
        HBox cmd = new HBox(cmdLabel, cmdTotal, cmdBaseAttack, cmdSTRMod, cmdDEXMod, cmdSize);
        combatManeuvers.getChildren().addAll(cmb, cmd);
    }
}
