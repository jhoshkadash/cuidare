package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GerenteDAO extends UsuarioDAO <GerenteVO>
/*
 * declaração de classe para a criação de Gerentes DAO implementados a MariaDB
 */
{
    /* método de inserção de gerentes ao MariaDB */
    @Override
    public void Inserir(GerenteVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "inset into Gerente (id_gerente_user, id_gerente_pessoa) values (?,?)";
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        vo.setIdUser();
        psts.setLong(1, vo.getIdUser());
        vo.setIdPessoa();
        psts.setLong(2, vo.getIdPessoa());
        int affectedRows = psts.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
        }
        ResultSet generatedKeys = psts.getGeneratedKeys();
        if (generatedKeys.next()) {
            vo.setIdGerente(generatedKeys.getLong(1));
        } else {
            throw new SQLException("A inserção falhou. nenhum id foi retornado.");
        }
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar(GerenteVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "delete from Gerente where id_gerente = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdGerente());
        ptst.executeUpdate();
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Gerente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    @Override
    public ResultSet ListarPorNome(GerenteVO vo) throws SQLException {
        String sql = "select * from Pessoa where nome = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        rs = psts.executeQuery();
        return rs;
    }

    @Override
    public ResultSet ListarPorId(GerenteVO vo) throws SQLException {
        String sql = "select * from Gerente where id_gerente = ?";
        PreparedStatement psts;
        ResultSet rs = null;
        psts = getConnection().prepareStatement(sql);
        psts.setLong(1, vo.getIdGerente());
        rs = psts.executeQuery();
        return rs;
    }

    @Override
    public void Atualizar(GerenteVO vo) throws SQLException {
        String sql = "update Pessoa set nome = ? where id = ?";
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        psts.setLong(2, vo.getIdPessoa());
        psts.executeUpdate();
    }
}
