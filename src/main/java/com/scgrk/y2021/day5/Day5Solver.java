package com.scgrk.y2021.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5Solver {

  public long solve(String input, int part) {

    List<LineSegment> lineSegments = Arrays.stream(input.split("\n"))
        .map(line -> {
          var points = line.split("->");
          var point1 = new Point(points[0].split(","));
          var point2 = new Point(points[1].split(","));
          return new LineSegment(point1, point2);
        })
        .collect(Collectors.toList());

    if (part == 1) {
      return solvePart1(lineSegments.stream()
                            .filter(lineSegment -> lineSegment.isHorizontal() || lineSegment.isVertical())
                            .collect(Collectors.toList()));
    } else {
      return solvePart1(lineSegments);
    }
  }

  public long solvePart1(List<LineSegment> lineSegments) {
    return lineSegments.stream()
        .flatMap(lineSegment -> lineSegment.getAllPointsOnLine().stream())
        .collect(Collectors.toMap(point -> point, point -> 1, Integer::sum))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > 1)
        .count();
  }

}
