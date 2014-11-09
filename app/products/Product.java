package app.products;

import app.taxes.*;
import java.math.BigDecimal;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Product {

  public BigDecimal quantity;
  public String description;
  public BigDecimal price;
  public BigDecimal tax;

  public Product(String item) {
    String[] fields = extractFields(item);
    this.quantity = setQuantity(fields[0]);
    this.description = fields[1];
    this.price = setPrice(fields[2]);
    this.tax = BigDecimal.ZERO;
  }

  public void addTax (SalesTax salesTax, ImportTax importTax) {
    this.tax = salesTax.value.add(importTax.value);
  }

  public BigDecimal pricePlusTax() {
    BigDecimal pricePlusTax = price.add(tax);
    return pricePlusTax;
  }

  private String[] extractFields (String item) {
    Pattern pattern = Pattern.compile("^(\\S+)\\s(.*?)\\sat\\s(.*)$");
    Matcher matcher = pattern.matcher(item);
    try {
      matcher.find();
      String[] parts = new String[]{matcher.group(1),matcher.group(2),matcher.group(3)};
      return parts;
    } catch (IllegalStateException error) {
      System.out.println(
        "Your file has entries that are formatted incorrectly." + "\n" +
        "Entries must conform to 'X item at X.XX'" + "\n" +
        "One item per line." + "\n" +
        "No line skipping."
      );
      System.exit(0);
      return new String[] {};
    }
  }

  private BigDecimal setQuantity (String fieldValue) throws NumberFormatException {
    try {
      BigDecimal quantity = new BigDecimal(fieldValue);
      return quantity;
    } catch (NumberFormatException error) {
      System.out.println(
        "Could not parse a valid number for quantity" + "\n" +
        "Make sure your entries in your file are formatted 'X item at X.XX'"
      );
      System.exit(0);
      return BigDecimal.ZERO;
    }
  }

  private BigDecimal setPrice (String fieldValue) throws NumberFormatException {
    try {
      BigDecimal num = new BigDecimal(fieldValue);
      return num;
    } catch (NumberFormatException error) {
      System.out.println(
        "Could not parse a valid number for quantity" + "\n" +
        "Make sure your entries in your file are formatted 'X item at X.XX'"
      );
      System.exit(0);
      return BigDecimal.ZERO;
    }
  }
}
