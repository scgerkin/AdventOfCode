package com.scgrk.y2021.day2;

import lombok.Data;

@Data
public class Movement {

  private Direction direction;
  private int distance;

  public Movement(String input) {
    String[] parts = input.split(" ");
    this.direction = Direction.valueOf(parts[0].toUpperCase());
    this.distance = Integer.parseInt(parts[1]);
  }

  public enum Direction {
    FORWARD, DOWN, UP
  }
}
