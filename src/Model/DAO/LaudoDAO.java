package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class LaudoDAO extends BaseDAO <LaudoVO>
/* declaração de classe para a criação de Laudos DAO implementados a MariaDB */
{
    /* método de inserção de laudos ao MariaDB */
    @Override
    public void Inserir (LaudoVO vo){
        try{
            String sql = "inset into Laudo ( nome_paciente, obs, id_medico, id_consulta ,id_paciente ) values (?,?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setString(1, vo.getNomePaciente());
            psts.setString(2, vo.getObservacoes());
            psts.setLong(3, vo.getIdMedico());
            psts.setLong(4, vo.getIdConsulta());
            psts.setLong(5, vo.getIdPaciente());
            int affectedRows = psts.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = psts.getGeneratedKeys();
            if(generatedKeys.next()){
                vo.setIdLaudo(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar (LaudoVO vo) {
        try{
        String sql = "delete from Laudo where id_laudo = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdLaudo());
        ptst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() {
        String sql = "select * from Laudo"; /* comando de listagem em SQL para o DB. */
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
    public ResultSet ListarPorNome (LaudoVO vo) {
        String sql = "select * from Laudo where nome_paciente = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNomePaciente());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet ListarPorId (LaudoVO vo) {
        String sql = "select * from Laudo where id_laudo = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdConsulta());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public void Atualizar (LaudoVO vo){
        String sql = "update Laudo set obs = ? where id_laudo = ?";
        PreparedStatement psts;
        try{
            psts = getConnection().prepareStatement(sql);
            psts.setString(1,vo.getObservacoes());
            psts.setLong(2, vo.getIdLaudo());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
