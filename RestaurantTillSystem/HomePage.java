package RestaurantTillSystem;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
        import java.util.*;

public class HomePage extends JFrame implements ActionListener {
    JPanel homePanel;
    JLabel HomeImage;
    JLabel dateLabel;
    JTextArea menuArea;
    JButton btnExit;
    JMenu menuItems, orders, admin;
    JMenuItem item = null;

    /*****************************************************
     * Gif Incorporation idea borrowed from Luke Foley T00224345
     *
     * Gif obtained from https://tenor.com/en-GB/view/peach-cat-mochi-mochi-hello-waving-box-gif-15495759
     * (Accessed 23 November 2022)
     * *****************************************************/
    private JLabel lblCatWave;
    private MenuItem menuItem;
    int menuItemID = 1;

    MenuItem firstMenuItem = new MenuItem(menuItemID, "Pizza", "Italian",12.50);

    ArrayList<MenuItem> allMenuItems = new ArrayList<>(Arrays.asList(firstMenuItem));

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
            setIconImage(new ImageIcon(this.getClass().getResource("IconImage.png")).getImage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Icon Image not found or invalid");
        }

        //Other menu bar parameters
        setContentPane(homePanel);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setSize(800, 500);
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

                /*****************************************************
                 * Custom JOptionDialog code created referencing:
                 * Site: https://stackoverflow.com/questions/32062761
                 * (Accessed 23 November 2022)
                 * *****************************************************/

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

        for (int i = 0; i < itemNames.length; i++) {
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            menuItems.addSeparator();
            menuItems.add(item);
        }
    }

    private void createOrdersMenu() {

        orders = new JMenu("Orders Menu");

        String[] itemNames = {"Place Order", "Edit Order", "Cancel Order", "Pay Bill", "View Orders"};

        for (int i = 0; i < itemNames.length; i++) {
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            orders.addSeparator();
            orders.add(item);
        }
    }

    private void createAdminMenu() {

        admin = new JMenu("Admin Functions");

        String[] itemNames = {"Item Analysis", "Revenue Analysis"};

        for (int i = 0; i < itemNames.length; i++) {
            item = new JMenuItem(itemNames[i]);
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
                int input = JOptionPane.showConfirmDialog(null, "Price must be a valid number, Would you like to exit?", "Error!",0);
                if (input == 0){
                    break;
                }
            }
        }
    }

    public void queryMenuItem(ArrayList<MenuItem> allMenuItems) {

            String menuItemsString = "";
            MenuItem menuItem;

            Iterator<MenuItem> iterator = allMenuItems.iterator();

            while(iterator.hasNext())
            {
                menuItem = iterator.next();
                if (menuItem != null)
                    menuItemsString += menuItem + "\n\n";

            }

           JOptionPane.showMessageDialog(null, menuItemsString);

            menuArea.setText(""+menuItemsString);
        }

        public void placeOrder(ArrayList<MenuItem> allMenuItems) {

            boolean valid = false;

            while (!valid) {

                String ordersAsString = "";
                MenuItem menuItem;
                String selectedOrderIDasString;
                int selectedOrderID;

                Iterator<MenuItem> iterator = allMenuItems.iterator();

                while (iterator.hasNext()) {
                    menuItem = iterator.next();
                    if (menuItem != null) {
                        ordersAsString += menuItem + "\n\n";
                    }
                }
                    selectedOrderIDasString = JOptionPane.showInputDialog(null, "Please select which menu item to add to new order: \n\n" + ordersAsString);

                    try {
                        selectedOrderID = Integer.parseInt(selectedOrderIDasString);
                        valid = true;

                        //selectedOrderID

                        JOptionPane.showMessageDialog(null,"Order added to order list");
                    }
                    catch (NumberFormatException numberFormatException) {
                        int input = JOptionPane.showConfirmDialog(null, "Order ID must be a ID number, Would you like to exit?", "Error!", 0);
                        if (input == 0) {
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
            JOptionPane.showMessageDialog(null, "Edit an existing Order",
                    "Edit Order", JOptionPane.INFORMATION_MESSAGE);

        else if (e.getActionCommand().equals("Cancel Order"))
            JOptionPane.showMessageDialog(null, "Cancel an existing Order",
                    "Cancel Order", JOptionPane.INFORMATION_MESSAGE);

        else if (e.getActionCommand().equals("Pay Bill"))
            JOptionPane.showMessageDialog(null, "Pay a bill and close an Order",
                    "Pay Bill", JOptionPane.INFORMATION_MESSAGE);

        else if (e.getActionCommand().equals("View Orders")) {
            JOptionPane.showMessageDialog(null, "View existing orders",
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



