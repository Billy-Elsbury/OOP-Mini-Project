package RestaurantTillSystem;

public class MenuItem{
    private int menuItemID;
    private String menuItemName;
    private String description;
    private double price;

    public MenuItem() {
        this(0,"Name Unknown", "No Description", 0.0);
    }

    public MenuItem(int menuItemID, String menuItemName, String description, double price) {
        setMenuItemID(menuItemID);
        setMenuItemName(menuItemName);
        setDescription(description);
        setPrice(price);
    }
    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
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

    public int getMenuItemID() {
        return menuItemID;
    }
    public String getMenuItemName() {
        return menuItemName;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {

        return String.format("Food Item ID: " + getMenuItemID() + "\nFood Item Name: " + getMenuItemName() + "\nFood Description: " +getDescription() + "\nPrice: " + getPrice());
    }
}
