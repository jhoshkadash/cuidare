package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import Model.VO.*;

public class Teste {
    public static void main(String[] args) throws SQLException {
        AtendenteDAO dao = new AtendenteDAO();
        AtendenteVO vo = new AtendenteVO("Maria", "93412452389", "mariazinha", "1234");
        AtendenteVO vo2 = new AtendenteVO("Creuza", "53426709545", "creuzaaaa", "45678");
        ResultSet rs = dao.ListarPorNome(vo);
        //listar atendente
        List <AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
        while (rs.next()){
            AtendenteVO aux = new AtendenteVO();
            aux.setCpf(rs.getString("CPF"));
            aux.setIdAtendente(rs.getLong("id_atendente"));
            aux.setIdPessoa(rs.getLong("id_atendente_pessoa"));
            aux.setIdUser(rs.getLong("id_atendente_user"));
            aux.setNome(rs.getString("nome"));
            atendentes.add(aux);//setando atributos e adicionando na lista
        }
        for(AtendenteVO vo3 : atendentes){
            System.out.println("nome : " + vo3.getNome());// exibindo o que foi armazenado na lista
        }
    }
}