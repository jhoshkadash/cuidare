package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.DAO.GerenteDAO;
import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.VO.GerenteVO;
import javafx.geometry.Insets;

public class GerenteBO{

    @Override
    public List <GerenteVO> Buscar (GerenteVO vo) {
        try {
            if(vo.getCpf() == null && vo.getNome() == null){
                throw new ListException("Insira pelo menos um filtro de busca");
            }
        } catch (ListException e) {
            e.getMessage();
        }
        
        List<GerenteVO> listaGerentes = new ArrayList<GerenteVO>();
        GerenteDAO dao = new GerenteDAO(); 
        ResultSet rs = dao.ListarPorFiltro(vo);
        try {
            if(rs.next()){
                while(rs.next()){
                    GerenteVO gerenteLista = new GerenteVO();
                    gerenteLista.setCpf(rs.getString("cpf"));
                    gerenteLista.setNome(rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void Cadastrar(GerenteVO vo) {
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
            if(vo.getTipo() != 3){ // verificando o tipo de usuário cadastrado
                throw new InsertException("Usuário informado não é do tipo GERENTE");
            }
        }catch(InsertException e){
            e.getMessage();
        }

        try{
            if(vo.getNome() == null){ // verirficando se existe dados no nome
                throw new InsertException("Gerente com nome vázio");
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
    public void Editar(GerenteVO vo){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Excluir(GerenteVO vo) {
        // TODO Auto-generated method stub
        
    }
}
