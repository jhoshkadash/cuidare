package Model.DAO;

import Model.VO.*;
import java.sql.*;


public class ConsultaDAO extends BaseDAO < ConsultaVO >
/* declaração de classe para a criação de Consultas DAO implementadas a MariaDB */
{
    @Override
    public void Inserir (ConsultaVO vo){
        try{

            Date data = new Date(vo.getDataConsulta().getTimeInMillis());
            final java.sql.Timestamp dataSql = new java.sql.Timestamp(data.getTime());// tratamento da classe calendar para timestamp

            String sql = "inset into Consulta (id_medico, id_paciente, data, status) values (?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setLong(1, vo.getIdMedico());
            psts.setLong(2, vo.getIdPaciente());
            psts.setTimestamp(3, dataSql, vo.getDataConsulta());
            psts.setBoolean(4, vo.isStatus());
            
            int affectedRows = psts.executeUpdate(); //variável para verificação de alterações na tabela
            
            if (affectedRows == 0){ // verificação de alteração
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            
            ResultSet generatedKeys = psts.getGeneratedKeys(); //Id retornado da tabela
            
            if(generatedKeys.next()){ //caso nenhum seja id retornado, será inserido na consulta, caso não exibe falha
                vo.setIdConsulta(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /* método de remoção de consultas */
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

    /* método de listagem de consultas */
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
    
    /* método de listagem de consultas por nome do médico */
    public ResultSet ListarPorNomeMedico (ConsultaVO vo) {
        String sql = "select * from Medico where id_medico = ?"; /* comando SQL para listagem por nome de médico. */
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdMedico());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    /* método de listagem de consultas por nome do paciente */
    public ResultSet ListarPorNomePaciente (ConsultaVO vo) {
        String sql = "select * from Paciente where id_Paciente = ?"; /* comando SQL para listagem por nome de paciente. */
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdPaciente());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /* método de listagem de consultas por horário */
    public ResultSet ListarPorHorario (ConsultaVO vo) {
        String sql = "select * from Medico where id_medico = ?"; /* comando SQL para listagem por horário. */
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdMedico());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /* método de listagem de consultas por Id */
    @Override
    public ResultSet ListarPorId (ConsultaVO vo) {
        String sql = "select * from Consulta where id_consulta = ?"; /* comando SQL para listagem por Id. */
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

    /* método de listagem de consultas por data */
    public ResultSet ListarPorData(ConsultaVO vo){
        String sql = "select * from Consulta where data = ?"; /* comando SQL para listagem por data. */
        PreparedStatement psts = null;
        ResultSet rs =  null;
        Date data = new Date(vo.getDataConsulta().getTimeInMillis());
        final java.sql.Timestamp dataSql = new java.sql.Timestamp(data.getTime()); // tratamento da classe calendar para timestamp

        try{
            psts.getConnection().prepareStatement(sql);
            psts.setTimestamp(1, dataSql, vo.getDataConsulta());
            rs = psts.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    /* método de atualização de dados de consultas */
    @Override
    public void Atualizar (ConsultaVO vo){
        String sql = "update Consulta set data = ? where id_consulta = ?"; /* comando SQL para atualizar data da consulta. */
        PreparedStatement psts;
        Date data = new Date(vo.getDataConsulta().getTimeInMillis());
        final java.sql.Timestamp dataSql = new java.sql.Timestamp(data.getTime()); //tratamento da classe calendar para timestamp
        try{
            psts = getConnection().prepareStatement(sql);
            psts.setTimestamp(1, dataSql, vo.getDataConsulta());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
