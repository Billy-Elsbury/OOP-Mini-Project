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
        this.menuItemName = menuItemName;
        this.description = description;
        this.price = price;
    }
    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double Price) {
        this.price = this.price;
    }

    public String getMenuItemName() {
        return this.menuItemName;
    }
    public String getDescription() {
        return this.description;
    }
    public double getPrice() {
        return this.price;
    }
    public String toString() {
        return String.format("Category: %s\nFoodType: %s\nDescription: %s\nPrice: \n",getMenuItemName(), getDescription(), getPrice());
    }
}
