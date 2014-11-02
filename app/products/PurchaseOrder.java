package app.products;

import app.files.FileParser;
import java.util.List;

public class PurchaseOrder {

  public String name;
  public List<String> itemList;

  public PurchaseOrder(String userInput) {
    this.name = userInput;
    this.itemList = FileParser.getItems(name);
  }
}
