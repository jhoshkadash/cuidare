package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.*;

public class LaudoDAO extends BaseDAO
/* declaração de classe para a criação de Laudos DAO implementados a MariaDB */
{
    /* método de inserção de laudos ao MariaDB */
    public void inserir(LaudoVO vo)
    {
        conn = getConnection(); //conexão estabelecida
        String sql = "insert into Laudo(IdMedico,IdPAciente,IdConsulta,Observacoes) values (?,?,?,?)"; /* comando de inserção em SQL para o DB. */
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

    /* método de remoção de dados de Laudo do DB */
    public void removerById(LaudoVO vo) {
        conn = getConnection(); //conexão estabelecida
        String sql = "delete from Laudo where IdMedico = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNString(1, vo.getIdMedico());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* criação do método de listagem de Laudos */
    public List<LaudoVO> listar() {
        conn = getConnection(); //conexão estabelecida
        String sql = "select * from laudo"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs;
        List<LaudoVO> laudos = new ArrayList<LaudoVO>(); //criação da ArrayList de Laudos
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
    //Editar observações
    public void editarObs(LaudoVO vo) {
        conn = getConnection();
        String sql = "update laudo set obs = ? where id = ?";
        PreparedStatement psts;
        try {
            psts = conn.prepareStatement(sql);
            psts.setString(1, vo.getObservacoes());
            psts.setInt(2, vo.getId());
            psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
