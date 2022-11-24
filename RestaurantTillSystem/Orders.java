package RestaurantTillSystem;

import java.io.Serializable;

public class Orders implements Serializable {

    String orderName;
    int orderID;

    public Orders(){
        this("Order does not exist",0);
    }

    public Orders(String orderName, int orderID) {
        setOrderName(orderName);
        setOrderID(orderID);
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Order Details: " +
                "OrderID'" + getOrderID() + '\'' +
                ", Order Name" + getOrderName();
    }
}
