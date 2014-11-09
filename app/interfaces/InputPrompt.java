package app.interfaces;

import java.io.*;

public class InputPrompt {

  public static String getInput() {
    BufferedReader stdin = new BufferedReader(
      new InputStreamReader(System.in));

    System.out.print(
      "Enter file name, not including the file extension, of the purchase order: "
    );
    System.out.flush();

    try {
      return stdin.readLine();
    } catch (Exception error) {
      return "Error: " + error.getMessage();
    }
  }
}
