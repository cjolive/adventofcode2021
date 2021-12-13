import java.util.*;
import java.util.stream.Collectors;

public class Day10 extends Day {

  Set<Character> startChunks = Set.of('{', '(', '[', '<');
  Map<Character, Character> chunkMap = Map.of('}', '{', ')', '(', ']', '[', '>', '<');
  Map<Character, Character> completeChunkMap = Map.of('{', '}', '(', ')', '[', ']', '<', '>');

  @Override
  public long task1() {
    List<String> inputLines = puzzleInputStream().collect(Collectors.toList());
    List<Character> invalidChars = new ArrayList<>();

    for (String inputLine : inputLines) {
      Stack<Character> chunkStack = new Stack<>();

      char[] chunks = inputLine.toCharArray();

      for (char c : chunks) {
        if (!isStartChunk(c)) {
          char startChunk = chunkStack.pop();
          if (chunkMap.get(c) != startChunk) {
            invalidChars.add(c);
            break;
          }
        } else {
          chunkStack.push(c);
        }
      }
    }

    return calculateScore(invalidChars);
  }

  @Override
  public long task2() {

    List<String> inputLines = puzzleInputStream().collect(Collectors.toList());
    List<String> completedLines = new ArrayList<>();
    Iterator<String> inputLinesIterator = inputLines.iterator();

    MAIN_LOOP:
    while (inputLinesIterator.hasNext()) {
      String inputLine = inputLinesIterator.next();
      Stack<Character> chunkStack = new Stack<>();
      char[] chunks = inputLine.toCharArray();

      for (char c : chunks) {
        if (!isStartChunk(c)) {
          char startChunk = chunkStack.pop();
          if (chunkMap.get(c) != startChunk) {
            inputLinesIterator.remove();
            continue MAIN_LOOP;
          }
        } else {
          chunkStack.push(c);
        }
      }

      StringBuilder charsToComplete = new StringBuilder();

      while (!chunkStack.isEmpty()) {
        char chunk = chunkStack.pop();
        charsToComplete.append(completeChunkMap.get(chunk));
      }

      completedLines.add(charsToComplete.toString());
    }

    List<Long> sortedLines =
        completedLines.stream()
            .map(s -> calculateCompletedScore(s))
            .sorted()
            .collect(Collectors.toList());

    return sortedLines.get(completedLines.size() / 2);
  }

  private boolean isStartChunk(char c) {
    return startChunks.contains(c);
  }

  private long calculateScore(List<Character> invalidChars) {
    long sum = 0;
    for (Character c : invalidChars) {
      switch (c) {
        case ')' -> sum += 3;
        case ']' -> sum += 57;
        case '}' -> sum += 1197;
        case '>' -> sum += 25137;
      }
    }
    return sum;
  }

  private long calculateCompletedScore(String completeString) {
    long sum = 0;
    for (char c : completeString.toCharArray()) {
      switch (c) {
        case ')' -> sum = (sum * 5) + 1;
        case ']' -> sum = (sum * 5) + 2;
        case '}' -> sum = (sum * 5) + 3;
        case '>' -> sum = (sum * 5) + 4;
      }
    }
    return sum;
  }
}
