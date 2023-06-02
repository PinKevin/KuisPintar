package KuisPintarController;
import KuisPintarModel.*;
import KuisPintarView.*;
import javafx.stage.Stage;

public class KuisPintarController {
    private KuisPintarModel model;
    private KuisPintarView view;

    public KuisPintarController() {
        model = new KuisPintarModel();
        view = new KuisPintarView(new Stage(), this);
        generateNewEquation();
    }

    public KuisPintarModel getModel() {
        return model;
    }

    public void generateNewEquation() {
        model.generateEquation();
        view.updateEquationLabel();
    }

    public void checkAnswer() {
        int userAnswer = Integer.parseInt(view.getUserAnswer());
        int correctAnswer = model.getAnswerNumber();

        boolean isCorrect = (userAnswer == correctAnswer);
        view.showResultMessage( isCorrect );

        view.clearAnswerField();
    }
}
