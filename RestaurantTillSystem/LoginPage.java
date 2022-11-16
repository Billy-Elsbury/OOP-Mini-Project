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
    private JLabel lbInput;
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
        login.setLocationRelativeTo(null);
        login.setSize(500, 500);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setVisible(false);

        String setLoginName = JOptionPane.showInputDialog("Please enter the name you wish to register as your login name",
                "JohnBrosnan");
        String setLoginPin = JOptionPane.showInputDialog("Please enter the pin you wish to register as your login name",
                "T00224562");

        lbLogin.setText("Valid details = Name: " + setLoginName + " Pin: " + setLoginPin);

        login.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //retrieve login information from file (reference Lab Sheet 15)
                File outFile = new File("loginDetails.txt");

                try {
                    FileOutputStream outputStream = new FileOutputStream(outFile);

                    ObjectOutputStream objectOutStream = new
                            ObjectOutputStream(outputStream);

                    objectOutStream.writeObject(setLoginName);

                    outputStream.close();

                } catch(FileNotFoundException fnfe){
                    System.out.println(fnfe.getStackTrace());
                    JOptionPane.showMessageDialog(null,"File could not be found!",
                            "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
                } catch(IOException ioe){ System.out.println(ioe.getStackTrace());
                    JOptionPane.showMessageDialog(null,"File could not be written!",
                            "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
                }


                File loginFile = new File("loginDetails.txt");

                try {
                    FileInputStream inputStream = new FileInputStream(loginFile);

                    ObjectInputStream objectInStream = new ObjectInputStream(inputStream);

                    System.out.println(objectInStream.readObject());

                    inputStream.close();

                } catch(FileNotFoundException fnfe){
                    fnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null,"File could not be found!",
                            "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
                } catch(IOException ioe){
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null,"File could not be read!",
                            "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Could not convert object to"
                            + " the appropriate class!","Problem Converting Object Read From File!",JOptionPane.ERROR_MESSAGE);

                } catch (ClassCastException cce) {
                    cce.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Could not convert the object to"
                        + "the appropriate class!","Problem Converting Object!",JOptionPane.ERROR_MESSAGE); }

                String loginName = tfName.getText();
                String pinCode = tfPinCode.getText();
                lbInput.setText("You inputted = Name: " + loginName
                        + " Pin: " + pinCode);

               if(loginName.equals(setLoginName)){
                System.out.println("Correct Login, Welcome");
                }
               else{
                   System.out.println("Incorrect Login, Please re-enter correct login details");
               }

                new HomePage();
                //homePage.setVisible(true);
                /*For some reason setting the homePage as visible creates
                another blank GUI window*/
                login.setVisible(false);
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
