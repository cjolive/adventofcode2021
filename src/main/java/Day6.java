import java.util.*;
import java.util.stream.Collectors;

public class Day6 extends Day {

  private List<Fish> fish;

  @Override
  public long task1() {
    initialiseFish();

    for (int i = 0; i < 80; i++) {
      List<Fish> newFish = new ArrayList<>();
      fish.forEach(
          f -> {
            f.actionDay().ifPresent(nf -> newFish.add(nf));
          });
      fish.addAll(newFish);
    }

    return fish.size();
  }

  @Override
  public long task2() {
    final int runs = 256;

    long[] fish = new long[10];

    int[] initialFish =
        Arrays.stream(puzzleInputStream().findFirst().get().split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

    for (int i : initialFish) {
      fish[i]++;
    }

    for (int run = 0; run < runs; run++) {
      fish[7] += fish[0];
      fish[9] = fish[0];
      for (int i = 0; i < 9; i++) {
        fish[i] = fish[i + 1];
      }
      fish[9] = 0;
    }
    return Arrays.stream(fish).sum();
  }

  private void initialiseFish() {
    fish =
        Arrays.stream(puzzleInputStream().findAny().get().split(","))
            .map(s -> new Fish(Integer.valueOf(s)))
            .collect(Collectors.toList());
  }

  class Fish {

    private int timer;

    Fish(int timer) {
      this.timer = timer;
    }

    public Optional<Fish> actionDay() {
      if (timer == 0) {
        timer = 6;
        return Optional.of(new Fish(8));
      }
      timer--;
      return Optional.empty();
    }
  }
}
