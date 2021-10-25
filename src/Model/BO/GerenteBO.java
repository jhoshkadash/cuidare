package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Exception.InsertException;
import Model.VO.GerenteVO;
import javafx.geometry.Insets;

public class GerenteBO implements BaseInterBO <GerenteVO>{

    @Override
    public List <GerenteVO> Buscar (GerenteVO vo) {
        ResultSet rs = null;
        ArrayList listaGerentes = new ArrayList<GerenteVO>();
        return rs;
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
            if(vo.getTipo() != 3){
                throw new InsertException("Usuário informado não é do tipo GERENTE");
            }
        }catch(InsertException e){
            e.getMessage();
        }

        try{
            if(vo.getCpf() == null){
                throw new InsertException("CPF está vazio");
            }
        } catch (InsertException e){
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
