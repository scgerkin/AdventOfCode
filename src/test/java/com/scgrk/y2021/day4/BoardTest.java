package com.scgrk.y2021.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BoardTest {

  String input = " 3 15  0  2 22\n"
      + " 9 18 13 17  5\n"
      + "19  8  7 25 23\n"
      + "20 11 10 24  4\n"
      + "14 21 16 12  6";

  @Test
  void test_constructor_ParsesExpectedBoard() {
    Board board = new Board(input);
    List<List<Pair>> expected = new ArrayList<>();

    List<Pair> row1 = new ArrayList<>();
    row1.add(new Pair(3, false));
    row1.add(new Pair(15, false));
    row1.add(new Pair(0, false));
    row1.add(new Pair(2, false));
    row1.add(new Pair(22, false));

    expected.add(row1);

    List<Pair> row2 = new ArrayList<>();
    row2.add(new Pair(9, false));
    row2.add(new Pair(18, false));
    row2.add(new Pair(13, false));
    row2.add(new Pair(17, false));
    row2.add(new Pair(5, false));

    expected.add(row2);

    List<Pair> row3 = new ArrayList<>();
    row3.add(new Pair(19, false));
    row3.add(new Pair(8, false));
    row3.add(new Pair(7, false));
    row3.add(new Pair(25, false));
    row3.add(new Pair(23, false));

    expected.add(row3);

    List<Pair> row4 = new ArrayList<>();
    row4.add(new Pair(20, false));
    row4.add(new Pair(11, false));
    row4.add(new Pair(10, false));
    row4.add(new Pair(24, false));
    row4.add(new Pair(4, false));

    expected.add(row4);

    List<Pair> row5 = new ArrayList<>();
    row5.add(new Pair(14, false));
    row5.add(new Pair(21, false));
    row5.add(new Pair(16, false));
    row5.add(new Pair(12, false));
    row5.add(new Pair(6, false));

    expected.add(row5);

    var actual = board.getBoard();

    assertEquals(expected, actual);
  }

  @Test
  void test_mark_MarksCorrectItemAsTrue() {
    Board board = new Board(input);

    board.mark(3);
    assertTrue(board.getBoard().get(0).get(0).isMarked());

    board.mark(6);
    assertTrue(board.getBoard().get(0).get(0).isMarked());
    assertTrue(board.getBoard().get(4).get(4).isMarked());

    board.mark(7);
    assertTrue(board.getBoard().get(0).get(0).isMarked());
    assertTrue(board.getBoard().get(4).get(4).isMarked());
    assertTrue(board.getBoard().get(2).get(2).isMarked());
  }

  @Test
  void test_hasBingo_ReturnsTrueIfHorizontalBingo() {
    Board board = new Board(input);

    board.mark(3);
    board.mark(15);
    board.mark(0);
    board.mark(2);
    board.mark(22);

    assertTrue(board.hasBingo());
  }

  @Test
  void test_hasBingo_ReturnsTrueIfVerticalBingo() {
    Board board = new Board(input);

    board.mark(3);
    board.mark(9);
    board.mark(19);
    board.mark(20);
    board.mark(14);

    assertTrue(board.hasBingo());
  }

  @Test
  void test_getSumOfUnmarked_GivenNoMarkedItemsReturnsSumOfEntireBoard() {
    Board board = new Board(input);

    assertEquals(324, board.getSumOfUnmarked());
  }

  @Test
  void test_getSumOfUnmarked_GivenMarkedItemsReturnsSumOfRemainingItems() {
    Board board = new Board(input);

    board.mark(3);
    board.mark(15);
    board.mark(0);
    board.mark(2);
    board.mark(22);

    assertEquals(324 - (3 + 15 + 2 + 22), board.getSumOfUnmarked());
  }
}