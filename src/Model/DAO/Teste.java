package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Model.VO.*;

public class Teste {
    public static void main(String[] args) throws SQLException {
        ProntuarioDAO dao = new ProntuarioDAO();
        PacienteVO vo = new PacienteVO("Pedro Antonio", "34502328412", "Pedro leite");

        //listar atendente
        List <ProntuarioVO> pronturaio = new ArrayList<ProntuarioVO>();
        ResultSet rs = dao.ListarPorPaciente(vo);
        while (rs.next()){
            ProntuarioVO aux = new ProntuarioVO();
            aux.setAltura(rs.getFloat("altura"));;
            aux.setPeso(rs.getFloat("peso"));
            aux.setDataNascimentoDao(rs.getTimestamp("data_nascimento"));
            aux.setAntenPatologico(rs.getNString("ante_patologico"));
            aux.setHistoricoDoenca(rs.getString("historico_doenças"));
            aux.setIdPaciente(rs.getLong("id_prontuario_paciente"));
            aux.setIdProntuario(rs.getLong("id_prontuario"));
            aux.setMediAlergia(rs.getString("medi_alergicos"));
            aux.setMediAtuais(rs.getString("medi_atuais"));
            pronturaio.add(aux);//setando atributos e adicionando na lista
        }
        for(ProntuarioVO vo3 : pronturaio){
            System.out.println("id prontuario : " + vo3.getIdProntuario());// exibindo o que foi armazenado na lista
            System.out.println("id paciente : " + vo3.getIdPaciente());
            System.out.println("data nascimento : " + vo3.getDataNascimento());
        }
        
    }
}
