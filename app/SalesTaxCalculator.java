package app;

import app.exemptions.ExemptionChecker;
import app.files.*;
import app.interfaces.InputPrompt;
import app.products.*;
import app.taxes.*;

/**
 * @author Jeremy Salig
 * @version 1.0
 */

public class SalesTaxCalculator {
  public static void main(String[] args) {

    String userInput = InputPrompt.getInput();
    PurchaseOrder purchaseOrder = new PurchaseOrder(userInput);

    Cart cart = new Cart();

    for (String item : purchaseOrder.itemList) {
      Product product = new Product(item);
      ImportTax importTax = new ImportTax(product);
      SalesTax salesTax = new SalesTax(product);

      product.addTax(salesTax, importTax);
      cart.addToCart(product);
    }

    ReceiptWriter.generateReceipt(purchaseOrder, cart);
  }
}
