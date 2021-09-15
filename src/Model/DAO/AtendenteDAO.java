package Model.DAO;

import Model.VO.*;
import java.util.*;
import java.sql.*;

public class AtendenteDAO extends BaseDAO {
    // criação do método de inserção de atendentes ao MariaDB
    public void inserir(AtendenteVO vo) {
        conn = getConnection();
        String sql = "insert into Atendente(nome,cpf) values (?,?)"; /* passa o comando de inserção em SQL para o DB. */
        /* passa o comando de inserção em SQL para o DB. */
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

    // criação do método de remorção de atendentes 
    public void removerByCPF(AtendenteVO vo) {
        conn = getConnection();
        String sql = "delete from Atendente where cpf = ?"; /* passa o comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getCpf());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // criação do método de listagem de atendentes 
    public List<AtendenteVO> listar() {
        conn = getConnection();
        String sql = "select * from atendente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs;
        List<AtendenteVO> atendentes = new ArrayList<AtendenteVO>(); //criação da ArrayList de Atendentes
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

    // método de edição dos dados (nome e Id) da tabela Atendente 
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

    // método de edição do dado CPF da tabela Atendente 
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
