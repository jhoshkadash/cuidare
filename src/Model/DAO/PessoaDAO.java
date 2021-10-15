package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class PessoaDAO<VO extends PessoaVO> extends BaseDAO<VO> {

    /* método de inserção de Pessoas ao MariaDB */
    @Override
    public void Inserir(VO vo) throws SQLException {
        String sql = "insert into Pessoa  (nome,cpf) values (?,?)"; /* comando de inserção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ptst.setNString(1, vo.getNome());
        ptst.setNString(2, vo.getCpf());

        int affectedRows = ptst.executeUpdate(); // variavel para verificar se houve alteração na tabela

        if (affectedRows == 0) { // verificação de alteração
            throw new SQLException("A inserção de dados falhou. Nenhuma linha foi alterada.");
        }
        ResultSet gerenatedKeys = ptst.getGeneratedKeys(); // id retornado da tabela
        if (gerenatedKeys.next()) { // se houve id retornado, será inserido na pessoa, caso não exibe falha
            vo.setIdPessoa(gerenatedKeys.getLong(1));
        } else {
            throw new SQLException("A inserção falhou. nenhum id foi retornado");
        }
    }

    /* método de remoção de Pessoas ao MariaDB */
    @Override
    public void Deletar(VO vo) throws SQLException {
        String sql = "delete from Pessoa where id = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdPessoa());
        ptst.executeUpdate();
    }

    /* método de listagem de Pessoas ao MariaDB */
    @Override
    public ResultSet Listar() throws SQLException {

        String sql = "select * from Pessoa"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;

        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);

        return rs;
    }

    public ResultSet ListarPorNome(VO vo) throws SQLException {
        String sql = "select * from Pessoa where nome = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        rs = psts.executeQuery();

        return rs;
    }

    @Override
    public ResultSet ListarPorId(VO vo) throws SQLException {
        String sql = "select * from Pessoa where id = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setDouble(1, vo.getIdPessoa());
        rs = psts.executeQuery();

        return rs;
    }

    @Override
    public void Atualizar(VO vo) throws SQLException {
        String sql = "update Pessoa set nome = ? where id = ?";
        PreparedStatement psts;
        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        psts.setDouble(2, vo.getIdPessoa());
        psts.executeUpdate();
    }
}