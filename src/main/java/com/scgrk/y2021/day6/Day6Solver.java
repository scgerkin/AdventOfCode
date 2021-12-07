package com.scgrk.y2021.day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day6Solver {

  public long solve(String input, int part) {
    List<Integer> fishes = Stream.of(input.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    if (part == 1) {
      return solvePart1(fishes, 80);
    } else {
      return solvePart1(fishes, 256);
    }
  }

  public long solvePart1(List<Integer> input, int days) {
    Map<Integer, Long> dayFishCount = initialize(input);

    for (int i = 0; i < days; i++) {
      dayFishCount = age(dayFishCount);
    }

    return dayFishCount.values().stream().mapToLong(i -> i).sum();
  }

  public Map<Integer, Long> initialize(List<Integer> fishes) {
    var dayFishCount = fishes.stream()
        .collect(Collectors.groupingBy(i -> i, Collectors.summingLong(i -> 1)));
    for (int i = 0; i <= 8; i++) {
      if (!dayFishCount.containsKey(i)) {
        dayFishCount.put(i, 0L);
      }
    }
    return dayFishCount;
  }

  public Map<Integer, Long> age(Map<Integer, Long> dayFishCount) {
    var agedFish = new HashMap<Integer, Long>();

    for (int i = 0; i <= 8; i++) {
      if (i == 8) {
        agedFish.put(i, dayFishCount.get(0));
        break;
      }
      agedFish.put(i, dayFishCount.get(i+1));
      if (i == 6) {
        agedFish.put(i, agedFish.get(i) + dayFishCount.get(0));
      }
    }

    return agedFish;
  }
}
