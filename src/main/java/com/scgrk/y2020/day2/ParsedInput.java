package com.scgrk.y2020.day2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParsedInput {

  private final int firstNum;
  private final int secondNum;
  private final char reqChar;
  private final String password;

  public ParsedInput(String input) {
    String[] split = input.split(": ");
    String[] split2 = split[0].split(" ");
    String[] split3 = split2[0].split("-");
    firstNum = Integer.parseInt(split3[0]);
    secondNum = Integer.parseInt(split3[1]);
    reqChar = split2[1].charAt(0);
    password = split[1];
  }
}
