package Model.DAO;

import java.sql.Connection; //lib para realizar a conexão do código com o DB
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    Connection conn = null;
    String url = "jdbc:mariadb://localhost:3306/cuidare"; //url do projeto
    String user = "root";
    String senha = "root";

    public Connection getConnection() {
    /* criação do método getConnection() para realizar a ligação entre as classes do 
       código e o MariaDB. */ 
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, senha);
                System.out.println("Dados salvos com sucesso");  //conexão bem sucedida
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        } else
            return conn;
    }
}

