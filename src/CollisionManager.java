import shapes.Circle;
import shapes.Point;
import shapes.Shape;
import shapes.Square;

import java.util.Arrays;

public abstract class CollisionManager {

    public static boolean isColliding(Shape s1, Shape s2) {
        boolean isColliding = false;

        if (s1 instanceof Point) {
            if (s2 instanceof Point) {
                isColliding = calculatePointCollision(s1, s2);
            } else if (s2 instanceof Circle) {
                isColliding = calculateCircleCollision(s1, s2);
            } else if (s2 instanceof Square) {
                isColliding = calculateBoxCollision(s1, s2);
            }
        } else if (s1 instanceof Circle) {
            if (s2 instanceof Point) {
                isColliding = calculateCircleCollision(s1, s2);
            } else if (s2 instanceof Circle) {
                isColliding = calculateCircleCollision(s1, s2);
            } else if (s2 instanceof Square) {

            }
        } else if (s1 instanceof Square) {
            if (s2 instanceof Point) {
                isColliding = calculateBoxCollision(s1, s2);
            } else if (s2 instanceof Circle) {

            } else if (s2 instanceof Square) {
                isColliding = calculateBoxCollision(s1, s2);
            }
        }
        return isColliding;
    }

    private static boolean calculatePointCollision(Shape s1, Shape s2) {
        return Arrays.equals(s1.getPosition(), s2.getPosition());
    }

    private static boolean calculateBoxCollision(Shape s1, Shape s2) {
        boolean isColliding = false;
        if (!(s1.getX() + s1.getRadius() < s2.getX() - s2.getRadius() ||
                s1.getX() - s1.getRadius() > s2.getX() + s2.getRadius() ||
                s1.getY() + s1.getRadius() < s2.getY() - s2.getRadius() ||
                s1.getY() - s1.getRadius() > s2.getY() + s2.getRadius())) {
            isColliding = true;
        }
        return isColliding;
    }

    private static boolean calculateCircleCollision(Shape s1, Shape s2) {
        boolean isColliding = false;
        float distance = (float)Math.sqrt((Math.pow(s1.getX() - s2.getX(), 2)+Math.pow(s1.getY()-s2.getY(), 2)));
        if(distance < s1.getRadius() + s2.getRadius()) {
            isColliding = true;
        }
        return isColliding;
    }
}
