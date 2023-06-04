package KuisPintarView;

public interface IKuisPintarView {
    String getUserAnswer();

    void clearAnswerField();

    void updateEquationLabel();

    void showResultMessage(boolean isCorrect);
}