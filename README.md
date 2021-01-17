So Shivam had just learned about OOP. He had written a program before that did two things,
- Find distance between two points
- Find direction (angle) between two points in Radians.

He has this code in the `org.procedural.DistanceAndDirectionCalculator` It looks like this for the reference - 

```java
public class DistanceAndDirectionCalculator {
    public static double distance(double x1, double y1, double x2, double y2) {
        double xDistance = x1 - x2;
        double yDistance = y1 - y2;
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public static double direction(double x1, double y1, double x2, double y2) {
        double xDistance = x2 - x1;
        double yDistance = y2 - y1;
        return Math.atan2(yDistance, xDistance);
    }
}
```
He thought it'll be a good idea to convert this to Object Oriented Programming. So he wrote a new implementation in package `org.oop`, he got 2 classes - 
- `org.oop.DistanceAndDirectionCalculator`
- `org.oop.Point`

However, his trainer told him that what he did is not Object Oriented programming and asked Shivam to try again. 
- Try to articulate problems with Shivam's OOP solution. (Write it somewhere and share it with your trainer)
- Fork the project and fix the design related problem with Shivam's OOP solution. Share that with your trainer too.

Problems in Shivam's Implementation
- AAA format not followed in Test class
- Setters in Point class not used
- No encapsulation in DistanceAndDirectionCalculator as the methods are static
- DistanceAndDirectionCalculator is like having procedural code wrapped up in a class
- It does not follow the 4 rules of simple design
  - Passes the tests (It Works)
  - Reveals intention - DistanceAndDirectionCalculator class does not reveal intention clearly
  - No duplication - has duplication of code while calculating difference between X and y co-ordinates of the 2 points. the logic could be extracted in a private method and reused.
  - Fewest elements - Unnecessary use of DistanceAndDirectionCalculator class, Point class was sufficient for satisfying the purpose of the problem
  - AssertThat could be more useful in Test class



My Implementation
- Changes in Point class
  - Removed getters and setters
  - Added 2 private methods for calculating X and Y difference between the co-ordinates of instance point and parameter point i.e. `calculateDiffInXWRT(Point p)` and `calculateDiffInYWRT(Point p)` resp.
  - Added 2 public methods `distanceFrom(Point p)` and `directionWRT(Point p)` to be tested upon which look like this.
  ```java
  public double distanceFrom(Point p) {
        return Math.sqrt(Math.pow(calculateDiffInXWRT(p), 2) + Math.pow(calculateDiffInYWRT(p), 2));
    }
    public double directionWRT(Point p) {
        return Math.atan2(calculateDiffInYWRT(p), calculateDiffInXWRT(p));
    }
    ```
- There is no need of `org.oop.DistanceAndDirectionCalculator` class as now, it will only be used for calling the methods of Point class. Hence, **removed**
- Deleted `org.oop.DistanceAndDirectionCalculatorTest`
- Added a new class `org.oops.PointTest` where distance and direction would be calculated as follows
  ```java
  origin.distanceFrom(point1)
  origin.directionWRT(point1)
  ```
