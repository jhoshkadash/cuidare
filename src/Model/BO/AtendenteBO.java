package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.AtendenteDAO;
import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.VO.AtendenteVO;

public class AtendenteBO implements BaseInterBO<AtendenteVO>{

    @Override
    public List<AtendenteVO> Buscar(AtendenteVO vo) {
        try {
            if(vo.getCpf() == null && vo.getNome() == null){
                throw new ListException("Insira pelo menos um filtro de busca");
            }
        } catch (ListException e) {
            e.getMessage();
        }
        
        List<AtendenteVO> listaAtendentes = new ArrayList<AtendenteVO>();
        AtendenteDAO dao = new AtendenteDAO(); 
        ResultSet rs = dao.ListarPorFiltro(vo);
        try {
            if(rs.next()){
                while(rs.next()){
                    AtendenteVO atendenteLista = new AtendenteVO();
                    atendenteLista.setCpf(rs.getString("cpf"));
                    atendenteLista.setNome(rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void Cadastrar(AtendenteVO vo) {
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
            if(vo.getTipo() != 1){ // verificando o tipo de usuário cadastrado
                throw new InsertException("Usuário informado não é do tipo ATENDENTE");
            }
        }catch(InsertException e){
            e.getMessage();
        }

        try{
            if(vo.getNome() == null){ // verirficando se existe dados no nome
                throw new InsertException("Atendente com nome vazio");
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
    public void Editar(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Excluir(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }
}
