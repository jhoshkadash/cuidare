package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class MedicoDAO extends UsuarioDAO < MedicoVO > 
/* declaração de classe para a criação de Médicos DAO implementados a MariaDB */
{
    /* método de inserção de Médicos ao MariaDB */
    @Override
    public void Inserir(MedicoVO vo) throws SQLException {
            super.Inserir(vo);
            String sql = "inset into Medico (crm, valor_consulta, endereço, id_pessoa, id_user, ) values (?,?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setString(1, vo.getCrm());
            psts.setDouble(2, vo.getValorConsulta());
            psts.setString(3, vo.getEndereco());
            psts.setLong(4, vo.getIdPessoa());
            psts.setLong(5, vo.getIdUser());
            int affectedRows = psts.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = psts.getGeneratedKeys();
            if(generatedKeys.next()){
                vo.setIdMedico(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar(MedicoVO vo) throws SQLException {
        super.Inserir(vo);
        String sql = "delete from Medico where id_medico = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdUser());
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

    @Override
    public ResultSet ListarPorNome(MedicoVO vo) throws SQLException {
        String sql = "select * from Pessoa where nome = ?";
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            rs = psts.executeQuery();
        return rs;
    }

    @Override
    public ResultSet ListarPorId(MedicoVO vo) throws SQLException {
        String sql = "select * from Medico where id_medico = ?";
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdMedico());
            rs = psts.executeQuery();
        return rs;
    }

    public ResultSet ListarPorCrm(MedicoVO vo) throws SQLException {
        String sql = "select * from Medico where crm = ?";
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getCrm());
            rs = psts.executeQuery();
        return rs;
    }

    @Override
    public void Atualizar(MedicoVO vo) throws SQLException {
        String sql = "update Pessoa set nome = ? where id = ?";
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            psts.setLong(2, vo.getIdPessoa());
            psts.executeUpdate();
    }
}
