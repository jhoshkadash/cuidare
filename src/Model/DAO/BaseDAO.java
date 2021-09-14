package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    Connection conn = null;
    String url = "jdbc:mariadb://localhost:3306/cuidare";
    String user = "root";
    String senha = "root";

    public Connection getConnection(){
        if (conn == null){
            try{
                conn = DriverManager.getConnection(url, user, senha);
                System.out.println("conexão realizada com sucesso");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            return conn;
        }
        else return conn;
    }

}
