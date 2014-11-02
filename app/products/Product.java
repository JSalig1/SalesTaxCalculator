package app.products;

import app.taxes.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {

  public BigDecimal quantity;
  public String description;
  public BigDecimal price;
  public BigDecimal tax;

  public Product(String item) {
    ArrayList<String> fields = extractFields(item);
    this.quantity = setQuantity(fields.get(0));
    this.description = fields.get(1);
    this.price = setPrice(fields.get(2));
    this.tax = BigDecimal.ZERO;
  }

  public void addTax (SalesTax salesTax, ImportTax importTax) {
    this.tax = salesTax.value.add(importTax.value);
  }

  public BigDecimal pricePlusTax() {
    BigDecimal pricePlusTax = price.add(tax);
    return pricePlusTax;
  }

  private ArrayList<String> extractFields (String item) {
    ArrayList<String> parts = new ArrayList<String>();
    String[] sliceQuanity = item.split(" ", 2);
    parts.add(sliceQuanity[0]);
    String[] slicePrice = sliceQuanity[1].split(" at ");
    parts.add(slicePrice[0]);
    parts.add(slicePrice[1]);
    return parts;
  }

  private BigDecimal setQuantity (String fieldValue) {
    BigDecimal quantity = new BigDecimal(fieldValue);
    return quantity;
  }

  private BigDecimal setPrice (String fieldValue) throws NumberFormatException {
    try {
      BigDecimal num = new BigDecimal(fieldValue);
      return num;
    } catch (NumberFormatException error) {
      System.out.println("Could not parse a valid number for price");
      System.exit(0);
      return BigDecimal.ZERO;
    }
  }
}
