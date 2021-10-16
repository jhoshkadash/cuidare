package Model.DAO;

import Model.VO.*;
import java.sql.*;

public class LaudoDAO extends BaseDAO <LaudoVO>
/* declaração de classe para a criação de Laudos DAO implementados a MariaDB */
{
    /* método de inserção de laudos ao MariaDB */
    @Override
    public void Inserir (LaudoVO vo) throws SQLException {
            String sql = "inset into Laudo (obs, id_medico, id_consulta ,id_paciente ) values (?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setString(1, vo.getObservacoes());
            psts.setLong(2, vo.getIdMedico());
            psts.setLong(3, vo.getIdConsulta());
            psts.setLong(4, vo.getIdPaciente());
            int affectedRows = psts.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = psts.getGeneratedKeys();
            if(generatedKeys.next()){
                vo.setIdLaudo(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 
    }

    /* método de remoção de Usuarios ao MariaDB */
    @Override
    public void Deletar (LaudoVO vo) throws SQLException  {
        String sql = "delete from Laudo where id_laudo = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setDouble(1, vo.getIdLaudo());
        ptst.executeUpdate();
    }

    /* método de listagem de Usuarios ao MariaDB */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Laudo"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet ListarPorNome(PessoaVO vo) throws SQLException  {
        String sql = "select * from Pessoa where id = ?";
        PreparedStatement psts;
        ResultSet rs = null;

            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getNome());
            rs = psts.executeQuery();
        return rs;
    }


    @Override
    public ResultSet ListarPorId (LaudoVO vo) throws SQLException  {
        String sql = "select * from Laudo where id_laudo = ?";
        PreparedStatement psts;
        ResultSet rs = null;

            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdConsulta());
            rs = psts.executeQuery();
        return rs;
    }
    
    @Override
    public void Atualizar (LaudoVO vo) throws SQLException {
        String sql = "update Laudo set obs = ? where id_laudo = ?";
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1,vo.getObservacoes());
            psts.setLong(2, vo.getIdLaudo());
            psts.executeUpdate();
    }
}
