package app;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
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
    List<String> items = parseFile(srcFile);
    
    String item = items.get(0);
    System.out.println(item);
    String[] productPrice = item.split(" at ");
    String product = productPrice[0];
    double price = setPrice(productPrice[1]);

    System.out.println(price);
    
    File destFile = makeReceipt(userInput);
    try {
      FileUtils.writeLines(destFile, items);
    } catch (IOException error) {
      System.out.println("Nothing to print out");
      return;
    }


    System.out.println(items);
  }
  
  private static double setPrice (String productPrice) throws NumberFormatException {
    try {
      double num = Double.parseDouble(productPrice);
      return num;
    } catch (NumberFormatException error) {
      System.out.println("Could not parse a valid number for price");
      System.exit(0);
      return 0;
    }
  }
  
  private static List<String> parseFile (File srcFile) {
    try {
      List<String> items = FileUtils.readLines(srcFile);
      return items;
    } catch (Exception error) {
      error.printStackTrace();
      List<String> items = new ArrayList<String>();
      return items;
    }
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
