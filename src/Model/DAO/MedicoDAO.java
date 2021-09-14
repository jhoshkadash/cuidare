package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO extends BaseDAO
{
    public void inserir(MedicoVO vo)
    {
        conn = getConnection();
        String sql = "insert into Medico(nome,cpf,endereco,valorconsulta,crm) values (?,?,?,?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.setNString(3, vo.getEndereco());
            ptst.setDouble(4, vo.getValorconsulta());
            ptst.setNString(5, vo.getCrm());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void removerByCPF(MedicoVO vo)
    {
        conn = getConnection();
        String sql = "delete from Medico where nome = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {           
            e.printStackTrace();
        }
    }
}
