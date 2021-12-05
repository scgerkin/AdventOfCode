package com.scgrk.y2021.day5;

import lombok.Data;

@Data
public class Point {

  private final int x;
  private final int y;

  public Point(String[] point) {
    this.x = Integer.parseInt(point[0].trim());
    this.y = Integer.parseInt(point[1].trim());
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

}
