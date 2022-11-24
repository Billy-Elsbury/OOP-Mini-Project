package RestaurantTillSystem;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
        import java.util.*;
        import java.util.List;

public class HomePage extends JFrame implements ActionListener {
    JPanel homePanel;
    JLabel HomeImage;
    JLabel dateLabel;
    JTextArea menuArea;
    JButton btnExit;
    JMenu menuItems, orders, admin;
    JMenuItem item = null;

    /****************************************************
     * Gif Incorporation idea borrowed from Luke Foley T00224345
     * Gif obtained from https://tenor.com/en-GB/view/peach-cat-mochi-mochi-hello-waving-box-gif-15495759
     * (Accessed 23 November 2022)
     ******************************************************/
    private JLabel lblCatWave;
    private ImageIcon catWave2;
    int menuItemID = 1;

    MenuItem firstMenuItem = new MenuItem(menuItemID, "Pizza", "Italian",12.50);

    ArrayList<MenuItem> allMenuItems = new ArrayList<>(List.of(firstMenuItem));

    public HomePage() {
        //Menu bar main parameters
        createMenuItemsMenu();
        createOrdersMenu();
        createAdminMenu();
        Clock();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.LIGHT_GRAY);
        menuBar.add(menuItems);
        menuBar.add(orders);
        menuBar.add(admin);
        menuArea.setSize(100, 50);
        menuArea.setText("");

