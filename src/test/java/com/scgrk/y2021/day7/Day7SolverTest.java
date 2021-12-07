package com.scgrk.y2021.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day7SolverTest {

  @Test
  void test_solve_part1() {
    Day7Solver solver = new Day7Solver();
    assertEquals(37L, solver.solve(Day7Input.TEST_INPUT, 1));
  }

  @Test
  void test_solve_part1_realInput() {
    Day7Solver solver = new Day7Solver();
    assertEquals(335330L, solver.solve(Day7Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day7Solver solver = new Day7Solver();
    assertEquals(168L, solver.solve(Day7Input.TEST_INPUT, 2));
  }

  @Test
  void test_solve_part2_realInput() {
    Day7Solver solver = new Day7Solver();
    assertEquals(92439766L, solver.solve(Day7Input.REAL_INPUT, 2));
  }
}
