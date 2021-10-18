package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class PacienteDAO extends PessoaDAO<PacienteVO> {
    /*
     * declaração de classe para a criação de Pacientes DAO implementados a MariaDB
     */

    /* método de inserção de Pacientes ao MariaDB */
    @Override
    public void Inserir(PacienteVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "insert into Paciente (endereço, id_pessoa) values (?,?)"; //comando de inserção em SQL para o DB.
                                                                                 
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ptst.setNString(1, vo.getEndereco());
        ptst.setLong(2, vo.getIdPessoa());
        
        int effectedrows = ptst.executeUpdate(); //variável para verificação de alterações na tabela
        
        if (effectedrows == 0) { // verificação de alteração
            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada");
        }
        ResultSet generatedKeys = ptst.getGeneratedKeys(); //Id retornado da tabela
        if (generatedKeys.next()) { //caso nenhum seja id retornado, será inserido na pessoa, caso não exibe falha
            vo.setIdPaciente(generatedKeys.getLong(1));
        } else {
            throw new SQLException("A inserção falhou. Nenhum id foi retornado");
        }
    }

    /* método de remoção de dados de Pacientes do DB */
    @Override
    public void Deletar(PacienteVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "delete from Paciente where id_pessoa = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdPessoa());
        ptst.executeUpdate();
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Paciente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    /* método de listagem de pacientes por nome */
    public ResultSet ListarPorNome(PacienteVO vo) throws SQLException {
        String sql = "select * from Pessoa where nome = ?"; //comando SQL para listagem por nome.
        PreparedStatement psts;
        ResultSet rs = null;
        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem de pacientes por Id. */
    @Override
    public ResultSet ListarPorId(PacienteVO vo) throws SQLException {
        String sql = "select * from Paciente where id_paciente = ?"; //comando SQL para listagem por Id.
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setLong(1, vo.getIdPaciente());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de listagem de pacientes por CPF. */
    public ResultSet ListarPorCpf(PacienteVO vo) throws SQLException {
        String sql = "select * from Paciente where cpf = ?"; //comando SQL para listagem por CPF.
        PreparedStatement psts;
        ResultSet rs = null;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getCpf());
        rs = psts.executeQuery();
        return rs;
    }

    /* método de atualização dos dados de pacientes */
    @Override
    public void Atualizar(PacienteVO vo) throws SQLException {
        String sql = "update Pessoa set nome = ? where id = ?"; //comando SQL para a atualização (update) de dados dos pacientes
        PreparedStatement psts;

        psts = getConnection().prepareStatement(sql);
        psts.setString(1, vo.getNome());
        psts.setLong(2, vo.getIdPessoa());
        psts.executeUpdate();
    }
}