        /*****************************************************
         * Icon image obtained from
         * Site: https://icon-icons.com
         * (Accessed 16 November 2022)
         * *****************************************************/
        /*"try" to set the Icon image and "catch" the exception if image does not exist
        or is not where it is expected to be */
        try {
            setIconImage(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("IconImage.png"))).getImage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Icon Image not found or invalid");
        }

        //Other menu bar parameters
        setContentPane(homePanel);
        setTitle("Home Page");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        HomeImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /****************************************************
                 * Custom JOptionDialog code created referencing:
                 * Site: https://stackoverflow.com/questions/32062761
                 * (Accessed 23 November 2022)
                 * ****************************************************/

                Object[] buttons = {"Exit", "Cancel", "Return to login page"};

                int choice = JOptionPane.showOptionDialog(btnExit,
                        "Are you sure you wish to exit?", "Exit System",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, buttons,  buttons[0]);

                if (choice == 0){
                System.exit(0);
                }
                else if (choice ==2){
                    //show LoginPage (Already set as visible)
                    new LoginPage();
                    //hide HomePage
                    setVisible(false);
                }
            }
        });

        lblCatWave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,"You Killed a cat!?!!?");
                    catWave2 = new ImageIcon("catWave2.gif");
                    lblCatWave.setIcon(catWave2);

            }
        });

    }

    /*****************************************************
     * Clock code taken entirely from RestaurantSystem.jar in LECTURER JohnBrosnan\ObjectOrientatedProgramming\MiniProjectStuff\SomeOldYear2MiniProjects
     * and only edited a minor amount to work with this system.
     * https://ittralee-my.sharepoint.com/:u:/r/personal/lt00036791_365s_ittralee_ie/Documents/Object%20Oriented%20Programming/MiniProjectStuff/SomeOldYear2MiniProjects/RestaurantSystem.jar?csf=1&web=1&e=VprIHW
     * (Accessed 22 November 2022)
     * *****************************************************/
    public void Clock() {
        Thread clock = new Thread(() -> {
            try {
                while (true) {
                    Calendar cld = new GregorianCalendar();
                    int day = cld.get(Calendar.DAY_OF_MONTH);
                    int month = cld.get(Calendar.MONTH) + 1;
                    int year = cld.get(Calendar.YEAR);
                    int sec = cld.get(Calendar.SECOND);
                    int min = cld.get(Calendar.MINUTE);
                    int hour = cld.get(Calendar.HOUR);
                    HomePage.this.dateLabel.setText(day + "/" + month + "/" + year + "  " + hour + ":" + min + ":" + sec);
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException var8) {
                var8.printStackTrace();
            }
        });
        clock.start();
    }

    //Create Menus using altered code from LabSheet14
    private void createMenuItemsMenu() {

        menuItems = new JMenu("Menu Items");

        String[] itemNames = {"Add Item", "Edit Item", "Remove Item", "Query Item"};

        for (String itemName : itemNames) {
            item = new JMenuItem(itemName);
            item.addActionListener(this);

            menuItems.addSeparator();
            menuItems.add(item);
        }
    }

    private void createOrdersMenu() {

        orders = new JMenu("Orders Menu");

        String[] itemNames = {"Place Order", "Edit Order", "Cancel Order", "Pay Bill", "View Orders"};

        for (String itemName : itemNames) {
            item = new JMenuItem(itemName);
            item.addActionListener(this);

            orders.addSeparator();
            orders.add(item);
        }
    }

    private void createAdminMenu() {

        admin = new JMenu("Admin Functions");

        String[] itemNames = {"Item Analysis", "Revenue Analysis"};

        for (String itemName : itemNames) {
            item = new JMenuItem(itemName);
            item.addActionListener(this);

            admin.addSeparator();
            admin.add(item);
        }
    }

    //Only used to run the HomePage on its own
    public static void main(String[] args) {new HomePage();}

    public void addMenuItem() {

        boolean valid = false;

        //catch statements not working correctly.
        while (!valid) {
            try {
                menuItemID = 2;

                String menuItemName = JOptionPane.showInputDialog("Enter menu item's Name");
                String description = JOptionPane.showInputDialog("Enter menu item's Description");
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter menu item's Price"));

                JOptionPane.showMessageDialog(null, "New Menu Item '" + menuItemName + "' has been added to the system");
                MenuItem menuItem = new MenuItem(menuItemID, menuItemName, description, price);
                allMenuItems.add(menuItem);
                valid = true;

            }
                catch (NumberFormatException numberFormatException) {
                int input = JOptionPane.showConfirmDialog(null, "Price must be a valid number, Would you like to exit?", "Error!", JOptionPane.YES_NO_OPTION);
                if (input == 0){
                    break;
                }
            }
        }
    }

    public void queryMenuItem(ArrayList<MenuItem> allMenuItems) {

            StringBuilder menuItemsString = new StringBuilder();
            MenuItem menuItem;

        for (MenuItem allMenuItem : allMenuItems) {
            menuItem = allMenuItem;
            if (menuItem != null)
                menuItemsString.append(menuItem).append("\n\n");

        }

           JOptionPane.showMessageDialog(null, menuItemsString.toString());

            menuArea.setText(""+menuItemsString);
        }

        public void placeOrder(ArrayList<MenuItem> allMenuItems) {

            boolean valid = false;

            while (!valid) {

                StringBuilder ordersAsString = new StringBuilder();
                MenuItem menuItem;
                String selectedOrderIDasString;
                int selectedOrderID;

                for (MenuItem allMenuItem : allMenuItems) {
                    menuItem = allMenuItem;
                    if (menuItem != null) {
                        ordersAsString.append(menuItem).append("\n\n");
                    }
                }
                    selectedOrderIDasString = JOptionPane.showInputDialog(null, "Please select which menu item to add to new order: \n\n" + ordersAsString);

                    try {
                        selectedOrderID = Integer.parseInt(selectedOrderIDasString);
                        valid = true;

                        JOptionPane.showMessageDialog(null,"Order "+ selectedOrderID +" added to order list");
                    }
                    catch (NumberFormatException numberFormatException) {
                        int input = JOptionPane.showConfirmDialog(null, "Order ID must be a ID number, Would you like to exit?", "Error!", JOptionPane.YES_NO_OPTION);
                        if (input == 0) {
                            break;
                        }
                    }

            }
        }

    public void dineAndDashMiniGame() {

        boolean valid = false;

        //catch statements not working correctly.
        while (!valid) {
            try {
                int choice = Integer.parseInt(JOptionPane.showInputDialog("So you're a dine and dasher? Let's see if the chances are in your favour \n\n choose a number between 1 and 3 to attempt a dine and dash"));

                //generate random values from 0-3
                Random random = new Random();
                int maxValue = 3;
                int randomNumber = random.nextInt(maxValue) +1;

                JOptionPane.showMessageDialog(null,"Random number is: " + randomNumber + "\nYou chose: " + choice);

                if(choice == randomNumber) {
                    JOptionPane.showMessageDialog(null, """
                            CONGRATULATIONS!, You left without paying!
                            Instead you payed with your self respect
                            A small price to pay for a free meal?""");
                }
                else{
                    JOptionPane.showMessageDialog(null, """
                            STOP, You got caught attempting to leave without paying,
                            Perhaps you're not as sneaky as you thought you were?

                            Now you get to pay for your food and spend a night in jail!""");
                    new Jail();
                    dispose();
                }
                valid = true;

            }
            catch (NumberFormatException numberFormatException) {
                int input = JOptionPane.showConfirmDialog(null, "Must be a valid must be a valid number between 1 and 4, Would you like to exit?", "Error!", JOptionPane.YES_NO_OPTION);
                if (input == 0){
                    break;
                }
            }
        }
        }

    public void performRevenueAnalysis() {
        AdminDatabaseFunctions performRevenueAnalysis = new AdminDatabaseFunctions();
        performRevenueAnalysis.RetrieveFromDatabase();
        System.out.print("Database maybe worked?");
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //Menu Items Menu Listeners
        if (e.getActionCommand().equals("Add Item")) {
            addMenuItem();
        }

        else if (e.getActionCommand().equals("Edit Item"))
            JOptionPane.showMessageDialog(null, "Editing an existing menu Item",
                    "Edit Menu Item", JOptionPane.INFORMATION_MESSAGE);

        else if (e.getActionCommand().equals("Remove Item"))
            JOptionPane.showMessageDialog(null, "Removing an existing menu Item",
                    "Remove Menu Item", JOptionPane.INFORMATION_MESSAGE);

        else if (e.getActionCommand().equals("Query Item"))
            queryMenuItem(allMenuItems);

        //Orders Menu Listeners
        else if (e.getActionCommand().equals("Place Order")) {
            placeOrder(allMenuItems);
        }

        else if (e.getActionCommand().equals("Edit Order"))
            JOptionPane.showMessageDialog(null, "Edit an existing Order function unavailable",
                    "Edit Order", JOptionPane.INFORMATION_MESSAGE);

        else if (e.getActionCommand().equals("Cancel Order"))
            JOptionPane.showMessageDialog(null, "Cancel Order function unavailable",
                    "Cancel Order", JOptionPane.INFORMATION_MESSAGE);

        else if (e.getActionCommand().equals("Pay Bill")) {
            String[] options = new String[2];
            options[0] = "Pay Bill";
            options[1] = "Attempt Dine and Dash";
            int chosenOption = JOptionPane.showOptionDialog(null, "Pay a bill and close an Order",
                    "Pay Bill", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);

            if(chosenOption == 0)
                JOptionPane.showMessageDialog(null,"Bill payed successfully, Goodbye!");

            else if(chosenOption == 1)
                dineAndDashMiniGame();
        }

        else if (e.getActionCommand().equals("View Orders")) {
            JOptionPane.showMessageDialog(null, "View an existing Order function unavailable",
                    "View Order", JOptionPane.INFORMATION_MESSAGE);
        }


        //Admin Menu Listeners
        else if(e.getActionCommand().equals("Item Analysis"))
            JOptionPane.showMessageDialog(null,"Perform analysis on a menu Item",
                    " Item Analysis",JOptionPane.INFORMATION_MESSAGE);

        else if(e.getActionCommand().equals("Revenue Analysis"))
            performRevenueAnalysis();
    }
}



