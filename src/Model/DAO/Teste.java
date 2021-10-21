package Model.DAO;

import java.sql.SQLException;

import Model.VO.*;

public class Teste {
    public static void main(String[] args) {
        GerenteDAO dao = new GerenteDAO();
        GerenteVO vo = new GerenteVO("João Neto", "08051823494", "jngoncalo", "batata");
        PacienteDAO pacienteDAO = new PacienteDAO();
        PacienteVO pacienteVO = new PacienteVO("Francineide", "34574325689", "rua das palmeiras");
  
        try {
            pacienteDAO.Deletar(pacienteVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dao.Inserir(vo);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}