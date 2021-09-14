package Model.DAO;
import Model.VO.AtendenteDAO
import java.sql.PreparedStatement;

public class AtendenteDAO extends BaseDao
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
}
