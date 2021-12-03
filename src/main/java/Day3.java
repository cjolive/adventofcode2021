import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 extends Day {
  private static final int BINARY_LENGTH = 12;

  @Override
  public long task1() {
    int[] binaryZero = new int[BINARY_LENGTH];
    int[] binaryOnes = new int[BINARY_LENGTH];

    puzzleInputStream()
        .map(s -> s.toCharArray())
        .forEach(chars -> updateArrays(chars, binaryZero, binaryOnes));

    char[] gammaRate = new char[BINARY_LENGTH];
    char[] epsilonRate = new char[BINARY_LENGTH];

    for (int i = 0; i < BINARY_LENGTH; i++) {
      if (binaryZero[i] > binaryOnes[i]) {
        gammaRate[i] = '0';
        epsilonRate[i] = '1';
      } else {
        gammaRate[i] = '1';
        epsilonRate[i] = '0';
      }
    }
    return Long.parseLong(new String(gammaRate), 2) * Long.parseLong(new String(epsilonRate), 2);
  }

  @Override
  public long task2() {
    int[] binaryZero = new int[BINARY_LENGTH];
    int[] binaryOnes = new int[BINARY_LENGTH];

    List<char[]> oxygenNumbers =
        puzzleInputStream().map(s -> s.toCharArray()).collect(Collectors.toList());

    for (int i = 0; i < BINARY_LENGTH; i++) {
      final int index = i;
      resetArrays(binaryZero, binaryOnes);
      oxygenNumbers.forEach(chars -> updateArrays(chars, binaryZero, binaryOnes));
      char filter = binaryZero[i] > binaryOnes[i] ? '0' : '1';
      oxygenNumbers.removeIf(c -> c[index] != filter);
      if (oxygenNumbers.size() == 1) {
        break;
      }
    }

    List<char[]> co2Numbers =
        puzzleInputStream().map(s -> s.toCharArray()).collect(Collectors.toList());

    for (int i = 0; i < BINARY_LENGTH; i++) {
      final int index = i;
      resetArrays(binaryZero, binaryOnes);
      co2Numbers.forEach(chars -> updateArrays(chars, binaryZero, binaryOnes));
      char co2Filter = binaryZero[i] <= binaryOnes[i] ? '0' : '1';
      co2Numbers.removeIf(c -> c[index] != co2Filter);
      if (co2Numbers.size() == 1) {
        break;
      }
    }

    return Long.parseLong(new String(oxygenNumbers.get(0)), 2)
        * Long.parseLong(new String(co2Numbers.get(0)), 2);
  }

  private void updateArrays(char[] chars, int[] binaryZero, int[] binaryOnes) {
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '0') {
        binaryZero[i]++;
      } else {
        binaryOnes[i]++;
      }
    }
  }

  private void resetArrays(int[] binaryZero, int[] binaryOnes) {
    Arrays.fill(binaryZero, 0);
    Arrays.fill(binaryOnes, 0);
  }
}
