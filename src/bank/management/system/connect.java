
package bank.management.system;

import java.sql.*;
public class connect {
    Connection c;
    Statement s;
    public connect()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","priyanshi@1808");
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
