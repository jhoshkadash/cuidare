package Model.DAO;

import Model.VO.*;
import java.sql.*;
import java.util.Date;

public class ProntuarioDAO extends BaseDAO <ProntuarioVO>
/* declaração de classe para a criação de Prontuarios DAO implementados a MariaDB */
{
    /* método de inserção de prontuários */
    @Override
    public void Inserir (ProntuarioVO vo) throws SQLException{
            String sql = "insert into Prontuario ( data_nascimento, ante_patologico, medi_atuais, medi_alergicos, historico_doenças, peso, altura, id_prontuario_paciente) values (?,?,?,?,?,?,?,?)";
            PreparedStatement psts;
            psts = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psts.setDate(1, vo.getDataNascimentoDao());
            psts.setString(2, vo.getAntenPatologico());
            psts.setString(3, vo.getMediAtuais());
            psts.setString(4, vo.getMediAlergia());
            psts.setString(5, vo.getHistoricoDoenca());
            psts.setFloat(6, vo.getPeso());
            psts.setFloat(7, vo.getAltura());
            psts.setLong(8, vo.getIdPaciente());
            
            int affectedRows = psts.executeUpdate(); //variável para verificação de alterações na tabela
            
            if (affectedRows == 0){ // verificação de alteração
                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
            }
            
            ResultSet generatedKeys = psts.getGeneratedKeys(); //Id retornado da tabela
            
            if(generatedKeys.next()){ //caso nenhum seja id retornado, será inserido ao prontuário, caso não, a falha é exibida
                vo.setIdProntuario(generatedKeys.getLong(1));
            } else{
                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
            } 
        }

    /* método de remoção de Usuarios */
    @Override
    public void Deletar (ProntuarioVO vo) throws SQLException{
        String sql = "delete from Prontuario where id_prontuario = ?"; /* comando de remoção em SQL para o DB. */
        PreparedStatement ptst;
        ptst = getConnection().prepareStatement(sql);
        ptst.setLong(1, vo.getIdProntuario());
        ptst.executeUpdate();
    }

    /* método de listagem de Usuarios */
    @Override
    public ResultSet Listar() throws SQLException {
        String sql = "select * from Prontuario"; /* comando de listagem em SQL para o DB. */
        Statement st;
        ResultSet rs = null;
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
    }

     /* método de listagem de prontuário por Id */
    @Override
    public ResultSet ListarPorId (ProntuarioVO vo) throws SQLException {
        String sql = "select * from Prontuario where id_prontuario = ?"; /* comando de listagem por Id. */
        PreparedStatement psts;
        ResultSet rs = null;
            psts = getConnection().prepareStatement(sql);
            psts.setLong(1, vo.getIdProntuario());
            rs = psts.executeQuery();
        return rs;
    }

    public ResultSet ListarPorPaciente(PacienteVO vo) {
        String sql = "SELECT * FROM Pessoa LEFT JOIN Paciente ON Paciente.id_paciente_pessoa = Pessoa.id LEFT JOIN Prontuario on Paciente.id_paciente = Prontuario.id_prontuario_paciente WHERE pessoa.cpf = ?"; /*comando sql */
        PreparedStatement psts;
        ResultSet rs = null;

        try {
            psts = getConnection().prepareStatement(sql);
            psts.setString(1, vo.getCpf());
            rs = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs; 
    }
    
    /* método de atualização de dados de prontuários */
    @Override
    public void Atualizar (ProntuarioVO vo) throws SQLException {
        String sql = "update Prontuario set peso = ? where id_prontuario = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setFloat(1,vo.getPeso());
            psts.setLong(2, vo.getIdProntuario());
            psts.executeUpdate();
    }
    
    public void AtualizarDataNascimento (ProntuarioVO vo) throws SQLException {
        String sql = "UPDATE Prontuario SET data_nascimento = ? WHERE id_prontuario_paciente = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setDate(1,vo.getDataNascimentoDao());
            psts.setLong(2, vo.getIdPaciente());
            psts.executeUpdate();
    }
    
    public void AtualizarAntePato (ProntuarioVO vo) throws SQLException {
        String sql = "UPDATE Prontuario SET ante_patologico = ? WHERE id_prontuario_paciente = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1,vo.getAntenPatologico());
            psts.setLong(2, vo.getIdPaciente());
            psts.executeUpdate();
    }
    
    public void AtualizarMediAtuais (ProntuarioVO vo) throws SQLException {
        String sql = "UPDATE Prontuario SET medi_atuais = ? WHERE id_prontuario_paciente = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1,vo.getMediAtuais());
            psts.setLong(2, vo.getIdPaciente());
            psts.executeUpdate();
    }

    public void AtualizarMediAlergicos (ProntuarioVO vo) throws SQLException {
        String sql = "UPDATE Prontuario SET medi_alergicos = ? WHERE id_prontuario_paciente = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1,vo.getMediAlergia());
            psts.setLong(2, vo.getIdPaciente());
            psts.executeUpdate();
    }
    
    public void AtualizarHistoricoDoencas (ProntuarioVO vo) throws SQLException {
        String sql = "UPDATE Prontuario SET historico_doenças = ? WHERE id_prontuario_paciente = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setString(1,vo.getHistoricoDoenca());
            psts.setLong(2, vo.getIdPaciente());
            psts.executeUpdate();
    }
    
    public void AtualizarPeso (ProntuarioVO vo) throws SQLException {
        String sql = "UPDATE Prontuario SET peso = ? WHERE id_prontuario_paciente = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setFloat(1,vo.getPeso());
            psts.setLong(2, vo.getIdPaciente());
            psts.executeUpdate();
    }

    public void AtualizarAltura (ProntuarioVO vo) throws SQLException {
        String sql = "UPDATE Prontuario SET altura = ? WHERE id_prontuario_paciente = ?"; /* comando de atualização (update) em SQL. */
        PreparedStatement psts;
            psts = getConnection().prepareStatement(sql);
            psts.setFloat(1,vo.getAltura());
            psts.setLong(2, vo.getIdPaciente());
            psts.executeUpdate();
    } 
}
