package com.scgrk.y2021.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

// there are a lot of unit tests because I'm an idiot.
// nts: Don't trust copilot.
class LineSegmentTest {

  @Test
  void test_constructor() {
    LineSegment line = new LineSegment(new Point(0, 0), new Point(1, 1));
    assertEquals(new Point(0, 0), line.getStart());
    assertEquals(new Point(1, 1), line.getEnd());
  }

  @Test
  void test_getAllPointsOnLine_GivenHorizontalLineReturnsExpectedPoints() {
    LineSegment line = new LineSegment(new Point(0, 0), new Point(5, 0));
    var expected = Set.of(new Point(0, 0),
                          new Point(1, 0),
                          new Point(2, 0),
                          new Point(3, 0),
                          new Point(4, 0),
                          new Point(5, 0));

    assertEquals(expected, line.getAllPointsOnLine());

  }

  @Test
  void test_getAllPointsOnLine_GivenHorizontalWhereEndIsLargerThanStartReturnsExpectedPoints() {
    LineSegment line = new LineSegment(new Point(5, 0), new Point(0, 0));
    var expected = Set.of(new Point(0, 0),
                          new Point(1, 0),
                          new Point(2, 0),
                          new Point(3, 0),
                          new Point(4, 0),
                          new Point(5, 0));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenVerticalLineReturnsExpectedPoints() {
    LineSegment line = new LineSegment(new Point(0, 0), new Point(0, 5));
    var expected = Set.of(new Point(0, 0),
                          new Point(0, 1),
                          new Point(0, 2),
                          new Point(0, 3),
                          new Point(0, 4),
                          new Point(0, 5));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenVerticalWhereEndIsLargerThanStartReturnsExpectedPoints() {
    LineSegment line = new LineSegment(new Point(0, 5), new Point(0, 0));
    var expected = Set.of(new Point(0, 0),
                          new Point(0, 1),
                          new Point(0, 2),
                          new Point(0, 3),
                          new Point(0, 4),
                          new Point(0, 5));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenDiagonalLineReturnsExpectedPoints() {
    LineSegment line = new LineSegment(new Point(0, 0), new Point(5, 5));
    var expected = Set.of(new Point(0, 0),
                          new Point(1, 1),
                          new Point(2, 2),
                          new Point(3, 3),
                          new Point(4, 4),
                          new Point(5, 5));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenDiagonalLineWhereEndIsLargerThanStartReturnsExpectedPoints() {
    LineSegment line = new LineSegment(new Point(5, 5), new Point(0, 0));
    var expected = Set.of(new Point(0, 0),
                          new Point(1, 1),
                          new Point(2, 2),
                          new Point(3, 3),
                          new Point(4, 4),
                          new Point(5, 5));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenDiagonalLineWithOffsetReturnsExpectedPoints() {
    LineSegment lineSegment = new LineSegment(new Point(0, 8), new Point(3, 5));
    var expected = Set.of(new Point(0, 8),
                          new Point(1, 7),
                          new Point(2, 6),
                          new Point(3, 5));
    assertEquals(expected, lineSegment.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenDiagonalLineWithOffsetWhereEndIsLargerThanStartReturnsExpectedPoints() {
    LineSegment lineSegment = new LineSegment(new Point(3, 5), new Point(0, 8));
    var expected = Set.of(new Point(0, 8),
                          new Point(1, 7),
                          new Point(2, 6),
                          new Point(3, 5));
    assertEquals(expected, lineSegment.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult1() {
    LineSegment line = new LineSegment(new Point(0, 9), new Point(5, 9));
    var expected = Set.of(new Point(0, 9),
                          new Point(1, 9),
                          new Point(2, 9),
                          new Point(3, 9),
                          new Point(4, 9),
                          new Point(5, 9));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult2() {
    LineSegment line = new LineSegment(new Point(8, 0), new Point(0, 8));
    var expected = Set.of(new Point(8, 0),
                          new Point(7, 1),
                          new Point(6, 2),
                          new Point(5, 3),
                          new Point(4, 4),
                          new Point(3, 5),
                          new Point(2, 6),
                          new Point(1, 7),
                          new Point(0, 8));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult3() {
    LineSegment line = new LineSegment(new Point(9, 4), new Point(3, 4));
    var expected = Set.of(new Point(9, 4),
                          new Point(8, 4),
                          new Point(7, 4),
                          new Point(6, 4),
                          new Point(5, 4),
                          new Point(4, 4),
                          new Point(3, 4));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult4() {
    LineSegment line = new LineSegment(new Point(2, 2), new Point(2, 1));
    var expected = Set.of(new Point(2, 2),
                          new Point(2, 1));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult5() {
    LineSegment line = new LineSegment(new Point(7, 0), new Point(7, 4));
    var expected = Set.of(new Point(7, 0),
                          new Point(7, 1),
                          new Point(7, 2),
                          new Point(7, 3),
                          new Point(7, 4));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult6() {
    LineSegment line = new LineSegment(new Point(6, 4), new Point(2, 0));
    var expected = Set.of(new Point(6, 4),
                          new Point(5, 3),
                          new Point(4, 2),
                          new Point(3, 1),
                          new Point(2, 0));
    assertEquals(new ArrayList<>(expected).stream()
                     .sorted(Comparator.comparingInt(Point::getX))
                     .collect(Collectors.toList()),
                 new ArrayList<>(line.getAllPointsOnLine()).stream()
                     .sorted(Comparator.comparingInt(Point::getX))
                     .collect(Collectors.toList()));
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult7() {
    LineSegment line = new LineSegment(new Point(0, 9), new Point(2, 9));
    var expected = Set.of(new Point(0, 9),
                          new Point(1, 9),
                          new Point(2, 9));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult8() {
    LineSegment line = new LineSegment(new Point(3, 4), new Point(1, 4));
    var expected = Set.of(new Point(3, 4),
                          new Point(2, 4),
                          new Point(1, 4));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult9() {
    LineSegment line = new LineSegment(new Point(0, 0), new Point(8, 8));
    var expected = Set.of(new Point(0, 0),
                          new Point(1, 1),
                          new Point(2, 2),
                          new Point(3, 3),
                          new Point(4, 4),
                          new Point(5, 5),
                          new Point(6, 6),
                          new Point(7, 7),
                          new Point(8, 8));
    assertEquals(expected, line.getAllPointsOnLine());
  }

  @Test
  void test_getAllPointsOnLine_GivenExampleInputReturnsExpectedResult10() {
    LineSegment line = new LineSegment(new Point(5, 5), new Point(8, 2));
    var expected = Set.of(new Point(5, 5),
                          new Point(6, 4),
                          new Point(7, 3),
                          new Point(8, 2));
    assertEquals(expected, line.getAllPointsOnLine());
  }
}