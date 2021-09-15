package Model.DAO;

import Model.VO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO extends BaseDAO 
/* declaração de classe para a criação de Consultas DAO implementadas a MariaDB */
{
    public void inserir(ConsultaVO vo)
    /* método de inserção de dados de Consulta ao DB */
    {
        conn = getConnection(); //conexão estabelecida
        String sql = "insert into Consulta(Id,Data,Hora,Status,IdMedico,IdPaciente) values (?,?,?,?,?,?)"; /* comando de inserção em SQL para o DB. */
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

    public void removerById(ConsultaVO vo)
    /* método de remoção de dados da Consulta ao DB */
    {
        conn = getConnection(); //conexão estabelecida
        String sql = "delete from Consulta where Id = ?"; /* comando de remoção em SQL para o DB. */
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
