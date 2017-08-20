package main.java.npc.fx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import main.java.fx.CharacterSheetController;
import main.java.npc.NPCCharacter;
import main.java.npc.utils.GoalUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class NPCSheetController extends CharacterSheetController implements Initializable {

    @FXML
    private Tab npcDetailsTab;

    @FXML
    private TabPane tabPane;

    @FXML
    private HBox goalInfo;

    private NPCCharacter character;
    public NPCSheetController(NPCCharacter character) {
        super(character);
        this.character = character;
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        tabPane.getTabs().add(npcDetailsTab);
        character.setGoal(GoalUtils.getRandomGoal(character.getAlignmentType()));
        setGoals();
    }

    private void setGoals() {
        Label goalLabel = new Label("Goal: ");
        TextField goal = new TextField(character.getGoal().name());
        goalInfo.getChildren().addAll(goalLabel, goal);
    }

}
