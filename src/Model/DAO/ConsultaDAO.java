package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO extends BaseDAO {
    public void inserir(ConsultaVO vo) {
        conn = getConnection();
        String sql = "insert into Consulta(Id,Data,Hora,Status,IdMedico,IdPaciente) values (?,?,?,?,?,?)";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, vo.getId());
            /*
             * ptst.setTime(2, vo.getData()); //não consegui referenciar os dados do tipo
             * calendar ptst.setTime(3, vo.getHora()); //não consegui referenciar os dados
             * do tipo calendar
             */
            ptst.setBoolean(4, vo.isStatus());
            ptst.setNString(5, vo.getIdMedico());
            ptst.setNString(6, vo.getIdPaciente());
            ptst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerById(ConsultaVO vo) {
        conn = getConnection();
        String sql = "delete from Consulta where Id = ?";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, vo.getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
