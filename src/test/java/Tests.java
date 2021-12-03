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
}
