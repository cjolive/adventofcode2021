import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Tests {

  @Test
  public void testDay1() {
    Day day = new Day1();
    assertEquals(1292, day.task1());
    assertEquals(1262, day.task2());
  }

  @Test
  public void testDay2() {
    Day day = new Day2();
    assertEquals(1693300, day.task1());
    assertEquals(1857958050, day.task2());
  }

  @Test
  public void testDay3() {
    Day day = new Day3();
    assertEquals(4103154, day.task1());
    assertEquals(4245351, day.task2());
  }

  @Test
  public void testDay4() {
    Day day = new Day4();
    assertEquals(50008, day.task1());
    assertEquals(17408, day.task2());
  }

  @Test
  public void testDay6() {
    Day day = new Day6();
    assertEquals(361169, day.task1());
    assertEquals(1634946868992L, day.task2());
  }

  @Test
  public void testDay7() {
    Day day = new Day7();
    assertEquals(345197, day.task1());
    assertEquals(96361606, day.task2());
  }

  @Test
  public void testDay9() {
    Day day = new Day9();
    assertEquals(448, day.task1());
    assertEquals(0, day.task2());
  }

  @Test
  public void testDay10() {
    Day day = new Day10();
    assertEquals(319233, day.task1());
    assertEquals(1118976874, day.task2());
  }
}
