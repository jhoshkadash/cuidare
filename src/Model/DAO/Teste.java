package Model.DAO;

import Model.VO.PacienteVO;

public class Teste {
    public static void  main (String [] args){
        PacienteDAO pacienteDao = new PacienteDAO();
        PacienteVO pacienteVO = new PacienteVO("João", "08051823494", "Pedro Leite de Oliveira");
        pacienteDao.Inserir(pacienteVO);
        System.out.println(pacienteDao.Listar());
    }
}