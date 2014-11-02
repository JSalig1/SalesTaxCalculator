package app.files;

import app.products.*;

import java.io.*;
import org.apache.commons.io.FileUtils;

public class ReceiptWriter {

  public static void generateReceipt(PurchaseOrder purchaseOrder, Cart cart) {
    File receipt = makeReceipt(purchaseOrder);
    writeReciept(receipt, cart);
  }

  private static File makeReceipt(PurchaseOrder purchaseOrder) {
    File receipt = new File(purchaseOrder.name + "_receipt.txt");
    return receipt;
  }

  private static void writeReciept(File receipt, Cart cart) {
    try {
      FileUtils.writeLines(receipt, cart.contents);
      FileUtils.writeStringToFile(receipt, "Sales Taxes: " + cart.taxTotal + "\n", true);
      FileUtils.writeStringToFile(receipt, "Total: " + cart.total, true);
    } catch (IOException error) {
      System.out.println("Nothing to print out");
      return;
    }
  }
}
