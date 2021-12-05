package com.scgrk.y2021.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day1Solver {

  public int solve(String input, int part) {

    List<Integer> items = Arrays.stream(input.split("\n"))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    if (part == 1) {
      return solvePart1(items);
    } else {
      return solvePart2(items);
    }
  }

  public int solvePart1(List<Integer> items) {
    int count = 0;

    int previous = items.get(0);
    for (int item : items) {
      if (item > previous) {
        count++;
      }
      previous = item;
    }

    return count;
  }

  public int solvePart2(List<Integer> items) {
    int count = 0;

    int previous = items.get(0) + items.get(1);

    for (int i = 2; i < items.size() - 1; i++) {
      int item = items.get(i);
      int sum = item + items.get(i - 1) + items.get(i - 2);
      if (sum > previous) {
        count++;
      }
      previous = sum;
    }

    return count;
  }
}
