package shapes;

public class Point extends Shape {

    public Point(int bound) {
        randomProperties(bound);
        radius = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        radius = 0;
    }
}
