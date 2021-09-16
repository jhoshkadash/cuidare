package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

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
            ptst.setInt(5, vo.getIdMedico());
            ptst.setInt(6, vo.getIdPaciente());
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
        /* criação do método de listagem de consultas */
        public List<ConsultaVO> listar() {
            conn = getConnection(); //conexão estabelecida
            String sql = "select * from consulta"; /* comando de listagem em SQL para o DB. */
            Statement st;
            ResultSet rs;
            List<ConsultaVO> consultas = new ArrayList<ConsultaVO>(); //criação da ArrayList de Consultas
            try {
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    ConsultaVO vo = new ConsultaVO();
                    vo.setIdMedico(rs.getInt("id medico"));
                    vo.setIdPaciente(rs.getInt("id paciente"));
                    vo.setId(rs.getInt("id"));
                    vo.setStatus(rs.getBoolean("status"));
                    consultas.add(vo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return consultas;
        }
}
