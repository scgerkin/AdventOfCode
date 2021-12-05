package com.scgrk.y2021.day5;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import lombok.Data;

@Data
public class LineSegment {

  private final Point start;
  private final Point end;

  public LineSegment(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  public boolean isHorizontal() {
    return start.getY() == end.getY();
  }

  public boolean isVertical() {
    return start.getX() == end.getX();
  }

  public Set<Point> getAllPointsOnLine() {
    if (isHorizontal()) {
      return getAllPointsOnHorizontalLine();
    } else if (isVertical()) {
      return getAllPointsOnVerticalLine();
    } else {
      return getAllPointsOnDiagonalLine();
    }
  }

  private Set<Point> getAllPointsOnHorizontalLine() {
    return IntStream.rangeClosed(Math.min(start.getX(), end.getX()), Math.max(start.getX(), end.getX()))
        .mapToObj(i -> new Point(i, start.getY()))
        .collect(java.util.stream.Collectors.toSet());
  }

  private Set<Point> getAllPointsOnVerticalLine() {
    return IntStream.rangeClosed(Math.min(start.getY(), end.getY()), Math.max(start.getY(), end.getY()))
        .mapToObj(i -> new Point(start.getX(), i))
        .collect(java.util.stream.Collectors.toSet());
  }

  private Set<Point> getAllPointsOnDiagonalLine() {
    int startX = Math.min(start.getX(), end.getX());
    int endX = Math.max(start.getX(), end.getX());
    Point startPoint = start.getX() == startX ? start : end;
    Point endPoint = start.getX() == startX ? end : start;

    var points = new HashSet<Point>();

    for (int i = 0; i <= endX - startX; i++) {
      if (startPoint.getY() > endPoint.getY()) {
        points.add(new Point(startX + i, startPoint.getY() - i));
      } else {
        points.add(new Point(startX + i, startPoint.getY() + i));
      }
    }

    return points;
  }
}
