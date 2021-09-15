package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class PacienteDAO extends BaseDAO 
/* declaração de classe para a criação de Pacientes DAO implementados a MariaDB */
{
    /* método de inserção de Pacientes ao MariaDB */
    public void inserir(PacienteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "insert into Paciente(nome,cpf,endereco) values (?,?,?)"; /* comando de inserção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.setNString(3, vo.getEndereco());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de remoção de dados de Pacientes do DB */
    public void removerByCPF(PacienteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "delete from Paciente where cpf = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getCpf());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* criação do método de listagem de Médicos */
    public List<PacienteVO> listar() {
        conn = getConnection(); //conexão estabelecida
        String sql = "select * from paciente"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs;
        List<PacienteVO> pacientes = new ArrayList<PacienteVO>(); //criação da ArrayList de Pacientes
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
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

    /* método de edição do dado Nome da tabela Paciente */
    public void editarNome(PacienteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update paciente set nome = ? where id = ?"; /* comando de edição em SQL para o DB. */
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

    /* método de edição do dado CPF da tabela Paciente */
    public void editarCpf(PacienteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update paciente set cpf = ? where id = ?"; /* comando de edição em SQL para o DB. */
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

    /* método de edição do dado Endereco da tabela Paciente */
    public void editarEndereco(PacienteVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update paciente set endereco = ? where id = ?"; /* comando de edição em SQL para o DB. */
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
}
