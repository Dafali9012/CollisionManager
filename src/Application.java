import shapes.Circle;
import shapes.Point;
import shapes.Shape;
import shapes.Square;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final Application instance = new Application();

    private Application() {
        List<Shape> generatedShapes = generateShapes(2, 2, 0);
        collisionCheck(generatedShapes);
    }

    private List<Shape> generateShapes(int numPoints, int numSquares, int numCircles) {
        List<Shape> generatedShapes = new ArrayList<>();
        int fieldSize = 5;
        for (int i = numPoints; i > 0; i--) {
            Point p = new Point(fieldSize);
            generatedShapes.add(p);
        }
        for (int i = numSquares; i > 0; i--) {
            Square s = new Square(fieldSize);
            generatedShapes.add(s);
        }
        for (int i = numCircles; i > 0; i--) {
            Circle c = new Circle(fieldSize);
            generatedShapes.add(c);
        }
        return generatedShapes;
    }

    private void collisionCheck(List<Shape> generatedShapes) {
        int index = 1;
        Shape testingShape = generatedShapes.get(index - 1);
        while (index < generatedShapes.size()) {
            for (int i = index; i < generatedShapes.size(); i++) {
                System.out.printf("testing \u001B[34m%s%s\u001B[0m against \u001B[34m%s%s\u001B[0m ", testingShape.getType(), testingShape.getInformation(), generatedShapes.get(i).getType(), generatedShapes.get(i).getInformation());
                if (CollisionManager.isColliding(testingShape, generatedShapes.get(i))) {
                    System.out.println("\u001B[31m*collision detected*\u001B[0m");
                } else {
                    System.out.println();
                }
            }
            index++;
            testingShape = generatedShapes.get(index - 1);
        }
    }

    public static Application getInstance() {
        return instance;
    }
}
