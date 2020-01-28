package shapes;

public class Circle extends Shape {

    public Circle(int bound) {
        randomProperties(bound);
    }

    public Circle(int x, int y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

}
