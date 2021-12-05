package com.scgrk.y2020.day2;

import java.util.stream.Stream;

public class Day2Solver {

  public long solve(String input, int part) {

    var stream = Stream.of(input.split("\n")).map(ParsedInput::new);

    if (part == 1) {
      return solvePart1(stream);
    } else {
      return solvePart2(stream);
    }
  }

  private long solvePart1(Stream<ParsedInput> stream) {
    return stream.filter(item -> {
          long count = item.getPassword().chars().filter(c -> c == item.getReqChar()).count();
          return count >= item.getFirstNum() && count <= item.getSecondNum();
        })
        .count();
  }

  private long solvePart2(Stream<ParsedInput> stream) {
    return stream.filter(item -> {
          if (item.getPassword().charAt(item.getFirstNum() - 1) == item.getReqChar()) {
            return item.getPassword().charAt(item.getSecondNum() - 1) != item.getReqChar();
          } else if (item.getPassword().charAt(item.getSecondNum() - 1) == item.getReqChar()) {
            return item.getPassword().charAt(item.getFirstNum() - 1) != item.getReqChar();
          }
          return false;
        })
        .count();
  }

}
