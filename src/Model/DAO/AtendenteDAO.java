package Model.DAO;
import Model.VO.AtendenteDAO
import java.sql.PreparedStatement;

public class AtendenteDAO extends BaseDAO
{
    public void inserir(AtendenteVO vo)
    {
        conn = getConnection();
        String sql = "insert into Atendente(nome,cpf) values (?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void removerByCPF(AtendenteVO vo)
    {
        conn = getConnection();
        String sql = "delete from Atendente where cpf = ?";
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
