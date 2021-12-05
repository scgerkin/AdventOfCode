package com.scgrk.y2020.day1;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1Solver {

  public int solve(String input, int part) {
    Set<Integer> inputStream = Stream.of(input.split("\n")).map(Integer::parseInt).collect(Collectors.toSet());
    if (part == 1) {
      return solvePart1(inputStream);
    } else {
      return solvePart2(inputStream);
    }
  }

  public int solvePart1(Set<Integer> input) {
    for (Integer i : input) {
      if (input.contains(2020 - i)) {
        return i * (2020 - i);
      }
    }
    throw new IllegalStateException("No solution found");
  }

  public int solvePart2(Set<Integer> input) {
    for (Integer i : input) {
      for (Integer j : input) {
        if (i.equals(j)) {
          continue;
        }
        if (input.contains(2020 - i - j)) {
          return i * j * (2020 - i - j);
        }
      }
    }
    throw new IllegalStateException("No solution found");
  }

}
