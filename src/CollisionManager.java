import shapes.Circle;
import shapes.Point;
import shapes.Shape;
import shapes.Square;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private static final CollisionManager instance = new CollisionManager();

    private CollisionManager() {
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
                if ((testingShape instanceof Circle || testingShape instanceof Point) && (generatedShapes.get(i) instanceof Circle || generatedShapes.get(i) instanceof Point)) { // circle and point checks
                    float distance = (float) Math.sqrt(Math.pow(testingShape.getPosition()[0] - generatedShapes.get(i).getPosition()[0], 2) + Math.pow(testingShape.getPosition()[1] - generatedShapes.get(i).getPosition()[1], 2));
                    if (distance <= testingShape.getRadius() + generatedShapes.get(i).getRadius()) {
                        System.out.println("\u001B[31m*collision detected*\u001B[0m");
                    } else System.out.println();
                } else if ((testingShape instanceof Square || testingShape instanceof Point) && (generatedShapes.get(i) instanceof Square || generatedShapes.get(i) instanceof Point)) { // square and point checks
                    if (!(testingShape.getPosition()[0] - testingShape.getRadius() > generatedShapes.get(i).getPosition()[0] + generatedShapes.get(i).getRadius() ||
                            testingShape.getPosition()[0] + testingShape.getRadius() < generatedShapes.get(i).getPosition()[0] - generatedShapes.get(i).getRadius() ||
                            testingShape.getPosition()[1] - testingShape.getRadius() > generatedShapes.get(i).getPosition()[1] + generatedShapes.get(i).getRadius() ||
                            testingShape.getPosition()[1] + testingShape.getRadius() < generatedShapes.get(i).getPosition()[1] - generatedShapes.get(i).getRadius())) {
                        System.out.println("\u001B[31m*collision detected*\u001B[0m");
                    } else System.out.println();
                } else if((testingShape instanceof Square && generatedShapes.get(i) instanceof Circle) || (testingShape instanceof Circle && generatedShapes.get(i) instanceof Square)) { // circle against square check
                    Shape objectOne = testingShape;
                    Shape objectTwo = generatedShapes.get(i);
                    if(testingShape instanceof Square) {
                        objectOne = generatedShapes.get(i);
                        objectTwo = testingShape;
                    }
                    if(objectOne.getPosition()[0] + objectOne.getRadius() < objectTwo.getPosition()[0] - objectTwo.getRadius() &&
                    objectOne.getPosition()[1] - objectOne.getRadius() > objectTwo.getPosition()[1] + objectTwo.getRadius()) { // circle in top left
                        
                    }
                } else System.out.println();
            }
            index++;
            testingShape = generatedShapes.get(index - 1);
        }
    }

    public static CollisionManager getInstance() {
        return instance;
    }
}
