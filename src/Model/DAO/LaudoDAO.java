package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class LaudoDAO extends BaseDAO {
    // Isenrir um Laudo
    public void inserir(LaudoVO vo) {
        conn = getConnection();
        String sql = "insert into Laudo(IdMedico,IdPAciente,IdConsulta,Observacoes) values (?,?,?,?)";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getIdMedico());
            ptst.setNString(2, vo.getIdPaciente());
            ptst.setNString(3, vo.getIdConsulta());
            ptst.setNString(4, vo.getObservacoes());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remover um Laudo
    public void removerById(LaudoVO vo) {
        conn = getConnection();
        String sql = "delete from Laudo where IdMedico = ?";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getIdMedico());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // listar laudos
    public List<LaudoVO> listar() {
        conn = getConnection();
        String sql = "select * from laudo";
        Statement st;
        ResultSet rs;
        List<LaudoVO> laudos = new ArrayList<LaudoVO>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                LaudoVO vo = new LaudoVO();
                vo.setIdMedico(rs.getString("idMedico"));
                vo.setIdPaciente(rs.getString("idPaciente"));
                vo.setObservacoes(rs.getString("obs"));
                laudos.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laudos;
    }
}
