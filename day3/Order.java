package day3;

public class Order implements Comparable<Order>{
    private int orderId;
    private String orderItem;
    private String custName;
    private String orderStatus;
    public Order() {}
    public Order(int orderId, String orderItem, String custName, String orderStatus) {
        this.orderId = orderId;
        this.orderItem = orderItem;
        this.custName = custName;
        this.orderStatus = orderStatus;
    }
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderItem=" + orderItem + ", custName=" + custName + ", orderStatus="
                + orderStatus + "]";
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getOrderItem() {
        return orderItem;
    }
    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Override
    public int compareTo(Order o) {
        return this.getCustName().compareTo(o.getCustName());
    }
}