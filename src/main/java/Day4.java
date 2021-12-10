import com.google.common.base.Strings;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 extends Day {

  String[] numbers;

  @Override
  public long task1() {
    List<Grid> grids = buildGrids(puzzleInputStream().collect(Collectors.toList()));
    for (int i = 0; i < numbers.length; i++) {
      for (Grid grid : grids) {
        grid.findNumber(Integer.valueOf(numbers[i]));
        if (grid.isComplete()) {
          return grid.getScore() * Integer.valueOf(numbers[i]);
        }
      }
    }
    return 0;
  }

  @Override
  public long task2() {
    List<Grid> grids = buildGrids(puzzleInputStream().collect(Collectors.toList()));

    for (int i = 0; i < numbers.length; i++) {
      Iterator<Grid> iterator = grids.iterator();
      while (iterator.hasNext()) {
        Grid grid = iterator.next();
        grid.findNumber(Integer.valueOf(numbers[i]));
        if (grid.isComplete()) {
          iterator.remove();
        }
        if (grids.isEmpty()) {
          return grid.getScore() * Integer.valueOf(numbers[i]);
        }
      }
    }
    return 0;
  }

  private List<Grid> buildGrids(List<String> lines) {
    List<Grid> grids = new ArrayList<>();
    List<String> charList = new ArrayList<>();

    for (String line : lines) {
      if (line.contains(",")) { // drawn numbers
        numbers = line.split(",");
        continue;
      }
      if (!line.isBlank()) {
        String[] nums = line.split(" ");
        for (String num : nums) {
          if (!Strings.isNullOrEmpty(num)) {
            charList.add(num);
          }
        }
      }
      if (line.isBlank() && !charList.isEmpty()) {
        grids.add(new Grid(charList));
        charList.clear();
      }
    }
    if (!charList.isEmpty()) {
      grids.add(new Grid(charList));
    }
    return grids;
  }

  class Grid {
    int[] numbers = new int[25];
    boolean[] foundNumbers = new boolean[25];

    Grid(List<String> gridLine) {
      for (int i = 0; i < numbers.length; i++) {
        numbers[i] = Integer.valueOf(gridLine.get(i));
      }
    }

    public void findNumber(int number) {
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == number) {
          foundNumbers[i] = true;
        }
      }
    }

    public boolean isComplete() {

      for (int i = 0; i < 5; i++) {
        boolean rowFound = true;
        boolean columnFound = true;

        for (int c = i; c < foundNumbers.length; c += 5) {
          if (foundNumbers[c] == false) {
            columnFound = false;
          }
        }

        for (int r = i * 5; r < (i * 5) + 5; r++) {
          if (foundNumbers[r] == false) {
            rowFound = false;
          }
        }

        if (rowFound || columnFound) {
          return true;
        }
      }
      return false;
    }

    public int getScore() {
      int sum = 0;
      for (int i = 0; i < foundNumbers.length; i++) {
        if (foundNumbers[i] == false) {
          sum += numbers[i];
        }
      }
      return sum;
    }
  }
}
