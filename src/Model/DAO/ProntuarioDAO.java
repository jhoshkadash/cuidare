package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class ProntuarioDAO extends BaseDAO <ProntuarioVO>
/* declaração de classe para a criação de Prontuarios DAO implementados a MariaDB */
{
    /* método de inserção de Prontuarios ao MariaDB */
    @Override
    public void Inserir (ProntuarioVO vo){
        try{
            String sql = "inset into Laudo ( data_nascimento, ante_patologico, medi_atuais, medi_alergicos, historico_doenças, peso, altura, id_paciente) values (?,?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setDate(1,null, vo.getDataNascimento());
            psts.setString(2, vo.getAntenPatologico());
            psts.setString(3, vo.getMediAtuais());
            psts.setString(4, vo.getMediAlergia());
            psts.setString(5, vo.getHistoricoDoenca());
            psts.setFloat(6, vo.getPeso());
            psts.setFloat(7, vo.getAltura());
            psts.setLong(8, vo.getIdPaciente());
            int affectedRows = psts.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = psts.getGeneratedKeys();
            if(generatedKeys.next()){
                vo.setIdProntuario(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar (ProntuarioVO vo) {
        try{
        String sql = "delete from Prontuario where id_prontuario = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setLong(1, vo.getIdProntuario());
        ptst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() {
        String sql = "select * from Prontuario"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(sql);
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet ListarPorNome (ProntuarioVO vo) {
        String sql = "select * from Pessoa where nome = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet ListarPorId (ProntuarioVO vo) {
        String sql = "select * from Prontuario where id_prontuario = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdProntuario());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public void Atualizar (ProntuarioVO vo){
        String sql = "update Prontuario set medi_atuais = ? where id_prontuario = ?";
        PreparedStatement psts;
        try{
            psts = getConnection().prepareStatement(sql);
            psts.setString(1,vo.getMediAtuais());
            psts.setLong(2, vo.getIdProntuario());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
