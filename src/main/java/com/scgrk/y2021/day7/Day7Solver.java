package com.scgrk.y2021.day7;

import java.util.List;
import java.util.stream.Stream;

// naive, brute-force solution
public class Day7Solver {

  public long solve(String input, int part) {
    List<Integer> inputList = Stream.of(input.split(","))
        .map(Integer::parseInt)
        .collect(java.util.stream.Collectors.toList());
    if (part == 1) {
      return solvePart1(inputList,  false);
    } else {
      return solvePart1(inputList, true);
    }
  }

  public long solvePart1(List<Integer> input, boolean part2) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int item : input) {
      if (item < min) {
        min = item;
      }
      if (item > max) {
        max = item;
      }
    }

    long smallestDistance = Long.MAX_VALUE;
    for (int i = min; i <= max; i++) {
      long totalDistance = 0;
      for (int item: input) {
        if (!part2) {
          totalDistance += calcDistanceForItemPart1(item, i);
        } else {
          totalDistance += calDistanceForItemPart2(item, i);
        }
      }
      if (totalDistance < smallestDistance) {
        smallestDistance = totalDistance;
      }
    }
    return smallestDistance;
  }

  public long calcDistanceForItemPart1(int item, int i) {
    return Math.abs(item - i);
  }

  public long calDistanceForItemPart2(int item, int i) {
    int distance = Math.abs(item - i);
    int totalDistance = 0;
    for (int j = 1; j <= distance; j++) {
      totalDistance += j;
    }
    return totalDistance;
  }
}
