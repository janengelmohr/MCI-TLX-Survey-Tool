package Controller;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class ComparisonController {

    @FXML
    private HashMap<String, Pair<String, String>> tlx = new HashMap<>();
    @FXML
    private ArrayList<Pair<String, String>> steps = new ArrayList<>();
    @FXML
    private HashMap<String, Integer> comparison = new HashMap<>();
    @FXML
    private int step = 0;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private Label leftLabel;
    @FXML
    private Label rightLabel;

    @FXML
    private void handleLeftButtonAction(ActionEvent event) {
        comparison.put(steps.get(step).getKey(), comparison.get(steps.get(step).getKey()) + 1);
        step++;
        nextStep(event);
    }

    @FXML
    private void handleRightButtonAction(ActionEvent event) {
        comparison.put(steps.get(step).getValue(), comparison.get(steps.get(step).getValue()) + 1);
        step++;
        nextStep(event);
    }

    @FXML
    private void nextStep(ActionEvent event) {
        if(step == steps.size()) {
            nextScreen(event);
        } else {
            leftButton.setText(tlx.get(steps.get(step).getKey()).getKey());
            leftLabel.setText(tlx.get(steps.get(step).getKey()).getValue());
            rightButton.setText(tlx.get(steps.get(step).getValue()).getKey());
            rightLabel.setText(tlx.get(steps.get(step).getValue()).getValue());
        }
    }

    @FXML
    private void nextScreen(ActionEvent event) {
        Data.getInstance().weights = comparison;
        Node source = (Node) event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        comparison.put("MD", 0);
        comparison.put("PD", 0);
        comparison.put("TD", 0);
        comparison.put("OP", 0);
        comparison.put("EF", 0);
        comparison.put("FR", 0);

        tlx.put("MD", new Pair<>("Mental Demand", "How mentally demanding was the task?"));
        tlx.put("PD", new Pair<>("Physical Demand","How physically demanding was the task?"));
        tlx.put("TD", new Pair<>("Temporal Demand", "How hurried or rushed was the pace of the task?"));
        tlx.put("OP", new Pair<>("Performance", "How successful were you in accomplishing what you were asked to do?"));
        tlx.put("EF", new Pair<>("Effort", "How hard did you have to work to accomplish your level of performance?"));
        tlx.put("FR", new Pair<>("Frustration", "How insecure, discouraged, irritated, stressed, and annoyed were you?"));

        steps.add(new Pair<>("PD", "MD"));
        steps.add(new Pair<>("TD", "MD"));
        steps.add(new Pair<>("OP", "MD"));
        steps.add(new Pair<>("FR", "MD"));
        steps.add(new Pair<>("EF", "MD"));
        steps.add(new Pair<>("TD", "PD"));
        steps.add(new Pair<>("OP", "PD"));
        steps.add(new Pair<>("FR", "PD"));
        steps.add(new Pair<>("EF", "PD"));
        steps.add(new Pair<>("TD", "OP"));
        steps.add(new Pair<>("TD", "FR"));
        steps.add(new Pair<>("TD", "EF"));
        steps.add(new Pair<>("OP", "FR"));
        steps.add(new Pair<>("OP", "EF"));
        steps.add(new Pair<>("EF", "FR"));

        nextStep(null);
    }
}
