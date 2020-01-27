public class Point extends Shape {

    public Point(int bound) {
        randomPosition(bound);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void printInformation() {
        System.out.println("x:"+x+" y:"+y);
    }
}
