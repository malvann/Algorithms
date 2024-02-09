package devideAndConquer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
class ClosestPointsAlgorithm {
    private List<Point> points;

    public double solve() {
        List<Point> sortedXPoints = new ArrayList<>(points);
        sortedXPoints.sort(Comparator.comparing(Point::getX));
        List<Point> sortedYPoints = new ArrayList<>(points);
        sortedYPoints.sort(Comparator.comparing(Point::getY));

        return findClosesPoints(sortedXPoints, sortedYPoints, sortedXPoints.size());
    }

    private double findClosesPoints(List<Point> sortedXPoints, List<Point> sortedYPoints, int numOfPoints) {
        if (numOfPoints <= 3) return bruteForceSearch(sortedXPoints);

        int midIndex = numOfPoints / 2;
        Point midPoint = sortedXPoints.get(midIndex);
        List<Point> leftSubArrSortedX = sortedXPoints.subList(0, midIndex);
        List<Point> rightSubArrSortedX = sortedXPoints.subList(midIndex, sortedXPoints.size());
        double deltaLeft = findClosesPoints(leftSubArrSortedX, sortedYPoints, midIndex);
        double deltaRight = findClosesPoints(rightSubArrSortedX, sortedYPoints, numOfPoints - midIndex);
        double delta = Math.min(deltaLeft, deltaRight);

        List<Point> pointInStrip = new ArrayList<>();
        IntStream.range(0, numOfPoints).forEach(i -> {
            if (Math.abs(sortedYPoints.get(i).getX() - midPoint.getX()) < delta)
                pointInStrip.add(sortedYPoints.get(i));
        });
        double minDistanceInStrip = findMinDistanceInStrip(pointInStrip, delta);
        return Math.min(delta, minDistanceInStrip);
    }

    private double bruteForceSearch(List<Point> points) {
        double minDistance = Double.MAX_VALUE;
        for (int i = 1; i < points.size(); i++) {
            double distance = distance(points.get(i - 1), points.get(i));
            minDistance = Math.min(minDistance, distance);
        }
        return minDistance;
    }

    private double findMinDistanceInStrip(List<Point> points, double delta) {
        double minDistance = delta;
        for (int i = 1; i < points.size() && (points.get(i).getY() - points.get(i - 1).getY()) < minDistance; i++) {
            minDistance = distance(points.get(i), points.get(i - 1));
        }
        return minDistance;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(
                Math.pow((p1.getX() - p2.getX()), 2)
                        + Math.pow((p1.getY() - p2.getY()), 2));
    }

    public static void main(String[] args) {
        List<Point> points = List.of(
                new Point(2.5,3),
                new Point(3,3),
                new Point(1,1),
                new Point(1,2),
                new Point(2,1),
                new Point(2,2));
        System.out.println( new ClosestPointsAlgorithm(points).solve());
    }
}

@AllArgsConstructor
@ToString
@Getter
public class Point {
    private double x;
    private double y;
}
