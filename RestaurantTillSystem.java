import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantTillSystem extends JFrame{
    private JTextField tfName;
    private JTextField tfPinCode;
    private JButton btnLogin;
    private JButton btnClear;
    private JLabel lbLogin;
    private JPanel loginPanel;

    public RestaurantTillSystem() {
        setContentPane(loginPanel);
        setTitle("TillLogin");
        setLocationRelativeTo(null);
        setSize(900, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginName = tfName.getText();
                String pinCode = tfPinCode.getText();
                lbLogin.setText("Login " + loginName + " " + pinCode);
            }});

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfPinCode.setText("0000");
            }});
    }

    public static void main(String[] args) {
        RestaurantTillSystem LoginFrame = new RestaurantTillSystem();
    }

}
