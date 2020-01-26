package Main.Objects.Responses.Orders;

import java.util.Date;
import java.util.List;

public class Item {

    Product product;
    List<Modifiers> modifiers;
    float price;
    float cost;
    boolean pricePredefined;
    String status;
    Deleted deleted;
    float amount;
    String comment;
    Date whenPrinted;
    Size size;
    ComboInformation comboInformation;
    String positionId;
    String texPercent;

}
