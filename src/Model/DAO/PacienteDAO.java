package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class PacienteDAO extends PessoaDAO< PacienteVO >{
/* declaração de classe para a criação de Pacientes DAO implementados a MariaDB */

    /* método de inserção de Pacientes ao MariaDB */
    @Override
    public void Inserir(PacienteVO vo) {
        try{
            super.Inserir(vo);
            String sql = "insert into Paciente (endereço, id_pessoa) values (?,?)"; /* comando de inserção em SQL para o DB. */
            PreparedStatement ptst;
            ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ptst.setNString(1, vo.getEndereco());
            ptst.setLong(2, vo.getIdPessoa());
            int effectedrows = ptst.executeUpdate();
            if (effectedrows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada");
            }
            ResultSet generatedKeys = ptst.getGeneratedKeys();
            if (generatedKeys.next()){
                vo.setId_paciente(generatedKeys.getLong(1));
            } else {
                throw new SQLException("A inserção falhou. Nenhum id foi retornado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de remoção de dados de Pacientes do DB */
    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar(PacienteVO vo) {
        try{
        super.Inserir(vo);
        String sql = "delete from Paciente where id_pessoa = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdPessoa());
        ptst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() {
        String sql = "select * from Paciente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        ResultSet rsPessoa = null;
        try {
            st = getConnection().prepareStatement(sql);
            rs = st.executeQuery(sql);
            rsPessoa = super.Listar();
            while (rs.next()) {
                PacienteVO vo = new PacienteVO();
                vo.setNome(rsPessoa.getString("nome"));
                vo.setCpf(rsPessoa.getString("cpf"));
                vo.setEndereco(rs.getString("endereço"));
                vo.setId_paciente(rs.getLong("id_paciente"));
                vo.setId_pessoa(rs.getLong("id_pessoa"));

            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet ListarPorNome(PacienteVO vo) {
        String sql = "select * from Pessoa where nome = ?";
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
    public ResultSet ListarPorId(PacienteVO vo) {
        String sql = "select * from Paciente where id_paciente = ?";
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getId_paciente());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public void Atualizar(PacienteVO vo){
        String sql = "update Pessoa set nome = ? where id = ?";
        PreparedStatement psts;
        try{
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            psts.setLong(2, vo.getId_pessoa());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
