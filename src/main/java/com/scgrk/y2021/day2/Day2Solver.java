package com.scgrk.y2021.day2;

import com.scgrk.y2021.day2.Movement.Direction;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2Solver {

  public int solve(String input, int part) {

    List<Movement> movements = Arrays.stream(input.split("\n"))
        .map(Movement::new)
        .collect(Collectors.toList());

    if (part == 1) {
      return solvePart1(movements);
    } else {
      return solvePart2(movements);
    }
  }

  public int solvePart1(List<Movement> movements) {
    int horizontal = 0;
    int depth = 0;

    for (Movement movement : movements) {
      if (movement.getDirection().equals(Direction.FORWARD)) {
        horizontal += movement.getDistance();
      } else if (movement.getDirection().equals(Direction.UP)) {
        depth -= movement.getDistance();
      } else if (movement.getDirection().equals(Direction.DOWN)) {
        depth += movement.getDistance();
      }
    }

    return horizontal * depth;
  }

  public int solvePart2(List<Movement> movements) {
    int depth = 0;
    int horizontal = 0;
    int aim = 0;

    for (Movement movement : movements) {
      if (movement.getDirection().equals(Direction.FORWARD)) {
        horizontal += movement.getDistance();
        depth += aim * movement.getDistance();
      } else if (movement.getDirection().equals(Direction.UP)) {
        aim -= movement.getDistance();
      } else if (movement.getDirection().equals(Direction.DOWN)) {
        aim += movement.getDistance();
      }
    }

    return depth * horizontal;
  }

}
