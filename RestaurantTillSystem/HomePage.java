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
    private JLabel HomeImage;
    private JLabel dateLabel;
    private JTextArea menuArea;
    private JButton btnExit;
    JMenu menuItems, orders, admin, exit;
    JMenuItem item = null;

    ArrayList<FoodItem> foodMenuItems = new ArrayList();

    /*****************************************************
     * Gif Incorporation idea borrowed from Luke Foley T00224345
     * (Accessed 23 November 2022)
     * *****************************************************/
    private JLabel lblCatWave;

    FoodItem f1 = new FoodItem("Pizza", "Italian",12.50);

    ArrayList<FoodItem> allFoodItems = new ArrayList<>(Arrays.asList(f1));

    private FoodItem foodItem;

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
    public static void main(String[] args) {
        new HomePage();
    }

    public void addMenuItem() {

        String menuItemName;
        String description;
        int price;
        boolean valid = false;

        while (!valid) {
            try {
                menuItemName = JOptionPane.showInputDialog("Enter menu item's Name");
                description = JOptionPane.showInputDialog("Enter menu item's Description");
                price = Integer.parseInt(JOptionPane.showInputDialog("Enter menu item's Price"));

                try {
                    JOptionPane.showMessageDialog(null, "New Menu Item '" + menuItemName + "' has been added to the system");
                    FoodItem fi = new FoodItem(menuItemName, description, price);
                    allFoodItems.add(fi);
                    valid = true;


                } catch (NumberFormatException var10) {
                    JOptionPane.showMessageDialog((Component) null, "The price you entered is invalid, please enter valid price");
                }
            } catch (NullPointerException var11) {
                int choose = JOptionPane.showConfirmDialog((Component) null, "Field must not be empty. Do you want to continue?", "Confirmation", 0);
                if (choose != 0) {
                    break;
                }
            }
        }
        this.foodMenuItems.add(this.foodItem);
    }

    public void queryMenuItem(ArrayList<FoodItem>allFoodItems) {

            String FoodItemsString = "";
            FoodItem foodItem;

            Iterator<FoodItem> iterator = allFoodItems.iterator();

            while(iterator.hasNext())
            {
                foodItem = iterator.next();
                if (foodItem != null)
                    FoodItemsString += foodItem + "\n\n";

            }

           JOptionPane.showMessageDialog(null, FoodItemsString);
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
            queryMenuItem(allFoodItems);

            //Orders Menu Listeners
        else if (e.getActionCommand().equals("Place Order"))
            JOptionPane.showMessageDialog(null, "Place a new order into the till System",
                    "Place Order", JOptionPane.INFORMATION_MESSAGE);

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
            JOptionPane.showMessageDialog(null, "Perform revenue analysis",
                    " Revenue Analysis", JOptionPane.INFORMATION_MESSAGE);
    }
}
