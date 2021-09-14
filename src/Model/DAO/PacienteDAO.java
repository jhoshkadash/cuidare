package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class PacienteDAO extends BaseDAO
{
    public void inserir(PacienteVO vo)
    {
        conn = getConnection();
        String sql = "insert into Paciente(nome,cpf,endereco) values (?,?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.setNString(3, vo.getEndereco());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void removerByCPF(PacienteVO vo)
    {
        conn = getConnection();
        String sql = "delete from Paciente where cpf = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getCpf());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //listar paciente
    public List <PacienteVO> listar(){
        conn = getConnection();
        String sql ="select * from paciente";
        Statement st;
        ResultSet rs;
        List<PacienteVO> pacientes = new ArrayList<PacienteVO>();    
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                PacienteVO vo = new PacienteVO();
                vo.setCpf(rs.getString("CPF"));
                vo.setNome(rs.getString("Nome"));
                vo.setEndereco("endereço");
                pacientes.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }


}
