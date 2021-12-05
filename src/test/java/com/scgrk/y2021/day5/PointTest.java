package com.scgrk.y2021.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void test_constructor_GivenStringArrayWith2ItemsCorrectlyParsesXAndY() {
    var input = new String[]{"   1   ", "  2  "};
    var point = new Point(input);
    assertEquals(1, point.getX());
    assertEquals(2, point.getY());
  }
}