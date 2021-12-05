package com.scgrk.y2020.day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParsedInputTest {

  @Test
  void test_constructor() {
    String input = "1-3 a: abcde";
    ParsedInput expected = new ParsedInput(1, 3, 'a', "abcde");
    ParsedInput actual = new ParsedInput(input);
    assertEquals(expected, actual);
  }
}