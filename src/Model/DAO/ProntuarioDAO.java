package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class ProntuarioDAO extends BaseDAO {
    public void inserir(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "insert into Prontuario(dataNascimento,antenPatologico,mediAtuais,mediAlergia,peso,altura,historicoDoenca,idPaciente) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            /*
             * ptst.setDate(1, vo.getDataNascimento()); //não consegui referenciar os dados
             * do tipo calendar
             */
            ptst.setNString(2, vo.getAntenPatologico());
            ptst.setNString(3, vo.getMediAtuais());
            ptst.setNString(4, vo.getMediAlergia());
            ptst.setFloat(5, vo.getPeso());
            ptst.setFloat(6, vo.getAltura());
            ptst.setNString(7, vo.getHistoricoDoenca());
            ptst.setNString(8, vo.getIdPaciente());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerById(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "delete from Prontuario where IdPaciente = ?";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getIdPaciente());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // listar prontuarios
    public List<ProntuarioVO> listar() {
        conn = getConnection();
        String sql = "select * from prontuario";
        Statement st;
        ResultSet rs;
        List<ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ProntuarioVO vo = new ProntuarioVO();
                vo.setAltura(rs.getFloat("altura"));
                vo.setPeso(rs.getFloat("peso"));
                vo.setAntenPatologico(rs.getNString("antepatologico"));
                vo.setHistoricoDoenca(rs.getNString("historicodoenca"));
                vo.setMediAlergia(rs.getNString("alergia"));
                vo.setMediAtuais(rs.getNString("medicamentos"));
                /*
                 * vo.setDataNascimento(rs.get); // dificuldade para referenciar CALENDAR
                 */
                prontuarios.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuarios;
    }
    //editar altura
    public void editarAltura(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "update prontuario set altura = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setFloat(1, vo.getAltura());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //editar peso
    public void editarPeso(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "update prontuario set peso = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setFloat(1, vo.getPeso());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //editar antecedentes patologicos
    public void editarAntePato(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "update prontuario set antenPatologico = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setNString(1, vo.getAntenPatologico());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //editar medicamentos atuais
    public void editarMediAtuais(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "update prontuario set mediAtuais = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setNString(1, vo.getMediAtuais());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //editar medicamentos alergicos
    public void editarMediAlergia(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "update prontuario set mediAlergia = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setNString(1, vo.getAntenPatologico());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //editar historico de doenças
    public void editarHistoricoDoencas(ProntuarioVO vo) {
        conn = getConnection();
        String sql = "update prontuario set HistoricoDoenca = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setNString(1, vo.getHistoricoDoenca());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
