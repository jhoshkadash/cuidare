package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO extends BaseDAO
{
    public void inserir(PacienteVO vo)
    {
        conn = getConnection();
        String sql = "insert into Paciente(nome,cpf,endereco) values (?,?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.setNString(3, vo.getEndereco());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void removerByCPF(PacienteVO vo)
    {
        conn = getConnection();
        String sql = "delete from Paciente where cpf = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getCpf());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
