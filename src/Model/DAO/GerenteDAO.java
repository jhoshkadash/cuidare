package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class GerenteDAO extends BaseDAO
/* declaração de classe para a criação de Gerentes DAO implementados a MariaDB */
{
    /* método de inserção de gerentes ao MariaDB */
    public void inserir(GerenteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "insert into Gerente(nome, cpf) values (?,?)"; /* comando de inserção em SQL para o DB. */
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

    /* método de remoção de dados de Gerentes do DB */
    public void removerById(GerenteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "delete from Gerente where id = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, vo.getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* criação do método de listagem de atendentes */
    public List<GerenteVO> listar() {
        conn = getConnection(); //conexão estabelecida
        String sql = "select * from gerente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs;
        List<GerenteVO> gerentes = new ArrayList<GerenteVO>(); //criação da ArrayList de Gerentes
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
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

    /* método de edição do dado nome da tabela Gerente */ 
    public void editarNome(GerenteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update gerente set nome = ? where id = ?"; /* comando de edição em SQL para o DB. */
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

    /* método de edição do dado CPF da tabela Gerente */
    public void editarCpf(GerenteVO vo) {
        conn = getConnection(); //conecão estabelecida
        String sql = "update gerente set cpf = ? where id = ?"; /* comando de edição em SQL para o DB. */
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
