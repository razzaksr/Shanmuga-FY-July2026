package day4;

import java.util.List;
import java.util.stream.Collectors;

import day3.Order;

public class DemoMethodReference {
    public static void main(String[] args) {
        Order o1=new Order(101,"HP Pavilon","Karthick","Shipped");
        Order o2=new Order(901,"Sandisk SSD","Bhoomika","Delivered");
        Order o3=new Order(5454,"DJI Cam","Deepa","Returned");
        Order o4=new Order(97,"Sony Bravia","Venkat","Transist");
        List<Order> myOrders = List.of(o1,o2,o3,o4);
        List<String> items = myOrders.stream().
        map(Order::getOrderItem).
        collect(Collectors.toList());
        items.sort(String::compareTo);
        items.forEach(System.out::println);
    }
}
