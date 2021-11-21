package Model.BO;

import java.util.List;

import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.Exception.UpdateException;
import Model.VO.PacienteVO;

public class testeBO {
    public static void main(String[] args) {
        AtendenteBO bo = new AtendenteBO();
        try {
            bo.EditarDataNascimento("28/07/1999", "84593402394");    
        } catch (UpdateException e) {
            e.getMessage();
        }
        
        /*try {
            List <PacienteVO> pacientes = bo.BuscarPacientePorCPF(vo);
            for (PacienteVO aux : pacientes ){
                System.out.println("Nome do paciente : " + aux.getNome());
                System.out.println("CPf do paciente : " + aux.getCpf());
                System.out.println("Endereço do paciente : " + aux.getEndereco());
                System.out.println("Id do paciente : " + aux.getIdPaciente());
                System.out.println("Id de pessoa : " + aux.getIdPessoa());
            }
        } catch (ListException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        
    }
}
