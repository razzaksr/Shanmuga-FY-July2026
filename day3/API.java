package day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class API {
    private static List<Order> orders=new ArrayList<>();
    public static void main(String[] args) {
        Order o1=new Order(101,"HP Pavilon","Karthick","Shipped");
        Order o2=new Order(901,"Sandisk SSD","Bhoomika","Delivered");
        Order o3=new Order(5454,"DJI Cam","Deepa","Returned");
        Order o4=new Order(97,"Sony Bravia","Venkat","Transist");
        orders.add(o1);orders.add(o2);orders.add(o3);
        orders.add(o4);
        // Collections.sort(orders);
        // Collections.sort(orders,(a,b)->a.getOrderId()-b.getOrderId());
        System.out.println(orders);
        // Collections.sort(orders,(a,b)->b.getOrderItem().compareTo(a.getOrderItem()));
        // System.out.println(orders);
        o1.setOrderStatus("Out for Delivery");
        orders.set(0,o1);
        System.out.println(orders);
        orders.remove(3);
        orders.remove(o2);
        System.out.println(orders);
    }    
}
