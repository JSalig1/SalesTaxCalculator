package app.taxes;

import app.products.Product;
import java.math.BigDecimal;

public class ImportTax {

  public BigDecimal value;

  private static BigDecimal ROUNDING_MODE = new BigDecimal("0.05");

  public ImportTax(Product product) {
    if (product.description.contains("imported")) {
      BigDecimal taxRate = new BigDecimal("0.05");
      BigDecimal taxCalculation = product.price.multiply(taxRate);
      this.value = roundOff(taxCalculation);
    } else {
      this.value = BigDecimal.ZERO;
    }
  }

  private BigDecimal roundOff (BigDecimal value) {
    value = value.divide(ROUNDING_MODE);
    value = new BigDecimal(Math.ceil(value.doubleValue()));
    value = value.multiply(ROUNDING_MODE);
    return value;
  }
}
