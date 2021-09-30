package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class PessoaDAO <VO extends PessoaVO> extends BaseDAO <VO>;

/* método de inserção de Usuarios ao MariaDB */
@Override
public void inserir(VO vo) {
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
@Override
public void removerById(VO vo) {
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
@Override
public List<VO vo> listar() {
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