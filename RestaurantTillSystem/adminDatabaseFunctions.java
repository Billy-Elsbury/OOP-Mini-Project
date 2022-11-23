package RestaurantTillSystem;

/*****************************************************
 * Database incorporation learnt from Database Programming Lab Week 9
 * Site: https://mtukerry.instructure.com/courses/1111
 * (Accessed 23 November 2022)
 * *****************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by t00036478 on 01/02/2018.
 */
public class adminDatabaseFunctions {
        private  String driverClass = "oracle.jdbc.driver.OracleDriver";
        private  Connection connection = null;
        private  String url = "jdbc:oracle:thin:@studentoracle.students.ittralee.ie:1521:orcl";
        private  String username = "T00224562"; // your username
        private  String password = "tqxyP7*9vgw4"; //your password

        public adminDatabaseFunctions(){
        }

        private void setConnection() {
                try {
                        Class.forName(driverClass).getDeclaredConstructor().newInstance();
                        connection = DriverManager.getConnection(url, username, password);
                        System.out.println(connection);
                } catch (Exception ex) {
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

        public static void main(String[] args){
                adminDatabaseFunctions manager = new adminDatabaseFunctions();
                manager.setConnection();

        }
}

