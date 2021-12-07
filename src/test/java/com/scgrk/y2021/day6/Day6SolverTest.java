package com.scgrk.y2021.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class Day6SolverTest {

  @Test
  void test_solve_part1() {
    Day6Solver solver = new Day6Solver();
    assertEquals(5934L, solver.solve(Day6Input.TEST_INPUT, 1));
  }

  @Test
  void test_solve_part1_realInput() {
    Day6Solver solver = new Day6Solver();
    assertEquals(374927L, solver.solve(Day6Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day6Solver solver = new Day6Solver();
    assertEquals(26984457539L, solver.solve(Day6Input.TEST_INPUT, 2));
  }

  @Test
  void test_solve_part2_realInput() {
    Day6Solver solver = new Day6Solver();
    assertEquals(1687617803407L, solver.solve(Day6Input.REAL_INPUT, 2));
  }

  @Test
  void test_age_ReturnsExpectedResultOnExampleInput1() {
    var input = new HashMap<Integer, Long>();
    input.put(0, 0L);
    input.put(1, 1L);
    input.put(2, 1L);
    input.put(3, 2L);
    input.put(4, 1L);
    input.put(5, 0L);
    input.put(6, 0L);
    input.put(7, 0L);
    input.put(8, 0L);

    var expected = new HashMap<Integer, Long>();
    expected.put(0, 1L);
    expected.put(1, 1L);
    expected.put(2, 2L);
    expected.put(3, 1L);
    expected.put(4, 0L);
    expected.put(5, 0L);
    expected.put(6, 0L);
    expected.put(7, 0L);
    expected.put(8, 0L);

    Day6Solver solver = new Day6Solver();
    assertEquals(expected, solver.age(input));
  }

  @Test
  void test_age_ReturnsExpectedResultOnExampleInput2() {
    var input = new HashMap<Integer, Long>();
    input.put(0, 1L);
    input.put(1, 1L);
    input.put(2, 2L);
    input.put(3, 1L);
    input.put(4, 0L);
    input.put(5, 0L);
    input.put(6, 0L);
    input.put(7, 0L);
    input.put(8, 0L);
    var expected = new HashMap<Integer, Long>();
    expected.put(0, 1L);
    expected.put(1, 2L);
    expected.put(2, 1L);
    expected.put(3, 0L);
    expected.put(4, 0L);
    expected.put(5, 0L);
    expected.put(6, 1L);
    expected.put(7, 0L);
    expected.put(8, 1L);

    Day6Solver solver = new Day6Solver();
    assertEquals(expected, solver.age(input));
  }
}
