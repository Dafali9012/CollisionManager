import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private static final CollisionManager instance = new CollisionManager();
    private int fieldSize = 10;
    private List<Shape> generatedShapes;

    private CollisionManager() {
        generatedShapes = generateShapes(2,0,0);
        collisionCheck(generatedShapes);
    }

    private List<Shape> generateShapes(int numPoints, int numSquares, int numCircles) {
        List<Shape> generatedShapes = new ArrayList<>();
        for(int i = numPoints; i > 0; i--) {
            Point p = new Point(fieldSize);
            generatedShapes.add(p);
        }
        for(int i = numSquares; i > 0; i--) {
            Square s = new Square(fieldSize);
            generatedShapes.add(s);
        }
        for(int i = numCircles; i > 0; i--) {
            Circle c = new Circle(fieldSize);
            generatedShapes.add(c);
        }

        return generatedShapes;
    }

    private void collisionCheck(List<Shape> generatedShapes) { // loop everything through everything else and check for collisions.
        int index = generatedShapes.size()-1;
        Shape checkingShape = generatedShapes.get(index);
        while (index >= 0) {
            for(int i = index; index >= 0; i--) {

            }
            index--;
            checkingShape = generatedShapes.get(index);
        }
    }

    public static CollisionManager getInstance() {
        return instance;
    }
}
