package KuisPintarModel;

import java.util.Random;

public class KuisPintarModel IKuisPintarModel{
    private int minNumber = 1;
    private int maxNumber = 20;
    private int firstNumber;
    private int secondNumber;
    private String currentOperator;
    private int answerNumber;

    public void generateEquation() {
        Random random = new Random();
        firstNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        secondNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        currentOperator = new RandArray().getRandArrayElement();

        if (currentOperator.equals("+")) {
            answerNumber = firstNumber + secondNumber;
        } else if (currentOperator.equals("-")) {
            answerNumber = firstNumber - secondNumber;
        }
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public String getCurrentOperator() {
        return currentOperator;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }
}
