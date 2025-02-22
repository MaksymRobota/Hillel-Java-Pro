package app.coffee.order_h7;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CoffeeOrderBoard {
    private final List<Order> orders = new LinkedList<>();
    private int nextOrder = 1;

    public void add(String name) {
        orders.add(new Order(nextOrder++, name));
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            throw new NoSuchElementException("No orders available to deliver.");
        }
        return orders.remove(0);
    }

    public Order deliver(int number) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getNumber() == number) {
                orders.remove(i);
                return order;
            }
        }
        throw new NoSuchElementException("Order with number " + number + " not found.");
    }

    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}