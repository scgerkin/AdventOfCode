package com.scgrk.y2021.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day4Solver {

  public int solve(String input, int part) {
    String[] splitByTwoLine = input.trim().split("\n\n");

    List<Integer> calls = Arrays.stream(splitByTwoLine[0].trim().split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    List<Board> boards = Arrays.stream(Arrays.copyOfRange(splitByTwoLine, 1, splitByTwoLine.length))
        .map(Board::new)
        .collect(Collectors.toList());

    if (part == 1) {
      return solvePart1(calls, boards);
    } else {
      return solvePart2(calls, boards);
    }
  }

  public int solvePart1(List<Integer> calls, List<Board> boards) {
    return calls.stream()
        .map(call -> {
          for (Board board : boards) {
            board.mark(call);
            if (board.hasBingo()) {
              return Optional.of(call * board.getSumOfUnmarked());
            }
          }
          return Optional.empty();
        })
        .filter(Optional::isPresent)
        .map(Optional::get)
        .mapToInt(i -> (int) i)
        .findFirst()
        .orElse(-1);
  }

  public int solvePart2(List<Integer> calls, List<Board> boards) {
    List<Integer> results = new ArrayList<>();

    for (int call : calls) {
      List<Board> unsolved = new ArrayList<>(boards);
      for (Board board : unsolved) {
        board.mark(call);
        if (board.hasBingo()) {
          results.add(call * board.getSumOfUnmarked());
          boards.remove(board);
        }
      }
    }

    return results.get(results.size() - 1);
  }
}
