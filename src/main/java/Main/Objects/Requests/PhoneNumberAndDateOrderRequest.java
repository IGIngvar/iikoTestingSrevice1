package Main.Objects.Requests;

import java.util.Date;
import java.util.List;

public class PhoneNumberAndDateOrderRequest {

    String phone;
    String deliveryDateFrom;
    String deliveryDateTo;
    List<String> organizationIds;

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDeliveryDateFrom() {
        return deliveryDateFrom;
    }
    public void setDeliveryDateFrom(String deliveryDateFrom) {
        this.deliveryDateFrom = deliveryDateFrom;
    }
    public String getDeliveryDateTo() {
        return deliveryDateTo;
    }
    public void setDeliveryDateTo(String deliveryDateTo) {
        this.deliveryDateTo = deliveryDateTo;
    }
    public List<String> getOrganizationIds() {
        return organizationIds;
    }
    public void setOrganizationIds(List<String> organizationIds) {
        this.organizationIds = organizationIds;
    }
}
