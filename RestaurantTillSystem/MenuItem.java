package RestaurantTillSystem;

//MenuItem.java

/**
 * Java Documentation referenced from Lab sheet 17
 * */


/**
 * An instantiable class which defines a Menu Item,
 * to be used in the AddMenuItem function within HomePage.java.
 * @author Billy Elsbury
 * */

public class MenuItem{
    private int menuItemID;
    private String menuItemName;
    private String description;
    private double price;
    private static int count;


    /**
     * MenuItem no-argument constructor. Calls the 4-argument MenuItem constructor to initialise the
     * attributes of a MenuItem object with some default initial values, to leave the MenuItem
     * object in a consistent initial state
     * */
    public MenuItem() {
        this(0,"Name Unknown", "No Description", 0.0);
    }


    /** * MenuItem 4-argument constructor. Calls the 4 mutators to
     * initialise the attributes of a MenuItem object with some user-supplied values. The MenuItem ID is
     * set internally using the value of the count attribute, to ensure unique MenuItem ID values.
     * @param menuItemID the ID number of the book
     * @param menuItemName the name of the book
     * @param description the description of the book
     * @param price the price of the Menu Item */

    public MenuItem(int menuItemID, String menuItemName, String description, double price) {
        setMenuItemName(menuItemName);
        setDescription(description);
        setPrice(price);
        incrementCount();
        setMenuItemID(count);
    }


    /**
     * Method to increment the static count attribute of the class, this is to ensure that every
     * MenuItem object will have a unique ID value, as it tracks the value of this attribute
     * */
    private static void incrementCount() {
        count++;
    }


    /**
     * Method to set the ID of a menuItem object
     * @param menuItemID the ID number of the menuItem
     * */
    private void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }


    /**
     * Method to set the name of a menuItem object
     * @param menuItemName the name of the menuItem
     * @throws IllegalArgumentException In the case of an invalid name */
    public void setMenuItemName(String menuItemName) {

        if(menuItemName==null || menuItemName.equals(""))
            throw new IllegalArgumentException("The Menu Item name cannot be null\n");

        this.menuItemName = menuItemName;
    }



    /**
     * Method to set the description of a menuItem object
     * @param description the description of the menuItem
     * */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Method to set the price of a Book object
     * @param price the price of the Book
     * @throws IllegalArgumentException In the case of an invalid price
     * */
    public void setPrice(double price) {
        if(price<0)
            throw new IllegalArgumentException("The menuItem price must be a positive number\n");

        this.price = price;
    }


    /**
     * Method to get the ID of a MenuItem object
     * @return an integer value specifying the ID of a MenuItem object
     * */
    public int getMenuItemID() {
        return menuItemID;
    }


    /**
     * Method to get the name of a MenuItem object
     * @return a String value specifying the name of a MenuItem object
     * */
    public String getMenuItemName() {
        return menuItemName;
    }


    /**
     * Method to get the description of a MenuItem object
     * @return a String value specifying the description of a MenuItem object
     * */
    public String getDescription() {
        return description;
    }


    /**
     * Method to get the price of a menuItem object
     * @return a double value specifying the price of a menuItem object
     * */
    public double getPrice() {
        return price;
    }


    /**
     * Method to get the state of a Book object
     * @return a String value specifying the state of a Book object
     * */
    public String toString() {

        return String.format("Food Item ID: " + getMenuItemID() + "\nFood Item Name: " + getMenuItemName() + "\nFood Description: " +getDescription() + "\nPrice: " + getPrice());
    }
}
