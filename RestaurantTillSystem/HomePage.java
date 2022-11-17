package RestaurantTillSystem;

        import javax.swing.*;

public class HomePage extends JFrame{
    JPanel homePanel;
    JMenu MenuItems, Orders, Admin;

    public HomePage() {
        //Menu bar parameters

        //createMenuItemsMenu();


        setIconImage(new ImageIcon(this.getClass().getResource("IconImage.png")).getImage());
        setContentPane(homePanel);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setSize(900, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
