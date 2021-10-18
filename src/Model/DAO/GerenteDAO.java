package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GerenteDAO extends UsuarioDAO<GerenteVO>
/*
 * declaração de classe para a criação de Gerentes DAO implementados a MariaDB
 */
{
    /* método de inserção de gerentes ao MariaDB */
    @Override
    public void Inserir(GerenteVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "inset into Gerente (id_user, id_pessoa) values (?,?)";
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        psts.setLong(1, vo.getIdUser());
        psts.setLong(2, vo.getIdPessoa());
        
        int affectedRows = psts.executeUpdate(); //variável para verificação de alterações na tabela
        
        if (affectedRows == 0) { // verificação de alteração
            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
        }
        
        ResultSet generatedKeys = psts.getGeneratedKeys(); //Id retornado da tabela
        
        if (generatedKeys.next()) { //caso nenhum seja id retornado, será inserido ao gerente, caso não, a falha é exibida
            vo.setIdGerente(generatedKeys.getLong(1));
        } else {
            throw new SQLException("A inserção falhou. nenhum id foi retornado.");
        }
    }

    /* método de remoção de gerentes ao MariaDB */
    @Override
    public void Deletar(GerenteVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "delete from Gerente where id_gerente = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdGerente());
        ptst.executeUpdate();
    }

    /* método de listagem de gerentes ao MariaDB */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Gerente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    /* método de listagem por nome de gerentes */
    @Override
    public ResultSet ListarPorNome(GerenteVO vo) throws SQLException {
        String sql = "select * from Gerente where nome = ?"; /* comando SQL para listagem por nome. */
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem por Id de gerentes */
    @Override
    public ResultSet ListarPorId(GerenteVO vo) throws SQLException {
        String sql = "select * from Gerente where id_gerente = ?"; /* comando SQL para listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;
        psts = getConnection().prepareStatement(sql);
        psts.setLong(1, vo.getIdGerente());
        rs = psts.executeQuery();
        return rs;
    }
    
    /* método para a atualização de dados de gerentes */
    @Override
    public void Atualizar(GerenteVO vo) throws SQLException { 
        String sql = "update Pessoa set nome = ? where id = ?"; /* comando SQL para atualização (update). */
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        psts.setLong(2, vo.getIdPessoa());
        psts.executeUpdate();
    }
}
