package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class UsuarioDAO extends BaseDAO {
    public void inserir(UsuarioVO vo) {
        conn = getConnection();
        String sql = "insert into Usuario(login,senha) values (?,?)";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getLogin());
            ptst.setNString(2, vo.getSenha());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerById(UsuarioVO vo) {
        conn = getConnection();
        String sql = "delete from Usuario where login = ?";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getLogin());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UsuarioVO> listar() {
        conn = getConnection();
        String sql = "select * from user";
        Statement st;
        ResultSet rs;
        List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                UsuarioVO vo = new UsuarioVO();
                vo.setLogin(rs.getNString("login"));
                vo.setSenha(rs.getNString("senha"));
                usuarios.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}
