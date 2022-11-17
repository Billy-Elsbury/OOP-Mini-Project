package RestaurantTillSystem;

        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    JPanel homePanel;

    public HomePage() {
        setIconImage(new ImageIcon(this.getClass().getResource("IconImage.png")).getImage());
        setContentPane(homePanel);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setSize(900, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        //setIconImage(new ImageIcon(getClass().getResource("iconImage.png")).getImage());

    }

    public static void main(String[] args) {
        HomePage HomeFrame = new HomePage();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
