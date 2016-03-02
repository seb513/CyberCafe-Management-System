package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class dbconnect {
    
    public static Connection getDBConnection(){
    
        Connection con=null;
        String url="jdbc:mysql://localhost:3306/cybercafe";
        String user="root";
        String password="";
        
        try{
        
			//Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver connected");
			
			//Open a connection
            con=DriverManager.getConnection(url, user, password);
            System.out.println("DB Connected");
            return con;
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
