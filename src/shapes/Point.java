package shapes;

public class Point extends Shape {

    public Point(int bound) {
        randomProperties(bound);
        radius = 0;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        radius = 0;
    }
}
