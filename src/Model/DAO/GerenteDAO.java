package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GerenteDAO extends BaseDAO
{
    public void inserir(GerenteVO vo)
    {
        conn = getConnection();
        String sql = "insert into Gerente(id,nome) values (?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNInteger(1, vo.getId());
            ptst.setNString(2, vo.getNome());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void removerById(GerenteVO vo)
    {
        conn = getConnection();
        String sql = "delete from Gerente where cpf = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNInteger(1, vo.getId());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
