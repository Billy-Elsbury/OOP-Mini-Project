package RestaurantTillSystem;

        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    JPanel homePanel;
    JFrame home;


    public HomePage() {
        home = new JFrame("Home Frame");
        home.setContentPane(homePanel);
        home.setTitle("Home Page");
        home.setLocationRelativeTo(null);
        home.setSize(900, 450);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        home.pack();
        home.setVisible(true);


        //setIconImage(new ImageIcon(getClass().getResource("iconImage.png")).getImage());

    }

    public static void main(String[] args) {
        HomePage HomeFrame = new HomePage();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
