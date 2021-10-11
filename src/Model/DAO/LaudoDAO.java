package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class LaudoDAO extends BaseDAO
/* declaração de classe para a criação de Laudos DAO implementados a MariaDB */
{
    /* método de inserção de laudos ao MariaDB */
       @Override
    public void Inserir(VO vo){
        try{
            super.Inserir(vo);
            String sql = "inset into User (login, senha, tipo , id_pessoa) values (?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setString(1, vo.getLogin());
            psts.setString(2, vo.getSenha());
            psts.setInt(3, vo.getTipo());
            psts.setDouble(4, vo.getIdPessoa());
            int affectedRows = psts.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = psts.getGeneratedKeys();
            if(generatedKeys.next()){
                vo.setIdUser(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar(VO vo) {
        try{
        super.Inserir(vo);
        String sql = "delete from User where id = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdUser());
        ptst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() {
        String sql = "select * from User"; /* comando de listagem em SQL para o DB. */
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

    @Override
    public ResultSet ListarPorNome(VO vo) {
        String sql = "select * from User where nome = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet ListarPorId(VO vo) {
        String sql = "select * from User where id = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdUser());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public void Atualizar(VO vo){
        String sql = "update User set nome = ? where id = ?";
        PreparedStatement psts;
        try{
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            psts.setLong(2, vo.getIdUser());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
