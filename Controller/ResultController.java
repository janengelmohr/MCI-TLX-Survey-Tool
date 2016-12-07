package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ResultController {

    @FXML
    private Label label_md_rating;

    @FXML
    private Label label_pd_rating;

    @FXML
    private Label label_td_rating;

    @FXML
    private Label label_op_rating;

    @FXML
    private Label label_ef_rating;

    @FXML
    private Label label_fr_rating;

    @FXML
    private Label label_md_weight;

    @FXML
    private Label label_pd_weight;

    @FXML
    private Label label_td_weight;

    @FXML
    private Label label_op_weight;

    @FXML
    private Label label_ef_weight;

    @FXML
    private Label label_fr_weight;

    @FXML
    private Label label_md_product;

    @FXML
    private Label label_pd_product;

    @FXML
    private Label label_td_product;

    @FXML
    private Label label_op_product;

    @FXML
    private Label label_ef_product;

    @FXML
    private Label label_fr_product;

    @FXML
    private Label label_sum;

    @FXML
    private Label label_average;

    @FXML
    public void initialize() {
        Data data = Data.getInstance();
        data.products.put("MD", data.ratings.get("MD") * data.weights.get("MD"));
        data.products.put("PD", data.ratings.get("PD") * data.weights.get("PD"));
        data.products.put("TD", data.ratings.get("TD") * data.weights.get("TD"));
        data.products.put("OP", data.ratings.get("OP") * data.weights.get("OP"));
        data.products.put("FR", data.ratings.get("FR") * data.weights.get("FR"));
        data.products.put("EF", data.ratings.get("EF") * data.weights.get("EF"));

        label_md_rating.setText(data.ratings.get("MD").toString());
        label_md_weight.setText(data.weights.get("MD").toString());
        label_md_product.setText(data.products.get("MD").toString());
        label_pd_rating.setText(data.ratings.get("PD").toString());
        label_pd_weight.setText(data.weights.get("PD").toString());
        label_pd_product.setText(data.products.get("PD").toString());
        label_td_rating.setText(data.ratings.get("TD").toString());
        label_td_weight.setText(data.weights.get("TD").toString());
        label_td_product.setText(data.products.get("TD").toString());
        label_op_rating.setText(data.ratings.get("OP").toString());
        label_op_weight.setText(data.weights.get("OP").toString());
        label_op_product.setText(data.products.get("OP").toString());
        label_fr_rating.setText(data.ratings.get("FR").toString());
        label_fr_weight.setText(data.weights.get("FR").toString());
        label_fr_product.setText(data.products.get("FR").toString());
        label_ef_rating.setText(data.ratings.get("EF").toString());
        label_ef_weight.setText(data.weights.get("EF").toString());
        label_ef_product.setText(data.products.get("EF").toString());

        Integer sum = data.products.get("MD") + data.products.get("TD") + data.products.get("PD")
                    + data.products.get("OP") + data.products.get("FR") + data.products.get("EF");
        Integer average = (int)Math.round(sum / 15.0);
        label_sum.setText(sum.toString());
        label_average.setText(average.toString());
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
