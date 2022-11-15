package RestaurantTillSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame{
    JPanel loginPanel;
    JTextField tfName;
    JTextField tfPinCode;
    JButton btnLogin;
    JButton btnClear;
    JLabel lbLogin;
    JFrame login;


    public LoginPage() {
        login= new JFrame("Login Frame");
        login.setContentPane(loginPanel);
        login.setTitle("Till Login");
        login.setLocationRelativeTo(null);
        login.setSize(900, 450);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.pack();
        login.setVisible(true);


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
        LoginPage LoginFrame = new LoginPage();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
