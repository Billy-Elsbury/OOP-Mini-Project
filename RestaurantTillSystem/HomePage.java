package RestaurantTillSystem;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
        import java.io.*;
        import java.util.ArrayList;

public class HomePage extends JFrame implements ActionListener {
    JPanel homePanel;
    private JLabel HomeImage;
    JMenu menuItems, orders, admin;
    JMenuItem item = null;

    public HomePage() {
        //Menu bar main parameters
        createMenuItemsMenu();
        createOrdersMenu();
        createAdminMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.LIGHT_GRAY);
        menuBar.add(menuItems);
        menuBar.add(orders);
        menuBar.add(admin);

        /*"try" to set the Icon image and "catch" the exception if image does not exist
        or is not where it is expected to be */
        try {
            setIconImage(new ImageIcon(this.getClass().getResource("IconImage.png")).getImage());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Icon Image not found or invalid");
        }

        //Other menu bar parameters
        setContentPane(homePanel);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setSize(900, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        HomeImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    //Create MenuBar using altered code from LabSheet14
    private void createMenuItemsMenu() {

        menuItems = new JMenu("Menu Items");

        String[] itemNames = {"Add Item","Edit Item","Remove Item","Query Item"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            menuItems.addSeparator();
            menuItems.add(item);
        }
    }

    private void createOrdersMenu() {

        orders = new JMenu("Orders Menu");

        String[] itemNames = {"Place Order","Edit Order","Cancel Order","Pay Bill","View Orders"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            orders.addSeparator();
            orders.add(item);
        }
    }

    private void createAdminMenu() {

        admin = new JMenu("Admin Functions");

        String[] itemNames = {"Item Analysis","Revenue Analysis"};

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

        else if(e.getActionCommand().equals("View Orders")) {

            //make new file for order info(code altered from Lab Sheet 15)
            File outFile = new File("orderDetails.txt");

            try {
                FileOutputStream outputStream = new FileOutputStream(outFile);

                Orders order1 = new Orders("Billy's Order", 1);
                Orders order2 = new Orders("John's Order",2);

                ObjectOutputStream objectOutStream = new ObjectOutputStream(outputStream);

                objectOutStream.writeObject(order1);
                objectOutStream.writeObject(order2);

                outputStream.close();

            } catch(FileNotFoundException fnfe){
                System.out.println(fnfe.getStackTrace());
                JOptionPane.showMessageDialog(null,"Orders file could not be found!",
                        "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
            } catch(IOException ioe){ System.out.println(ioe.getStackTrace());
                JOptionPane.showMessageDialog(null,"Orders file could not be written!",
                        "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
            }

            File orderFile = new File("orderDetails.txt");

            try {
                FileInputStream inputStream = new FileInputStream(orderFile);

                ObjectInputStream objectInStream = new ObjectInputStream(inputStream);

                Orders order1 = (Orders) objectInStream.readObject();
                Orders order2 = (Orders) objectInStream.readObject();

                JOptionPane.showMessageDialog(null, "State of Order objects " +
                                "read from the file are:\n\n" + order1 + "\n" +
                                order2, "", JOptionPane.INFORMATION_MESSAGE);

                inputStream.close();

            } catch(FileNotFoundException fnfe){
                fnfe.printStackTrace();
                JOptionPane.showMessageDialog(null,"File could not be found!",
                        " Problem Finding File!", JOptionPane.ERROR_MESSAGE);
            } catch(IOException ioe){
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null,"File could not be read!",
                        " Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null,"Could not convert object to"
                        + " the appropriate class!","Problem Converting Object Read From File!",JOptionPane.ERROR_MESSAGE);

            } catch (ClassCastException cce) {
                cce.printStackTrace();
                JOptionPane.showMessageDialog(null,"Could not convert the object to"
                        + " the appropriate class!","Problem Converting Object!",JOptionPane.ERROR_MESSAGE); }
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
