import java.util.Random;

public abstract class Shape {
    protected int x,y;

    protected void randomPosition(int bound) {
        x = new Random().nextInt(bound+1);
        y = new Random().nextInt(bound+1);
    }

    public void printInformation() {

    }
}
