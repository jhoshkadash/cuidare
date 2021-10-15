package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class ConsultaDAO extends BaseDAO < ConsultaVO >
/* declaração de classe para a criação de Consultas DAO implementadas a MariaDB */
{
    @Override
    public void Inserir (ConsultaVO vo){
        try{
            String sql = "inset into Consulta (id_medico, id_paciente, data, status) values (?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setLong(1, vo.getIdMedico());
            psts.setLong(2, vo.getIdPaciente());
            psts.setDate(3, null ,vo.getDataConsulta());
            psts.setBoolean(4, vo.isStatus());
            int affectedRows = psts.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = psts.getGeneratedKeys();
            if(generatedKeys.next()){
                vo.setIdConsulta(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar (ConsultaVO vo) {
        try{
        String sql = "delete from Consulta where id_consulta = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdConsulta());
        ptst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() {
        String sql = "select * from Consulta"; /* comando de listagem em SQL para o DB. */
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

    public ResultSet ListarPorNome (PessoaVO vo) {
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
    public ResultSet ListarPorId (ConsultaVO vo) {
        String sql = "select * from Consulta where id_consulta = ?";
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
    public void Atualizar (ConsultaVO vo){
        String sql = "update Consulta set data = ? where id_consulta = ?";//atualiza data da consulta
        PreparedStatement psts;
        try{
            psts = getConnection().prepareStatement(sql);
            psts.setDate(1,null,vo.getDataConsulta());
            psts.setLong(2, vo.getIdConsulta());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
