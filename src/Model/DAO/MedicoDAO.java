package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class MedicoDAO extends BaseDAO 
/* declaração de classe para a criação de Médicos DAO implementados a MariaDB */
{
    /* método de inserção de Médicos ao MariaDB */
    public void inserir(MedicoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "insert into Medico(nome,cpf,endereco,valorconsulta,crm) values (?,?,?,?,?)"; /* comando de inserção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.setNString(2, vo.getCpf());
            ptst.setNString(3, vo.getEndereco());
            ptst.setDouble(4, vo.getValorconsulta());
            ptst.setNString(5, vo.getCrm());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de remoção de dados de Médicos do DB */
    public void removerByCPF(MedicoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "delete from Medico where nome = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getNome());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    /* criação do método de listagem de Médicos */
    public List<MedicoVO> listar() {
        conn = getConnection(); //conexão estabelecida
        String sql = "select * from medico"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs;
        List<MedicoVO> medicos = new ArrayList<MedicoVO>(); //criação da ArrayList de Médicos
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                MedicoVO vo = new MedicoVO();
                vo.setCpf(rs.getString("CPF"));
                vo.setNome(rs.getString("Nome"));
                vo.setId(rs.getInt("id"));
                vo.setCrm(rs.getNString("CRM"));
                vo.setValorconsulta(rs.getFloat("vConsulta"));
                vo.setEndereco(rs.getNString("endereço"));
                medicos.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }

    /* método de edição do dado Nome da tabela Medico */
    public void editarNome(MedicoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update medico set nome = ? where id = ?"; /* comando de edição em SQL para o DB. */
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

    /* método de edição do dado CPF da tabela Medico */
    public void editarCpf(MedicoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update medico set cpf = ? where id = ?"; /* comando de edição em SQL para o DB. */
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

    /* método de edição do dado CRM da tabela Medico */
    public void editarCrm(MedicoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update medico set crm = ? where id = ?"; /* comando de edição em SQL para o DB. */
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setString(1, vo.getCrm());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* método de edição do dado Endereco da tabela Medico */
    public void editarEndereco(MedicoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update medico set endereco = ? where id = ?"; /* comando de edição em SQL para o DB. */
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

    /* método de edição do dado ValorConsulta da tabela Medico */
    public void editarVConsulta(MedicoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "update medico set consulta = ? where id = ?"; /* comando de edição em SQL para o DB. */
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setDouble(1, vo.getValorconsulta());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
