import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

public class Day2 extends Day {
  @Override
  public long task1() {
    int horizontal = 0;
    int depth = 0;
    List<Instruction> instructions =
        puzzleInputStream().map(s -> new Instruction(s)).collect(Collectors.toList());

    for (Instruction i : instructions) {
      switch (i.getDirection()) {
        case "forward" -> horizontal += i.getAmount();
        case "down" -> depth += i.getAmount();
        case "up" -> depth -= i.getAmount();
      }
    }
    return horizontal * depth;
  }

  @Override
  public long task2() {
    int horizontal = 0;
    int depth = 0;
    int aim = 0;
    List<Instruction> instructions =
        puzzleInputStream().map(s -> new Instruction(s)).collect(Collectors.toList());

    for (Instruction i : instructions) {
      switch (i.getDirection()) {
        case "forward":
          horizontal += i.getAmount();
          depth += (aim * i.getAmount());
          break;
        case "down":
          aim += i.getAmount();
          break;
        case "up":
          aim -= i.getAmount();
          break;
      }
    }
    return horizontal * depth;
  }

  @Getter
  class Instruction {

    private String direction;
    private int amount;

    public Instruction(String instruction) {
      this.direction = instruction.split(" ")[0];
      this.amount = Integer.valueOf(instruction.split(" ")[1]);
    }
  }
}
