package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class UsuarioDAO<VO extends UsuarioVO> extends PessoaDAO<VO>
/*
 * declaração de classe para a criação de Usuarios DAO implementados a MariaDB
 */
{
    /* método de inserção de Usuarios ao MariaDB */
    @Override
    public void Inserir(VO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "inset into User (login, senha, tipo , id_pessoa) values (?,?,?,?)";
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        psts.setString(1, vo.getLogin());
        psts.setString(2, vo.getSenha());
        psts.setInt(3, vo.getTipo());
        psts.setDouble(4, vo.getIdPessoa());
        
        int affectedRows = psts.executeUpdate(); //variável para verificação de alterações na tabela
        
        if (affectedRows == 0) { // verificação de alteração
            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
        }
        
        ResultSet generatedKeys = psts.getGeneratedKeys(); //Id retornado da tabela
        
        if (generatedKeys.next()) { //caso nenhum seja id retornado, será inserido ao usuário, caso não, a falha é exibida
            vo.setIdUser(generatedKeys.getLong(1));
        } else {
            throw new SQLException("A inserção falhou. nenhum id foi retornado.");
        }
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar(VO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "delete from User where id_user = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setLong(1, vo.getIdUser());
        ptst.executeUpdate();
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from User"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;

        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    /* método de listagem por nome */
    @Override
    public ResultSet ListarPorNome(VO vo) throws SQLException {
        String sql = "select * from User where nome = ?"; /* comando de listagem por nome. */
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        rs = psts.executeQuery();
        return rs;
    }
    
    /* método de listagem por Id */
    @Override
    public ResultSet ListarPorId(VO vo) throws SQLException {
        String sql = "select * from User where id = ?"; /* comando de listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setLong(1, vo.getIdUser());
        rs = psts.executeQuery();
        return rs;
    }
    
    /* comando de atualização em SQL. */
    @Override
    public void Atualizar(VO vo) throws SQLException {
        String sql = "update User set nome = ? where id = ?"; /* comando de atualização em SQL. */
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        psts.setLong(2, vo.getIdUser());
        psts.executeUpdate();

    }
}
