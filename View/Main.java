package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("This program simulates a TLX test. Was your task physically demanding?\nDid you run into a lot of frustration? Here you can tell us!");
        alert.setContentText("The following interface will let you compare load factors pairwise.\nPlease click the one that you found more demanding.");
        Stage alertStage = (Stage)alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        alert.showAndWait();

        Stage comparisonStage = new Stage();
        Parent comparisonScreen = FXMLLoader.load(getClass().getResource("ComparisonScreen.fxml"));
        comparisonStage.setScene(new Scene(comparisonScreen));
        comparisonStage.setResizable(false);
        comparisonStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        comparisonStage.showAndWait();

        Stage sliderStage = new Stage();
        Parent sliderScreen = FXMLLoader.load(getClass().getResource("SliderScreen.fxml"));
        sliderStage.setScene(new Scene(sliderScreen));
        sliderStage.setResizable(false);
        sliderStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        sliderStage.showAndWait();

        Stage resultStage = new Stage();
        Parent resultScreen = FXMLLoader.load(getClass().getResource("ResultScreen.fxml"));
        resultStage.setScene(new Scene(resultScreen));
        resultStage.setResizable(false);
        resultStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        resultStage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
