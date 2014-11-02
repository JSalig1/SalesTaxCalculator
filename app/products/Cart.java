package app.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

  public List<String> contents;
  public BigDecimal taxTotal;
  public BigDecimal total;

  public Cart() {
    this.contents = new ArrayList<String>();
    this.taxTotal = BigDecimal.ZERO;
    this.total = BigDecimal.ZERO;
  }

  public void addToCart (Product product) {
    BigDecimal productTotal = product.pricePlusTax();
    this.contents.add(product.quantity + " " + product.description + " at " + productTotal);
    this.taxTotal = taxTotal.add(product.tax.multiply(product.quantity));
    this.total = total.add(productTotal.multiply(product.quantity));
  }
}
