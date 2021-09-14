package Model.DAO;

import Model.VO.*;
import java.util.*;
import java.sql.*;

public class AtendenteDAO extends BaseDAO {
    // Isenrir um Atendente
    public void inserir(AtendenteVO vo) {
        conn = getConnection();
        String sql = "insert into Atendente(nome,cpf) values (?,?)";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remover um Atendente
    public void removerByCPF(AtendenteVO vo) {
        conn = getConnection();
        String sql = "delete from Atendente where cpf = ?";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getCpf());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Listar Atendentes

    public List<AtendenteVO> listar() {
        conn = getConnection();
        String sql = "select * from atendente";
        Statement st;
        ResultSet rs;
        List<AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                AtendenteVO vo = new AtendenteVO();
                vo.setCpf(rs.getString("CPF"));
                vo.setNome(rs.getString("Nome"));
                vo.setId(rs.getInt("id"));
                atendentes.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atendentes;
    }

    // editar nome atendente
    public void editarNome(AtendenteVO vo) {
        conn = getConnection();
        String sql = "update atendente set nome = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setString(1, vo.getNome());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // editar cpf atendente
    public void editarCpf(AtendenteVO vo) {
        conn = getConnection();
        String sql = "update atendente set cpf = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setString(1, vo.getCpf());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
