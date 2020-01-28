package shapes;

public class Square extends Shape {

    public Square(int bound) {
        randomProperties(bound);
    }

    public Square(int x, int y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
