package Model.DAO;
import Model.VO.AtendenteDAO
import java.sql.PreparedStatement;

public class AtendenteDAO extends BaseDao
{
    public void inserir()
    {
        conn = getConnection();
        String sql = "insert into ()";
        PreparedStatement ptst = conn.preparedStatement(sql);
    }
}
