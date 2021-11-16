package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.MedicoDAO;
import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.VO.MedicoVO;

public class MedicoBO{

    public List<MedicoVO> Buscar(MedicoVO vo) throws SQLException {
        try {
            if(vo.getCpf() == null && vo.getNome() == null){
                throw new ListException("Insira pelo menos um filtro de busca");
            }
        } catch (ListException e) {
            e.getMessage();
        }
        
        List<MedicoVO> listaMedicos = new ArrayList<MedicoVO>();
        MedicoDAO dao = new MedicoDAO(); 
        ResultSet rs = dao.ListarPorCrm(vo);
        try {
            if(rs.next()){
                while(rs.next()){
                    MedicoVO medicoLista = new MedicoVO();
                    medicoLista.setCpf(rs.getString("cpf"));
                    medicoLista.setNome(rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void Cadastrar(MedicoVO vo) {
        try{
            if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
                throw new InsertException("CPF inválido, possui mais de 11 digitos, não escreva ponto e nem linhas");
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
            if(vo.getTipo() != 2){ // verificando o tipo de usuário cadastrado
                throw new InsertException("Usuário informado não é do tipo MÉDICO");
            }
        }catch(InsertException e){
            e.getMessage();
        }

        try{
            if(vo.getNome() == null){ // verirficando se existe dados no nome
                throw new InsertException("Médico com nome vazio");
            }

        }catch(InsertException e){
            e.getMessage();
        }

        try {
            if(vo.getSenha().length() < 6){ // definindo tamanho mínimo de senha
                throw new InsertException("A senha deve conter no mínimo 6 caracteres");
            }
        } catch (InsertException e) {
            e.getMessage();
        }   
    }

    @Override
    public void Editar(MedicoVO vo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Excluir(MedicoVO vo) {
        // TODO Auto-generated method stub
        
    }  
}