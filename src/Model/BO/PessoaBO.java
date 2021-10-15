package Model.BO;

import Model.VO.*;
import java.sql.*;
import java.util.*;


import Model.DAO.*;

public class PessoaBO implements BaseInterBO <PessoaVO> {

    @Override
    public Void Cadastrar(PessoaVO vo ){
        PessoaDAO dao;
        try{
            dao.Inserir(vo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List <PessoaVO> Buscar(PessoaVO vo){
        PessoaDAO dao;
        List <PessoaVO> pessoas = new ArrayList<PessoaVO>();
        try{
            ResultSet  rs = dao.Listar();
            if (rs.next()){
                while(rs.next()){
                    vo.setNome(rs.getString("nome"));
                    vo.setCpf(rs.getString("cpf"));
                    vo.setIdPessoa(rs.getLong("id"));
                }

            }
        }

    }
    
    public void Editar(vo entity);
    public void Excluir(vo entity);
    
}
