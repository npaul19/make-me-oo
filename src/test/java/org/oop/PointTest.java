package org.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    void twoPointsWithSameXAndYCoordinatesShouldHaveADistanceOfZero() {
        Point origin = new Point(0, 0);

        double actualDistance = origin.distanceFrom(origin);

        Assertions.assertEquals(0, actualDistance);
    }

    @Test
    void distanceBetweenOriginAndPointsOnUnitCircleShouldBeOne() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(1, 0);
        Point point2 = new Point(0, 1);

        Assertions.assertEquals(1, origin.distanceFrom(point1));
        Assertions.assertEquals(1, origin.distanceFrom(point2));
    }

    @Test
    void distanceBetweenTwoOppositePointsOnUnitCircleShouldBeTwo() {
        Point point1 = new Point(1, 0);
        Point point2 = new Point(-1, 0);

        Assertions.assertEquals(2, point1.distanceFrom(point2));
    }

    @Test
    void originAndPointOnPositiveXAxisShouldBeZeroRadiansAway() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(1, 0);
        Point point2 = new Point(3, 0);

        Assertions.assertEquals(0, origin.directionWRT(point1));
        Assertions.assertEquals(0, origin.directionWRT(point2));
    }

    @Test
    void originAndPointOnNegativeXAxisShouldBePiRadiansAway() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(-1, 0);
        Point point2 = new Point(-3, 0);

        Assertions.assertEquals(Math.PI, origin.directionWRT(point1));
        Assertions.assertEquals(Math.PI, origin.directionWRT(point2));
    }

    @Test
    void originAndPointOnYAxisShouldBeHalfPiRadiansAway() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(0, 1);
        Point point2 = new Point(0, 3);

        Assertions.assertEquals(Math.PI / 2, origin.directionWRT(point2));
        Assertions.assertEquals(Math.PI / 2, origin.directionWRT(point1));
    }

}
