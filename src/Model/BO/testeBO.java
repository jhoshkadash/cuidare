package Model.BO;

import java.util.List;

import Model.Exception.DeleteException;
import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.Exception.UpdateException;
import Model.VO.ConsultaVO;
import Model.VO.PacienteVO;
import Model.VO.UsuarioVO;

public class testeBO {
    public static void main(String[] args) {
        UsuarioBO bo = new UsuarioBO();
        try {
           UsuarioVO vo = bo.autenticar("jngoncalo", "batata");
        } catch (ListException e) {
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
