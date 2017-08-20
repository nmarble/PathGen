package main.java.npc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.Character;
import main.java.CharacterSheetController;
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

public class NPCSheetController extends CharacterSheetController implements Initializable {

    @FXML
    private Tab npcDetailsTab;

    @FXML
    private TabPane tabPane;

    private Character character;
    public NPCSheetController(Character character) {
        super(character);
        this.character = character;
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        tabPane.getTabs().add(npcDetailsTab);
    }

}
