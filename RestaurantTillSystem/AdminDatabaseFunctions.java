package RestaurantTillSystem;

/*****************************************************
 * Database incorporation learnt from Database Programming Lab Week 9
 * Site: https://mtukerry.instructure.com/courses/1111
 * (Accessed 23 November 2022)
 *
 *
 * Other code referenced from
 * Site: https://youtu.be/Gqc4yCQgUJI
 * (Accessed 23 November 2022)
 * *****************************************************/

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Database functionality not working outside of college
public class AdminDatabaseFunctions {

        public AdminDatabaseFunctions(){
        }

        private  String driverClass = "oracle.jdbc.driver.OracleDriver";
        private static Connection connection = null;
        private  String url = "jdbc:oracle:thin:@studentoracle.students.ittralee.ie:1521:orcl";
        private  String username = "T00224562";
        //for security reasons no password
        private  String password = "enter password";

        private String insertSql = "INSERT INTO REVENUEANALYSIS VALUES (2022, 172200, 81200, 'Guiness')";
        private String selectSql = "SELECT * FROM REVENUEANALYSIS";
        private String deleteSql = "DELETE FROM REVENUEANALYSIS WHERE YEARID=2022";

                //method to set Connection on run
                private void setConnection() {

                        try {
                                Class.forName(driverClass).getDeclaredConstructor().newInstance();
                                connection = DriverManager.getConnection(url, username, password);
                                System.out.println(connection);
                        }
                        catch (Exception ex) {
                                System.err.println("Exception:"+ ex.getMessage());
                                ex.printStackTrace();
                        }
                }

                private Connection getConnection() {
                        if (connection == null) {
                                setConnection();
                        }
                        return connection;
                }


                public static void RetrieveFromDatabase(){
                        AdminDatabaseFunctions manager = new AdminDatabaseFunctions();
                        manager.setConnection();

                        try
                        {
                                Statement stmt=connection.createStatement();
                                ResultSet rs=stmt.executeQuery("SELECT * FROM REVENUEANALYSIS");
                                while(rs.next())
                                {
                                        int id=rs.getInt("YEARID");
                                        String sales=rs.getString("GROSSSALES");
                                        String profit=rs.getString("NETPROFIT");
                                        String popular=rs.getString("MOSTPOPULAR");
                                        JOptionPane.showMessageDialog(null,
                                                "Year: "+id
                                                        +"\nGross Sales: €"+sales
                                                        +"\nNet Profit: €"+profit
                                                        +"\nMost Popular: "+popular);
                                }
                        }
                        catch(Exception e) {
                        }
                }
}


