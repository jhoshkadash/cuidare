package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.VO.*;

public class Teste {
    public static void main(String[] args) {
        GerenteDAO dao = new GerenteDAO();
        GerenteVO vo = new GerenteVO("João Neto", "08051823494", "jngoncalo", "batata");
        ResultSet rs = null;
        try {
           rs = dao.ListarPorNome(vo);
           while(rs.next()){
               GerenteVO gerente = new GerenteVO();
               gerente.setCpf(rs.getString("cpf"));
               gerente.setNome(rs.getString("nome"));
               gerente.setIdGerente(rs.getLong("id_gerente"));
               gerente.setIdPessoa(rs.getLong("id_gerente_pessoa"));
               gerente.setIdUser(rs.getLong("id_gerente_user"));
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}