package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaudoDAO extends BaseDAO
{
    //Isenrir um Laudo
    public void inserir(LaudoVO vo)
    {
        conn = getConnection();
        String sql = "insert into Laudo(IdMedico,IdPAciente,IdConsulta,Observacoes) values (?,?,?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getIdMedico());
            ptst.setNString(2, vo.getIdPaciente());
            ptst.setNString(3, vo.getIdConsulta());
            ptst.setNString(4, vo.getObservacoes());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //Remover um Laudo
    public void removerByCPF(LaudoVO vo)
    {
        conn = getConnection();
        String sql = "delete from Laudo where IdMedico = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getIdMedico());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        


    }
}
