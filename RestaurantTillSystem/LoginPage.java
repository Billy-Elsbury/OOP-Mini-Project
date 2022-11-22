package RestaurantTillSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LoginPage extends JFrame{
    JPanel loginPanel;
    JTextField tfName;
    JTextField tfPinCode;
    JButton btnLogin;
    JButton btnClear;
    JLabel lbLogin;
    JButton btnExit;
    JLabel lbInput;
    private JLabel Image;

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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);

        String setLoginName = JOptionPane.showInputDialog("Please enter the name you wish to register as your login name",
                "JohnBrosnan");
        String setLoginPin = JOptionPane.showInputDialog("Please enter the pin you wish to register as your login name",
                "T00224562");

        lbLogin.setText("Valid details = Name: " + setLoginName + " Pin: " + setLoginPin);

        setVisible(true);

        //LoginName name = new LoginName();
        //call loginDetails class

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //make new file for login info(reference Lab Sheet 15)
                File outFile = new File("loginDetails.txt");

                try {
                    FileOutputStream outputStream = new FileOutputStream(outFile);

                    LoginDetails login1 = new LoginDetails("BillyElsbury", 76146);
                    LoginDetails login2 = new LoginDetails("JohnBrosnan",12345);

                    ObjectOutputStream objectOutStream = new ObjectOutputStream(outputStream);

                    objectOutStream.writeObject(login1);
                    objectOutStream.writeObject(login2);

                    ArrayList<Object> mixtureOfObjects = new ArrayList<>();

                    mixtureOfObjects.add("Billy");
                    mixtureOfObjects.add("Billy2");
                    mixtureOfObjects.add("Billy3");
                    mixtureOfObjects.add("Billy4");

                    objectOutStream.writeObject(mixtureOfObjects);

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

                    LoginDetails login1 = (LoginDetails) objectInStream.readObject();
                    LoginDetails login2 = (LoginDetails) objectInStream.readObject();

                    ArrayList<Object> mixtureOfObjects = (ArrayList<Object>) objectInStream.readObject();

                    String objectMixture = "";

                    for (Object x : mixtureOfObjects)
                        objectMixture += x + "\n";

                    JOptionPane.showMessageDialog(null, "State of standalone objects " +
                            "read from the file are:\n\n" + login1 + "\n" +
                            login2 +
                            "\n\nThe ones from the array-list are:\n\n" + objectMixture,
                            "Output from File", JOptionPane.INFORMATION_MESSAGE);

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
               //create HomePage (Already set as visible)
                new HomePage();
               //hide LoginPage
                setVisible(false);
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
}
