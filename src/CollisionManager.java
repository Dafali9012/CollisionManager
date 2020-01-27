import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private static final CollisionManager instance = new CollisionManager();
    private int fieldSize = 10;

    private CollisionManager() {
        generateShapes(2,0,0);
        collisionCheck();
    }

    private List<Shape> generateShapes(int numPoints, int numSquares, int numCircles) {
        for(int i = numPoints; i > 0; i--) {
            new Point(fieldSize).printInformation();
        }
        for(int i = numSquares; i > 0; i--) {
            new Square(fieldSize).printInformation();
        }
        for(int i = numCircles; i > 0; i--) {
            new Circle(fieldSize).printInformation();
        }

        return new ArrayList<>();
    }

    private void collisionCheck() {

    }

    public static CollisionManager getInstance() {
        return instance;
    }
}
