package RestaurantTillSystem;

import java.io.*;

public class FoodItem implements Serializable {
    private String menuItemName;
    private String description;
    private double price;

    public FoodItem() {
        this("Name Unknown", "No Description", 0.0);
    }

    public FoodItem(String menuItemName, String description, double price) {
        setMenuItemName(menuItemName);
        setDescription(description);
        setPrice(price);
    }
    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getMenuItemName() {
        return this.menuItemName;
    }
    public String getDescription() {
        return this.description;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return String.format("Food Item Name: " + getMenuItemName() + "\nFood Description: " +getDescription() + "\nPrice: " + getPrice());
    }
}
