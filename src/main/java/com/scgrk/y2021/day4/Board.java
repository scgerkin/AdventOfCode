package com.scgrk.y2021.day4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.Data;
import lombok.Getter;

@Data
public class Board {

  private List<List<Pair>> board;
  @Getter
  private boolean solved = false;

  public Board(String rawBoard) {
    board = Stream.of(rawBoard.trim().split("\n"))
        .map(row -> Stream.of(row.split("\\s+"))
            .filter(item -> !item.isBlank())
            .map(item -> new Pair(Integer.parseInt(item), false))
            .collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  public void mark(int value) {
    board.forEach(row -> row.stream()
        .filter(pair -> pair.getValue() == value)
        .forEach(pair -> pair.setMarked(true)));
  }

  public boolean hasBingo() {
    boolean hasBingo = hasHorizontalBingo() || hasVerticalBingo();
    if (hasBingo) {
      solved = true;
    }
    return hasBingo;
  }

  private boolean hasHorizontalBingo() {
    return board.stream()
        .anyMatch(row -> row.stream()
            .allMatch(Pair::isMarked));
  }

  private boolean hasVerticalBingo() {
    return IntStream.range(0, board.get(0).size())
        .anyMatch(col -> board.stream()
            .map(row -> row.get(col))
            .allMatch(Pair::isMarked));
  }

  public int getSumOfUnmarked() {
    return board.stream()
        .flatMap(List::stream)
        .filter(pair -> !pair.isMarked())
        .mapToInt(Pair::getValue)
        .sum();
  }

  @Override
  public String toString() {
    return board.stream()
        .map(row -> row.stream()
            .map(pair -> pair.getValue() + ": " + (pair.isMarked() ? "X" : "-"))
            .collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
