package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioDAO extends BaseDAO
{
    public void inserir(UsuarioVO vo)
    {
        conn = getConnection();
        String sql = "insert into Usuario(login,senha) values (?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getLogin());
            ptst.setNString(2, vo.getSenha());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void removerById(UsuarioVO vo)
    {
        conn = getConnection();
        String sql = "delete from Usuario where login = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getLogin());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
