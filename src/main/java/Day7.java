import java.util.Arrays;

public class Day7 extends Day {

  @Override
  public long task1() {
    int[] positions =
        Arrays.stream(puzzleInputStream().findFirst().get().split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

    int cheapest = Integer.MAX_VALUE;

    for (int i = 0; i < positions.length; i++) {
      int currentCost = 0;
      for (int j = 0; j < positions.length; j++) {
        currentCost += Math.abs(positions[j] - positions[i]);
      }
      if (currentCost < cheapest) {
        cheapest = currentCost;
      }
    }
    return cheapest;
  }

  @Override
  public long task2() {
    int[] positions =
        Arrays.stream(puzzleInputStream().findFirst().get().split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

    int cheapest = Integer.MAX_VALUE;

    for (int i = 0; i < positions.length; i++) {
      int currentCost = 0;
      for (int j = 0; j < positions.length; j++) {
        currentCost += getDistance(positions[j], positions[i]);
      }
      if (currentCost < cheapest) {
        cheapest = currentCost;
      }
    }
    return cheapest;
  }

  private int getDistance(int one, int two) {
    int max = Math.max(one, two);
    int min = Math.min(one, two);
    int steps = 1;
    int distance = 0;
    while (max != min) {
      distance += steps;
      steps++;
      max--;
    }
    return distance;
  }
}
