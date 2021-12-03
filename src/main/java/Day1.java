public class Day1 extends Day {

  @Override
  public long task1() {
    Integer[] numbers = puzzleInputStream().map(s -> Integer.valueOf(s)).toArray(Integer[]::new);

    int increased = 0;
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > numbers[i - 1]) {
        increased++;
      }
    }
    return increased;
  }

  @Override
  public long task2() {
    Integer[] numbers = puzzleInputStream().map(s -> Integer.valueOf(s)).toArray(Integer[]::new);

    int sum1 = numbers[0] + numbers[1] + numbers[2];
    int increased = 0;
    for (int i = 1; i < numbers.length - 2; i++) {
      int sum2 = numbers[i] + numbers[i + 1] + numbers[i + 2];
      if (sum2 > sum1) {
        increased++;
      }
      sum1 = sum2;
    }
    return increased;
  }
}
