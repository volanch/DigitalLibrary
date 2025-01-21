package Data;
import Data.Interface.IDB;
import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/Books";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionURL, "postgres", "qviopw1029");
            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
