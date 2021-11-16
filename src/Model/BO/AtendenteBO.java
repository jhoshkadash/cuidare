package Model.BO;

import Model.Exception.InsertException;
import Model.VO.AtendenteVO;
import Model.VO.PacienteVO;

public class AtendenteBO{

    public void CadastrarPaciente(PacienteVO vo) {
        try{
            if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
                throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
            }
        } catch (InsertException e){
            e.getMessage();
        }

        try{
            if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
                throw new InsertException("CPF está vazio");
            }
        } catch (InsertException e){
            e.getMessage();
        }

        try {
            if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
                throw new InsertException("CPF só pode conter números");
            }
        } catch (InsertException e) {
            e.getMessage();
        }

        try{
            if(vo.getNome() == null && vo.getNome() == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com nome vazio");
            }

        }catch(InsertException e){
            e.getMessage();
        }
        try {
        } catch (Exception e) {
            //TODO: handle exception
        }
        try{
            if(vo.getEndereco() == null && vo.getEndereco() == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com endereço vazio");
            }

        }catch(InsertException e){
            e.getMessage();
        } 
     
    }

    public void Editar(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }

    public void Excluir(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }
}
