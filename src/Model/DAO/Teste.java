package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Model.VO.*;

public class Teste {
    public static void main(String[] args) throws SQLException {
        PacienteDAO dao = new PacienteDAO();
        PacienteVO vo = new PacienteVO("Iara", "", "");
        //listar atendente
        List <PacienteVO> pronturaio = new ArrayList<PacienteVO>();
        ResultSet rs = dao.ListarPorNome(vo);
        while (rs.next()){
            PacienteVO aux = new PacienteVO();
            aux.setIdPaciente(rs.getLong("id_paciente"));
            aux.setCpf(rs.getString("cpf"));
            aux.setNome(rs.getString("nome"));
            aux.setIdPessoa(rs.getLong("id_paciente_pessoa"));
            pronturaio.add(aux);//setando atributos e adicionando na lista
        }
        for(PacienteVO vo3 : pronturaio){
            System.out.println("id pessoa : " + vo3.getIdPessoa());// exibindo o que foi armazenado na lista
            System.out.println("id paciente : " + vo3.getIdPaciente());
            System.out.println("nome : " + vo3.getNome());
            System.out.println("CPf : " + vo3.getCpf());
        }
        
    }
}
