package com.scgrk.y2021.day4;

import lombok.Data;

@Data
public class Pair {

  private int value;
  private boolean marked;

  public Pair(int value, boolean marked) {
    this.value = value;
    this.marked = marked;
  }
}
