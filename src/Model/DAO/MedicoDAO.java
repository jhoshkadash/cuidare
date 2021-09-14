package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class MedicoDAO extends BaseDAO
{
    public void inserir(MedicoVO vo)
    {
        conn = getConnection();
        String sql = "insert into Medico(nome,cpf,endereco,valorconsulta,crm) values (?,?,?,?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.setNString(3, vo.getEndereco());
            ptst.setDouble(4, vo.getValorconsulta());
            ptst.setNString(5, vo.getCrm());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void removerByCPF(MedicoVO vo)
    {
        conn = getConnection();
        String sql = "delete from Medico where nome = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {           
            e.printStackTrace();
        }
    }
    //listar médicos

    public List <MedicoVO> listar(){
        conn = getConnection();
        String sql ="select * from medico";
        Statement st;
        ResultSet rs;
        List<MedicoVO> medicos = new ArrayList<MedicoVO>();    
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                MedicoVO vo = new MedicoVO();
                vo.setCpf(rs.getString("CPF"));
                vo.setNome(rs.getString("Nome"));
                vo.setId(rs.getInt("id"));
                vo.setCrm(rs.getNString("CRM"));
                vo.setValorconsulta(rs.getFloat("vConsulta"));
                vo.setEndereco(rs.getNString("endereço"));
                medicos.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }
    //editar nome
    public void editarNome(MedicoVO vo){
        conn = getConnection();
        String  sql = "update medico set nome = ? where id = ?";
        PreparedStatement psts;
             try{
                psts = conn.prepareStatement(sql);
                psts.setString(1, vo.getNome());
                psts.setInt(2, vo.getId());
                psts.executeUpdate();
                }
            catch(SQLException e){
            e.printStackTrace();
    }
}
public void editarCpf(MedicoVO vo){
    conn = getConnection();
    String  sql = "update medico set cpf = ? where id = ?";
    PreparedStatement psts;
         try{
            psts = conn.prepareStatement(sql);
            psts.setString(1, vo.getCpf());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
            }
        catch(SQLException e){
        e.printStackTrace();
}
}
//editar crm
public void editarCrm(MedicoVO vo){
    conn = getConnection();
    String  sql = "update medico set crm = ? where id = ?";
    PreparedStatement psts;
         try{
            psts = conn.prepareStatement(sql);
            psts.setString(1, vo.getCrm());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
            }
        catch(SQLException e){
        e.printStackTrace();
    }
}
//editar endereço
public void editarEndereco(MedicoVO vo){
    conn = getConnection();
    String  sql = "update medico set endereco = ? where id = ?";
    PreparedStatement psts;
         try{
            psts = conn.prepareStatement(sql);
            psts.setString(1, vo.getNome());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
            }
        catch(SQLException e){
        e.printStackTrace();
}}
//editar valor da consulta
public void editarVConsulta(MedicoVO vo){
    conn = getConnection();
    String  sql = "update medico set vconsulta = ? where id = ?";
    PreparedStatement psts;
         try{
            psts = conn.prepareStatement(sql);
            psts.setDouble(1, vo.getValorconsulta());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
            }
        catch(SQLException e){
        e.printStackTrace();
}}
}
