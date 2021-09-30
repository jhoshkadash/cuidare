package Model.DAO;

import java.sql.Connection; //lib para realizar a conexão do código com o DB
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.internal.com.read.dao.Results;

public abstract class BaseDAO <VO> implements BaseInterDAO <VO>{
    private static Connection conn = null;
    private static final String url = "jdbc:mariadb://localhost:3306/cuidare"; //url do projeto
    private static final String user = "root";
    private static final String senha = "root";
    

    public static Connection getConnection() {
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
    public static void  closeConnection(){
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public abstract void inserir (VO vo) throws SQLException;
    public abstract void atualizar (VO vo) throws SQLException;
    public abstract void deletar (VO vo) throws SQLException;
    public abstract ResultSet listar() throws SQLException;
    public abstract ResultSet listarPorNome(VO entity) throws SQLException;
    public abstract ResultSet listarPorId(VO vo) throws SQLException;
}
