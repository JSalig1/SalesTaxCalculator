package app.files;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class FileParser {

  public static List<String> getItems(String name) {
    File srcFile = getFile(name);
    List<String> items = parseFile(srcFile);
    return items;
  }

  private static File getFile (String name) {
    File srcFile = new File(name + ".txt");
    return srcFile;
  }

  private static List<String> parseFile(File srcFile) {
    try {
      List<String> items = FileUtils.readLines(srcFile);
      return items;
    } catch (Exception error) {
      error.printStackTrace();
      List<String> items = new ArrayList<String>();
      return items;
    }
  }
}
