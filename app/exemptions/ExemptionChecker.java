package app.exemptions;

import app.products.Product;
import java.util.ArrayList;

public class ExemptionChecker {

  public static boolean checkForExemptions(Product product) {
    ArrayList<String> exemptions = getExemptions();
    for (String exemptItem : exemptions) {
      if (product.description.contains(exemptItem)) {
        return true;
      }
    }
    return false;
  }

  private static ArrayList<String> getExemptions() {
    ArrayList<String> exemptions = new ArrayList<String>();
    exemptions.add("chocolate");
    exemptions.add("book");
    exemptions.add("headache pills");
    return exemptions;
  }
}
