package shapes;

import interfaces.HasInformation;

import java.security.SecureRandom;

public abstract class Shape implements HasInformation {

    protected int x,y;
    protected float radius;

    protected void randomProperties(int bound) {
        SecureRandom sr = new SecureRandom();
        x = sr.nextInt(bound + 1);
        y = sr.nextInt(bound + 1);
        radius = sr.nextFloat()*bound/4;
    }

    public int[] getPosition() {
        return new int[]{x,y};
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public String getInformation() {
        return "(x:"+x+" y:"+y+" radius:"+radius+")";
    }

    @Override
    public String getType() {
        return this.getClass().toString().split(" ")[1].substring(7);
    }
}
