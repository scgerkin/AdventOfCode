package com.scgrk.y2021.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day5SolverTest {

  @Test
  void test_solve_part1() {
    Day5Solver solver = new Day5Solver();
    assertEquals(5, solver.solve(Day5Input.TEST_INPUT, 1));
  }

  @Test
  void test_solve_part1_realInput() {
    Day5Solver solver = new Day5Solver();
    assertEquals(5306, solver.solve(Day5Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day5Solver solver = new Day5Solver();
    assertEquals(12, solver.solve(Day5Input.TEST_INPUT, 2));
  }

  @Test
  void test_solve_part2_realInput() {
    Day5Solver solver = new Day5Solver();
    assertEquals(17787, solver.solve(Day5Input.REAL_INPUT, 2));
  }
}
