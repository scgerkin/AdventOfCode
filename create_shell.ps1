param(
    [Int32]$year = (Get-Date).Year,
    [Int32]$day = (Get-Date).Day
)
$ErrorActionPreference = "Stop"

[System.Uri]$uri = "https://adventofcode.com/$($year)/day/$($day)/input"

$Cookie = New-Object System.Net.Cookie
$Cookie.Name = "session" # Add the name of the cookie
$Cookie.Value = $(Get-Content cookie.txt)
$Cookie.Domain = $uri.DnsSafeHost

$WebSession = New-Object Microsoft.PowerShell.Commands.WebRequestSession
$WebSession.Cookies.Add($Cookie)

$props = @{
    Uri = $uri.AbsoluteUri
    Method = "GET"
    ContentType = "application/text"
    WebSession = $WebSession
}

$input = $(Invoke-RestMethod @props)
$input = $input.Replace("`n", "\n`"`n+`"")
$input = $input.SubString(0,$input.Length-6)
$input = "`"$($input)`";"

Set-Location "$($AOC_LOC)\src\main\java\com\scgrk\y$($year)"
mkdir "day$day"
Set-Location "day$day"
New-Item "Day$( $day )Input.java"

Write-Output "package com.scgrk.day$day;

public class Day$( $day )Input {

  public static final String TEST_INPUT = `"`";

  public static final String REAL_INPUT = $($input)

}" > "Day$( $day )Input.java"

New-Item "Day$( $day )Solver.java"
Write-Output "package com.scgrk.day$day;

public class Day$( $day )Solver {

  public int solve(String input, int part) {
    if (part == 1) {
      return solvePart1(input);
    } else {
      return solvePart2(input);
    }
  }

  public int solvePart1(String input) {
    return 0;
  }

  public int solvePart2(String input) {
    return 0;
  }

}" > "Day$( $day )Solver.java"

Set-Location ..

Push-Location "$($AOC_LOC)\src\test\java\com\scgrk\y$($year)"
mkdir "day$day"
Set-Location "day$day"
New-Item "Day$( $day )SolverTest.java"
Write-Output "package com.scgrk.day$( $day );

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day$( $day )SolverTest {

  @Test
  void test_solve_part1() {
    Day$( $day )Solver solver = new Day$( $day )Solver();
    assertEquals(0, solver.solve(Day$( $day )Input.TEST_INPUT, 1));
  }

  @Disabled
  @Test
  void test_solve_part1_realInput() {
    Day$( $day )Solver solver = new Day$( $day )Solver();
    assertEquals(0, solver.solve(Day$( $day )Input.REAL_INPUT, 1));
  }

  @Test
  void test_solve_part2() {
    Day$( $day )Solver solver = new Day$( $day )Solver();
    assertEquals(0, solver.solve(Day$( $day )Input.TEST_INPUT, 2));
  }

  @Disabled
  @Test
  void test_solve_part2_realInput() {
    Day$( $day )Solver solver = new Day$( $day )Solver();
    assertEquals(0, solver.solve(Day$( $day )Input.REAL_INPUT, 2));
  }
}" > "Day$( $day )SolverTest.java"

Pop-Location

Set-Location "$($AOC_LOC)"
