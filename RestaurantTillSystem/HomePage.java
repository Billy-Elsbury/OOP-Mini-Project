package RestaurantTillSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    JPanel homePanel;
    JTextField tfName;
    JTextField tfPinCode;
    JButton btnLogin;
    JButton btnClear;
    JLabel lbLogin;
    JFrame home;
    JFrame showingFrame;


    public HomePage() {
        home = new JFrame("Home Frame");
        //UI2 ui2 = new UI2();
        //ui2.showingFrame = frame;
        //home.setContentPane(ui2.rootPanel);
        home.setContentPane(homePanel);
        home.setTitle("Home Page");
        home.setLocationRelativeTo(null);
        home.setSize(900, 450);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        home.pack();
        home.setVisible(true);


        //setIconImage(new ImageIcon(getClass().getResource("iconImage.png")).getImage());

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginName = tfName.getText();
                String pinCode = tfPinCode.getText();
                lbLogin.setText("Login: " + loginName + " " + pinCode);

            }});

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfPinCode.setText("");
            }});
    }

    public static void main(String[] args) {
        HomePage HomeFrame = new HomePage();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
