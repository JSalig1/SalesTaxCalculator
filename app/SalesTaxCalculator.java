package app;

import java.io.*;

import org.apache.commons.io.FileUtils;

/**
 * @author Jeremy Salig
 * @version 1.0
 */

public class SalesTaxCalculator {
  public static void main(String[] args) {
    String userInput = getInput(
      "Enter file name of the purchase order: ");

    File srcFile = getFile(userInput);
    File destFile = makeReceipt(userInput);
    try {
      FileUtils.copyFile(srcFile, destFile);
    } catch (Exception error) {
      error.printStackTrace();
    }

    System.out.println("The answer is: " + userInput);
  }

  private static String getInput(String prompt) {
    BufferedReader stdin = new BufferedReader(
      new InputStreamReader(System.in));

    System.out.print(prompt);
    System.out.flush();

    try {
      return stdin.readLine();
    } catch (Exception error) {
      return "Error: " + error.getMessage();
    }
  }

  private static File getFile(String name) {
    File srcFile = new File(name + ".txt");
    return srcFile;
  }

  private static File makeReceipt(String name) {
    File destFile = new File(name + "_receipt.txt");
    return destFile;
  }
}
