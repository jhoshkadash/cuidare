package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class GerenteDAO extends BaseDAO
{
    //Isenrir um gerente
    public void inserir(GerenteVO vo)
    {
        conn = getConnection();
        String sql = "insert into Gerente(nome, cpf) values (?,?)";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.execute();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //Remover um gerente
    public void removerById(GerenteVO vo)
    {
        conn = getConnection();
        String sql = "delete from Gerente where cpf = ?";
        PreparedStatement ptst;
        try 
        {
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, vo.getId());
            ptst.executeUpdate();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //Listar Gerentes
   public List<GerenteVO> listar(){
        conn = getConnection();
        String sql ="select * from gerente";
        Statement st;
        ResultSet rs;
        List<GerenteVO> gerentes = new ArrayList<GerenteVO>(); 
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                GerenteVO vo = new GerenteVO();
                vo.setCpf(rs.getString("cpf"));
                vo.setNome(rs.getString("nome"));
                vo.setId(rs.getInt("id"));
                gerentes.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gerentes;
    }

}
