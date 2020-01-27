import java.security.SecureRandom;

public abstract class Shape {
    protected int x,y;

    protected void randomPosition(int bound) {
        x = new SecureRandom().nextInt(bound+1);
        y = new SecureRandom().nextInt(bound+1);
    }

    public void printInformation() {

    }
}
