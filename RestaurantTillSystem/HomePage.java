package RestaurantTillSystem;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
    JPanel homePanel;
    JMenu menuItems, orders, admin;
    JMenuItem item = null;

    public HomePage() {
        //Menu bar parameters
        createMenuItemsMenu();
        createOrdersMenu();
        createAdminMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.LIGHT_GRAY);
        menuBar.add(menuItems);
        menuBar.add(orders);
        menuBar.add(admin);

        //"try" to set the Icon image and "catch" a
        try {
            setIconImage(new ImageIcon(this.getClass().getResource("IconImage.png")).getImage());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog((Component)null, "Icon Image not found or invalid");
        }

        //Other menu bar parameters
        setContentPane(homePanel);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setSize(900, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Reference LabSheet14
    private void createMenuItemsMenu() {

        menuItems = new JMenu("Menu Items");

        String itemNames[] = {"Add Item","Edit Item","Remove Item","Query Item"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            menuItems.addSeparator();
            menuItems.add(item);
        }
    }

    private void createOrdersMenu() {

        orders = new JMenu("Orders Menu");

        String itemNames[] = {"Place Order","Edit Order","Cancel Order","Pay Bill"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            orders.addSeparator();
            orders.add(item);
        }
    }

    private void createAdminMenu() {

        admin = new JMenu("Admin Functions");

        String itemNames[] = {"Item Analysis","Revenue Analysis"};

        for(int i=0;i<itemNames.length;i++){
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

    @Override
    public void actionPerformed(ActionEvent e) {

        //Menu Items Menu Listeners
        if(e.getActionCommand().equals("Add Item"))
            JOptionPane.showMessageDialog(null,"Adding a new Item to the menu",
                    "New Menu Item",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Edit Item"))
            JOptionPane.showMessageDialog(null,"Editing an existing menu Item",
                    "Edit Menu Item",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Remove Item"))
            JOptionPane.showMessageDialog(null,"Removing an existing menu Item",
                    "Remove Menu Item",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Query Item"))
            JOptionPane.showMessageDialog(null, "Querying an existing menu Item",
                    "Query Menu Item", JOptionPane.INFORMATION_MESSAGE);

        //Orders Menu Listeners
        else if(e.getActionCommand().equals("Place Order"))
            JOptionPane.showMessageDialog(null,"Place a new order into the till System",
                    "Place Order",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Edit Order"))
            JOptionPane.showMessageDialog(null,"Edit an existing Order",
                    "Edit Order",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Cancel Order"))
            JOptionPane.showMessageDialog(null,"Cancel an existing Order",
                    "Cancel Order",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Pay Bill"))
            JOptionPane.showMessageDialog(null, "Pay a bill and close an Order",
                    "Pay Bill", JOptionPane.INFORMATION_MESSAGE);

        //Admin Menu Listeners
        else if(e.getActionCommand().equals("Item Analysis"))
            JOptionPane.showMessageDialog(null,"Perform analysis on a menu Item",
                    "Item Analysis",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Revenue Analysis"))
            JOptionPane.showMessageDialog(null, "Perform revenue analysis",
                    "Revenue Analysis", JOptionPane.INFORMATION_MESSAGE);
    }
}
