package Model.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO <VO> {
    public void Inserir(VO entity) throws SQLException;
    public void Atualizar(VO entity) throws SQLException;
    public void Deletar(VO entity) throws SQLException;
    public ResultSet ListarPorId(VO entity) throws SQLException;
    public ResultSet ListarPorNome(VO entity) throws SQLException;
    public ResultSet Listar() throws SQLException;
}