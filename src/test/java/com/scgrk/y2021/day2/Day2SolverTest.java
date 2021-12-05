package com.scgrk.y2021.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day2SolverTest {

  @Test
  void test_solve_part1() {
    Day2Solver solver = new Day2Solver();
    assertEquals(150, solver.solve(Day2Input.TEST_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day2Solver solver = new Day2Solver();
    assertEquals(900, solver.solve(Day2Input.TEST_INPUT, 2));
  }

  @Test
  void test_solve_part1_realInput() {
    Day2Solver solver = new Day2Solver();
    assertEquals(2073315, solver.solve(Day2Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2_realInput() {
    Day2Solver solver = new Day2Solver();
    assertEquals(1840311528, solver.solve(Day2Input.REAL_INPUT, 2));
  }
}
