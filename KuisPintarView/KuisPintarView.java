package KuisPintarView;
import KuisPintarModel.*;
import KuisPintarController.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KuisPintarView {
    private Label equationLabel;
    private TextField answerField;
    private Button submitButton;
    private Label resultLabel;
    private KuisPintarController controller;
    private int totalScore;
    private int questionCount;

    public KuisPintarView(Stage primaryStage, KuisPintarController controller) {
        this.controller = controller;

        equationLabel = new Label();
        updateEquationLabel();

        answerField = new TextField();
        answerField.setOnKeyPressed( event -> {
            if (event.getCode() == KeyCode.ENTER) {
                controller.checkAnswer();
            }
        } );
        submitButton = new Button("Submit");
        submitButton.setOnAction(e -> controller.checkAnswer());

        resultLabel = new Label();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(equationLabel, 0, 0);
        gridPane.add(answerField, 0, 1);
        gridPane.add(submitButton, 1, 1);
        gridPane.add(resultLabel, 0, 2);

        VBox root = new VBox(gridPane);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Kuis Pintar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String getUserAnswer() {
        return answerField.getText();
    }

    public void clearAnswerField() {
        answerField.clear();
    }

    public void updateEquationLabel() {
        KuisPintarModel model = controller.getModel();
        equationLabel.setText(model.getFirstNumber() + " " + model.getCurrentOperator() + " " + model.getSecondNumber());
    }

    public void showResultMessage(boolean isCorrect) {
        if (isCorrect) {
            resultLabel.setText("Benar");
            totalScore += 20;
        } else {
            resultLabel.setText("Salah");
        }

        questionCount++;

        if (questionCount >= 5) {
            resultLabel.setText( "Nilai Akhir : " + totalScore );
            answerField.setEditable( false );
            submitButton.setDisable( true );
        } else {
            controller.generateNewEquation();
        }
    }
}
