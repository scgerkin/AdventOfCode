package com.scgrk.y2021.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day3SolverTest {

  @Test
  void test_solve_part1() {
    Day3Solver solver = new Day3Solver();
    assertEquals(198, solver.solve(Day3Input.TEST_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day3Solver solver = new Day3Solver();
    assertEquals(230, solver.solve(Day3Input.TEST_INPUT, 2));
  }

  @Test
  void test_solve_part1_realInput() {
    Day3Solver solver = new Day3Solver();
    assertEquals(3813416, solver.solve(Day3Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2_realInput() {
    Day3Solver solver = new Day3Solver();
    assertEquals(2990784, solver.solve(Day3Input.REAL_INPUT, 2));
  }
}
