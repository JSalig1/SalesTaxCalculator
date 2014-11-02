package app.taxes;

import app.products.Product;
import app.exemptions.ExemptionChecker;
import java.math.BigDecimal;

public class SalesTax {

  public BigDecimal value;

  private static BigDecimal ROUNDING_MODE = new BigDecimal("0.05");

  public SalesTax(Product product) {
    if (ExemptionChecker.checkForExemptions(product)) {
      this.value =  BigDecimal.ZERO;
    } else {
      BigDecimal taxRate = new BigDecimal("0.10");
      BigDecimal taxCalculation = product.price.multiply(taxRate);
      this.value = roundOff(taxCalculation);
    }
  }

  private BigDecimal roundOff (BigDecimal value) {
    value = value.divide(ROUNDING_MODE);
    value = new BigDecimal(Math.ceil(value.doubleValue()));
    value = value.multiply(ROUNDING_MODE);
    return value;
  }
}
