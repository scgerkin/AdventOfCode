package com.scgrk.y2020.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day1SolverTest {

  @Test
  void test_solve_part1() {
    Day1Solver solver = new Day1Solver();
    assertEquals(514579, solver.solve(Day1Input.TEST_INPUT, 1));
  }

  @Test
  void test_solve_part1_realInput() {
    Day1Solver solver = new Day1Solver();
    assertEquals(1007331, solver.solve(Day1Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day1Solver solver = new Day1Solver();
    assertEquals(241861950, solver.solve(Day1Input.TEST_INPUT, 2));
  }

  @Test
  void test_solve_part2_realInput() {
    Day1Solver solver = new Day1Solver();
    assertEquals(48914340, solver.solve(Day1Input.REAL_INPUT, 2));
  }
}
