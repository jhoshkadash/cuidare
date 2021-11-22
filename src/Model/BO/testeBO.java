package Model.BO;

import java.util.List;

import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.Exception.UpdateException;
import Model.VO.ConsultaVO;
import Model.VO.PacienteVO;

public class testeBO {
    public static void main(String[] args) {
        AtendenteBO bo = new AtendenteBO();
        try {
            bo.EditarAltura("1.87", "84593402394");
            bo.EditarPeso("85.7", "84593402394");
            bo.EditarHistoricoDoencas("Cancer de pele", "84593402394");
            bo.EditarMediAlergicos("Bezetacil", "84593402394");
            bo.EditarMediAtuais("Ampliquitil, Oprazolam", "84593402394");
        } catch (UpdateException e) {
            System.out.println(e.getMessage());
        }
           /* List <ConsultaVO> consultas = bo.BuscarPacientePorCPF(vo);
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
