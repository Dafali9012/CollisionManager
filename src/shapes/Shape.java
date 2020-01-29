package shapes;

import java.security.SecureRandom;

public abstract class Shape {

    protected float x, y;
    protected float radius;

    protected void randomProperties(int bound) {
        SecureRandom sr = new SecureRandom();
        x = sr.nextInt(bound + 1);
        y = sr.nextInt(bound + 1);
        radius = sr.nextFloat() * bound / 3;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float[] getPosition() {
        return new float[]{x, y};
    }

    public float getRadius() {
        return radius;
    }

    public String getInformation() {
        return "(x:" + x + " y:" + y + " radius:" + radius + ")";
    }

    public String getType() {
        return this.getClass().toString().split(" ")[1].substring(7);
    }
}
