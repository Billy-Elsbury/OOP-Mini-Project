package RestaurantTillSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoginPage extends JFrame{
    JPanel loginPanel;
    JTextField tfName;
    JTextField tfPinCode;
    JButton btnLogin;
    JButton btnClear;
    JLabel lbLogin;
    private JButton btnExit;
    JFrame login;


    public LoginPage(){
        login = new JFrame("Login Frame");

        /*****************************************************
         * Icon image obtained from
         * Site: https://icon-icons.com
         * (Accessed 16 November 2022)
         * *****************************************************/

        login.setIconImage(new ImageIcon(this.getClass().getResource("loginIconImage.png")).getImage());
        login.setContentPane(loginPanel);
        login.setTitle("Till Login");
        lbLogin.setText("Valid details = Name: BillyElsbury Pin: T00224562");
        login.setLocationRelativeTo(null);
        login.setSize(500, 500);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.pack();
        login.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //retrieve login information from file
                File outputFile = new File("loginDetails.txt");

                try {

                    FileOutputStream outputStream = new FileOutputStream(outputFile);

                    String loginDetails = "BillyElsbury T00224562";

                    ObjectOutputStream objectOutStream = new
                            ObjectOutputStream(outputStream);

                    outputStream.close();

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                File loginFile = new File("loginDetails.txt");

                try {
                    FileInputStream inputStream = new FileInputStream(loginFile);

                    ObjectInputStream stringInSteam = new ObjectInputStream(inputStream);

                    String loginDetails = "BillyElsbury";

                    System.out.println(loginDetails);

                    inputStream.close();

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String loginName = tfName.getText();
                String pinCode = tfPinCode.getText();
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                login.setVisible(true);
            }});

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfPinCode.setText("");
            }});

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        LoginPage LoginFrame = new LoginPage();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
