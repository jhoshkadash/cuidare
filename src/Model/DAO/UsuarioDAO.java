package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class UsuarioDAO extends BaseDAO 
/* declaração de classe para a criação de Usuarios DAO implementados a MariaDB */
{
    /* método de inserção de Usuarios ao MariaDB */
    public void inserir(UsuarioVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "insert into Usuario(login,senha) values (?,?)"; /* comando de inserção em SQL para o DB. */
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

    /* método de remoção de Usuarios ao MariaDB */
    public void removerById(UsuarioVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "delete from Usuario where login = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getLogin());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de listagem de Usuarios ao MariaDB */
    public List<UsuarioVO> listar() {
        conn = getConnection(); //conexão estabelecida
        String sql = "select * from user"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs;
        List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>(); //criação da ArrayList de Usuarios
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
    //editar login
    public void editarLogin(UsuarioVO vo) {
        conn = getConnection();
        String sql = "update user set login = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setNString(1, vo.getLogin());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //editar senha
    public void editarSenha(UsuarioVO vo) {
        conn = getConnection();
        String sql = "update user set senha = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setNString(1, vo.getSenha());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
