package gokul2411s.projects.patternsrepo.editor;

import com.google.common.primitives.Ints;
import gokul2411s.projects.patternsrepo.command.StatefulInvoker;
import gokul2411s.projects.patternsrepo.command.StatefulInvokers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A sample editor application, where the user input is simulated by creating command objects.
 */
public class Main {

  private static final String APPEND_COMMAND = "APPEND";
  private static final String INSERT_COMMAND = "INSERT";
  private static final String DELETE_COMMAND = "DELETE";
  private static final String UNDO_COMMAND = "UNDO";

  /**
   * In the following code, the {@link StatefulInvoker#react} method is called directly for ease.
   * However, in an event-driven scenario, the invoker would be fired based on events from an event
   * source.
   */
  public static void main(String[] args) throws IOException {

    AsciiText asciiText = new AsciiText();
    StatefulInvoker statefulInvoker = StatefulInvokers.defaultImpl();

    // Read commands and invoke them.
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String line;
      while ((line = br.readLine()) != null) {
        try {
          // Read a command and execute it.
          String[] lineSplit = line.split(" ");
          switch (lineSplit[0]) {
            case APPEND_COMMAND:
              char charToAppend = lineSplit[1].charAt(0);
              statefulInvoker.react(new AppendCharCommand(asciiText, charToAppend));
              break;
            case INSERT_COMMAND:
              char charToInsert = lineSplit[1].charAt(0);
              int indexToInsert = Ints.tryParse(lineSplit[2]);
              statefulInvoker.react(new InsertCharCommand(asciiText, charToInsert, indexToInsert));
              break;
            case DELETE_COMMAND:
              int indexToDelete = Ints.tryParse(lineSplit[1]);
              statefulInvoker.react(new DeleteCharCommand(asciiText, indexToDelete));
              break;
            case UNDO_COMMAND:
              statefulInvoker.undo();
              break;
            default:
              System.out.format("Unrecognized command [%s]\n\n", lineSplit[0]);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

        // Print the existing text
        System.out.format("Text is [%s]\n\n", asciiText.toString());
      }
    }

  }
}
