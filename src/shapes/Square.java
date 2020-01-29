package shapes;

public class Square extends Shape {

    private float[][] cornerPositions = new float[4][2]; // top-left, clockwise

    public Square(int bound) {
        randomProperties(bound);
    }

    public Square(int x, int y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    private void setCornerPositions() {
        cornerPositions[0] = new Float[] {x, y};
        cornerPositions[1] = new Float[] {x + radius, y - radius};
        cornerPositions[2] = new Float[] {x, y + radius};
    }
}
