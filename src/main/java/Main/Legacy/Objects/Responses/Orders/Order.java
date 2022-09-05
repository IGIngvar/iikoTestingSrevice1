package Main.Objects.Responses.Orders;

import java.util.Date;
import java.util.List;

public class Order {

    String parentDeliveryId;
    Customer customer;
    String phone;
    DeliveryPoint deliveryPoint;
    Float sum;
    Float number;
    String sourceKey;
    String status;
    CancelInfo cancelInfo;
    CourierInfo courierInfo;
    Date completeBefore;
    Date whenCreated;
    Date whenConfirmed;
    Date whenPrinted;
    Date whenBillPrinted;
    Date whenSended;
    Date whenDelivered;
    Date whenClosed;
    String comment;
    Problem problem;
    Operator operator;
    Conception сonception;
    MarketingSource marketingSource;
    Float deliveryDuration;
    GuestsInfo guestsInfo;
    List<Item> items;
    List<Combo> combos;
    List<Payment> payments;
    List<Discount> discounts;
    OrderType orderType;
    float indexInCourierRoute;
    String terminalGroupId;

}
