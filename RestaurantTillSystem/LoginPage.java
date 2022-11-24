package RestaurantTillSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LoginPage extends JFrame{
    JPanel loginPanel;
    JTextField tfName;
    JPasswordField tfPinCode;
    JButton btnLogin;
    JButton btnClear;
    JLabel lbLogin;
    JButton btnExit;
    JLabel lbInput;
    private JLabel Image;
    private JButton addNewLoginButton;
    ArrayList<Object> mixtureOfObjects = new ArrayList<>();
    File outFile = new File("loginDetails.txt");

    public LoginPage(){

        /*****************************************************
         * Icon image obtained from
         * Site: https://icon-icons.com
         * (Accessed 16 November 2022)
         * *****************************************************/
        setIconImage(new ImageIcon(this.getClass().getResource("loginIconImage.png")).getImage());

        setContentPane(loginPanel);
        setTitle("Till Login");
        setLocationRelativeTo(null);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);

        String setLoginName = JOptionPane.showInputDialog("Please enter the name you wish to register as your login name",
                "JoeBloggs");
        String setLoginPin = JOptionPane.showInputDialog("Please enter the pin you wish to register as your login name",
                "420420");

        lbLogin.setText("Newly Registered login details = Name: " + setLoginName + " Pin: " + setLoginPin);

        setVisible(true);


        //serialization code altered from Lab Sheet 15

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    try {

                        File loginFile = new File("loginDetails.txt");

                        FileInputStream inputStream = new FileInputStream(loginFile);

                        ObjectInputStream objectInStream = new ObjectInputStream(inputStream);

                        mixtureOfObjects = (ArrayList<Object>) objectInStream.readObject();


                        if(!mixtureOfObjects.contains("BillyElsbury")) {

                            FileOutputStream outputStream = new FileOutputStream(outFile);
                            ObjectOutputStream objectOutStream = new ObjectOutputStream(outputStream);

                            mixtureOfObjects.add("BillyElsbury");
                            mixtureOfObjects.add("JohnBrosnan");
                            mixtureOfObjects.add("LukeFoley");
                            mixtureOfObjects.add("DarraghQuinn");

                            objectOutStream.writeObject(mixtureOfObjects);

                            outputStream.close();
                        }

                    } catch (FileNotFoundException fnfe) {
                        System.out.println(fnfe.getStackTrace());
                        JOptionPane.showMessageDialog(null, "File could not be found!",
                                "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ioe) {
                        System.out.println(ioe.getStackTrace());
                        JOptionPane.showMessageDialog(null, "File could not be written!",
                                "Problem Writing to File!", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);

                }

                //serialization code altered from Lab Sheet 15

                StringBuilder objectMixture = null;
                try {
                    File loginFile = new File("loginDetails.txt");

                    FileInputStream inputStream = new FileInputStream(loginFile);

                    ObjectInputStream objectInStream = new ObjectInputStream(inputStream);

                    mixtureOfObjects = (ArrayList<Object>) objectInStream.readObject();

                    objectMixture = new StringBuilder();

                    for (Object x : mixtureOfObjects) {
                        objectMixture.append(x).append("\n");
                    }

                    inputStream.close();


                } catch (FileNotFoundException fnfe) {
                    fnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File could not be found!",
                            "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File could not be read!",
                            "Problem Writing to File!", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Could not convert object to"
                            + " the appropriate class!", "Problem Converting Object Read From File!", JOptionPane.ERROR_MESSAGE);

                } catch (ClassCastException cce) {
                    cce.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Could not convert the object to"
                            + "the appropriate class!", "Problem Converting Object!", JOptionPane.ERROR_MESSAGE);
                }

                String loginName = tfName.getText();
                String pinCode = String.valueOf(tfPinCode.getPassword());

                if (loginName.equals(setLoginName)) {
                    JOptionPane.showMessageDialog(null, "Correct Login from newly registered Login, Welcome", "Welcome!", 1);

                    //create HomePage (Already set as visible)
                    new HomePage();
                    //hide LoginPage
                    dispose();
                }

                else if (mixtureOfObjects.contains(loginName)){
                    JOptionPane.showMessageDialog(null, "Correct Login from Login list file, Welcome: " + loginName, "Welcome!", 1);

                    //create HomePage (Already set as visible)
                    new HomePage();
                    //hide LoginPage
                    dispose();
                }

                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Login, Please re-enter correct login details", "Error", 2);
                    lbInput.setText("You inputted = Name: " + loginName
                            + " Pin: " + pinCode);
                    JOptionPane.showMessageDialog(null, "All valid login names from the " +
                                    "login array-list are:\n\n" + objectMixture,
                            "Output from login File", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

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

        addNewLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newLogin = JOptionPane.showInputDialog(null, "Please enter a new login");

                //serialization code altered from Lab Sheet 15
                try {
                    FileOutputStream outputStream = new FileOutputStream(outFile);

                    ObjectOutputStream objectOutStream = new ObjectOutputStream(outputStream);

                    mixtureOfObjects.add(newLogin);

                    objectOutStream.writeObject(mixtureOfObjects);

                    outputStream.close();

                } catch (FileNotFoundException fnfe) {
                    System.out.println(fnfe.getStackTrace());
                    JOptionPane.showMessageDialog(null, "File could not be found!",
                            "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ioe) {
                    System.out.println(ioe.getStackTrace());
                    JOptionPane.showMessageDialog(null, "File could not be written!",
                            "Problem Writing to File!", JOptionPane.ERROR_MESSAGE);
                }

                File loginFile = new File("loginDetails.txt");

                StringBuilder objectMixture = null;
                try {
                    FileInputStream inputStream = new FileInputStream(loginFile);

                    ObjectInputStream objectInStream = new ObjectInputStream(inputStream);

                    mixtureOfObjects = (ArrayList<Object>) objectInStream.readObject();

                    objectMixture = new StringBuilder();

                    for (Object x : mixtureOfObjects) {
                        objectMixture.append(x).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, "New login added succesfully");

                    inputStream.close();

                } catch (FileNotFoundException fnfe) {
                    fnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File could not be found!",
                            "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File could not be read!",
                            "Problem Writing to File!", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Could not convert object to"
                            + " the appropriate class!", "Problem Converting Object Read From File!", JOptionPane.ERROR_MESSAGE);

                } catch (ClassCastException cce) {
                    cce.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Could not convert the object to"
                            + "the appropriate class!", "Problem Converting Object!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
