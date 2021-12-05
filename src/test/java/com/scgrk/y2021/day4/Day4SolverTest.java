package com.scgrk.y2021.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day4SolverTest {

  @Test
  void test_solve_part1() {
    Day4Solver solver = new Day4Solver();
    assertEquals(4512, solver.solve(Day4Input.TEST_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day4Solver solver = new Day4Solver();
    assertEquals(1924, solver.solve(Day4Input.TEST_INPUT, 2));
  }

  @Test
  void test_solve_part1_realInput() {
    Day4Solver solver = new Day4Solver();
    assertEquals(25410, solver.solve(Day4Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2_realInput() {
    Day4Solver solver = new Day4Solver();
    assertEquals(2730, solver.solve(Day4Input.REAL_INPUT, 2));
  }
}