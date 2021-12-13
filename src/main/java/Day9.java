import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day9 extends Day {

  @Override
  public long task1() {
    List<String> inputLines = puzzleInputStream().collect(Collectors.toList());
    List<Integer> lowPoints = new ArrayList<>();

    for (int i = 0; i < inputLines.size(); i++) {

      for (int j = 0; j < inputLines.get(i).length(); j++) {
        boolean lowPoint = true;
        Integer num = Character.getNumericValue(inputLines.get(i).charAt(j));
        if (j >= 1) { // check left
          lowPoint &= num < Character.getNumericValue(inputLines.get(i).charAt(j - 1));
        }
        if (j < inputLines.get(i).length() - 1) { // check right
          lowPoint &= num < Character.getNumericValue(inputLines.get(i).charAt(j + 1));
        }
        if (i >= 1) { // check up
          lowPoint &= num < Character.getNumericValue(inputLines.get(i - 1).charAt(j));
        }
        if (i < inputLines.size() - 1) { // check down
          lowPoint &= num < Character.getNumericValue(inputLines.get(i + 1).charAt(j));
        }
        if (lowPoint) {
          lowPoints.add(num);
        }
      }
    }

    long riskLevel = 0;
    for (Integer lowPoint : lowPoints) {
      riskLevel += lowPoint + 1;
    }

    return riskLevel;
  }

  @Override
  public long task2() {
    return 0;
  }
}
