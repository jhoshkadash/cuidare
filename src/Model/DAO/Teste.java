package Model.DAO;

import java.sql.SQLException;

import Model.VO.*;


public class Teste {
    public static void  main (String [] args){
        GerenteDAO gerenteDao = new GerenteDAO();
        GerenteVO gerenteVO = new GerenteVO("Ricardo Segundo", "22309413423", "ricardo", "123");
        try{
            gerenteDao.Inserir(gerenteVO);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}