package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.util.HashMap;

public class SliderController {

    @FXML
    private HashMap<String, Integer> slider = new HashMap<>();
    @FXML
    private Slider slider_mental_demand;
    @FXML
    private Slider slider_physical_demand;
    @FXML
    private Slider slider_temporal_demand;
    @FXML
    private Slider slider_performance;
    @FXML
    private Slider slider_effort;
    @FXML
    private Slider slider_frustration;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        slider.put("MD", ((int) slider_mental_demand.getValue()));
        slider.put("PD", ((int) slider_physical_demand.getValue()));
        slider.put("TD", ((int) slider_temporal_demand.getValue()));
        slider.put("OP", ((int) slider_performance.getValue()));
        slider.put("EF", ((int) slider_effort.getValue()));
        slider.put("FR", ((int) slider_frustration.getValue()));
        Data.getInstance().ratings = slider;
        Node source = (Node) event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
