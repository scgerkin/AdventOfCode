package com.scgrk.y2021.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Day3Solver {

  public int solve(String input, int part) {

    List<String> lines = Arrays.stream(input.split("\n")).collect(Collectors.toList());

    if (part == 1) {
      return solvePart1(lines);
    } else {
      return solvePart2(lines);
    }
  }

  public int solvePart1(List<String> input) {
    int gamma = find(input, this::getMostCommonBit);
    int epsilon = find(input, this::getLeastCommonBit);
    return gamma * epsilon;
  }

  private int find(List<String> input, BiFunction<List<String>, Integer, Character> bitFinder) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.get(0).length(); i++) {
      char bit = bitFinder.apply(input, i);
      sb.append(bit);
    }
    return Integer.parseInt(sb.toString(), 2);
  }

  public int solvePart2(List<String> input) {
    int oxygen = findWithFilter(input, this::getMostCommonBit);
    int carbon = findWithFilter(input, this::getLeastCommonBit);
    return oxygen * carbon;
  }

  private int findWithFilter(List<String> input, BiFunction<List<String>, Integer, Character> bitFinder) {
    List<String> temp = new ArrayList<>(input);

    int column = 0;
    while (true) {
      final int columnFinal = column;
      char bit = bitFinder.apply(temp, column);
      temp = temp.stream().filter(line -> line.charAt(columnFinal) == bit).collect(Collectors.toList());
      column++;
      if (temp.size() == 1) {
        return Integer.parseInt(temp.get(0), 2);
      }
    }
  }

  private char getMostCommonBit(List<String> lines, int column) {
    long ones = lines.stream()
        .filter(line -> line.charAt(column) == '1')
        .count();

    return (double) ones >= (double) lines.size() / 2 ? '1' : '0';
  }

  private char getLeastCommonBit(List<String> lines, int column) {
    char commonBit = getMostCommonBit(lines, column);
    if (commonBit == '1') {
      return '0';
    } else {
      return '1';
    }
  }
}
