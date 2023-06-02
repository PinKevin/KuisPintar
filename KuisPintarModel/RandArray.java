package KuisPintarModel;

import java.util.Random;

class RandArray {
    private String[] operator = new String[]{"+", "-"};
    private Random rand = new Random();

    public String getRandArrayElement() {
        return operator[rand.nextInt(operator.length)];
    }
}
