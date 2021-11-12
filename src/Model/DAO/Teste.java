package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Model.VO.*;

public class Teste {
    public static void main(String[] args) throws SQLException {
        ConsultaDAO dao = new ConsultaDAO();
        ConsultaVO vo2 = new ConsultaVO(2l, 5l, false, "15/11/2021 16:00");
        PacienteVO vo = new PacienteVO("Claudinho do pneu", "cpf", "endereco");

        //listar atendente
        List <ConsultaVO> consultas = new ArrayList<ConsultaVO>();
        ResultSet rs = dao.ListarPorNomePaciente(vo);
        while (rs.next()){
            ConsultaVO aux = new ConsultaVO();
            aux.setDataConsulta(rs.getString("data"));
            aux.setIdConsulta(rs.getLong("id_consulta"));
            aux.setIdMedico(rs.getLong("id_medico"));
            aux.setIdPaciente(rs.getLong("id_paciente"));
            aux.setStatus(rs.getBoolean("status"));
            consultas.add(aux);//setando atributos e adicionando na lista
        }
        for(ConsultaVO vo3 : consultas){
            System.out.println("data da consulta : " + vo3.getDataConsulta());// exibindo o que foi armazenado na lista
            System.out.println("id consulta : " + vo3.getIdConsulta());
        }
        
    }
}
