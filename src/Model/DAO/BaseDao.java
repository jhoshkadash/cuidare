package src.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseDao{
    Connection conn = null;
    String url = "jdbc:postgreesql://localhost:5432/Cuidare";
    String user = "postgres";
    String senha = "postgres";


public Connection getConnection(){
    if(conn == null){
        try {
            conn = DriverManager.getConnection(url, user, senha);
            System.out.println("Conexao realizada com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    else return conn;
}
}