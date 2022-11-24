package RestaurantTillSystem;

import javax.swing.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Jail extends JFrame {
    private JPanel panel1;
    private JLabel lblJail;
    private JTextArea textArea;
    public static int interval;
    public static Timer timer;

    public Jail() {
        setContentPane(panel1);
        setSize(700, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*****************************************************
         * Timer code referenced from: https://stackoverflow.com/questions/14393423/how-to-make-a-countdown-timer-in-java
         * (Accessed 23 November 2022)
         * *****************************************************/

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 2147483647;
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                textArea.setText(String.valueOf(setInterval()));
            }
        }, delay, period);
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }



    public static void main(String[] args) {
        new Jail();
}
}

