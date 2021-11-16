package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Model.DAO.PacienteDAO;
import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.VO.AtendenteVO;
import Model.VO.ConsultaVO;
import Model.VO.PacienteVO;
import javafx.scene.chart.PieChart;

public class AtendenteBO{

    public void CadastrarPaciente(PacienteVO vo) throws InsertException {
            if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
                throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
            }
            if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
                throw new InsertException("CPF está vazio");
            }
            if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
                throw new InsertException("CPF só pode conter números");
            }
            if(vo.getNome() == null || vo.getNome() == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com nome vazio");
            }
            if(vo.getEndereco() == null || vo.getEndereco() == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com endereço vazio");
            } 
            else {
                    PacienteDAO dao = new PacienteDAO();
                    ResultSet rs;
                    try {
                        rs = dao.ListarPorNome(vo);
                        if(rs.next()){
                            throw new InsertException("Paciente com mesmo nome já cadastrado");
                        } else{
                            dao.Inserir(vo);
                        }
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } 
    
    public void MarcarConsulta (ConsultaVO vo) throws InsertException {
        if(vo.getDataConsulta() == null){
          throw new InsertException("Data não informada");
        }
        if(vo.getIdMedico() == null){
            throw new InsertException("Médico não definido");
        }
        if(vo.getIdPaciente() == null){
            throw new InsertException("Paciente não definido");
        }


    }


    public List <PacienteVO> BuscarPacientePorCPF (PacienteVO vo) throws ListException {
        if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new ListException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
            throw new ListException("CPF está vazio");
        }
        if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new ListException("CPF só pode conter números");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <PacienteVO> pacientes = new ArrayList<PacienteVO>();
            PacienteDAO dao = new PacienteDAO();
            try {
                rs = dao.ListarPorCpf(vo);
                    while(rs.next()){
                        PacienteVO pacienteVO = new PacienteVO();
                        pacienteVO.setCpf(rs.getString("CPF"));
                        pacienteVO.setEndereco(rs.getString("endereco"));
                        pacienteVO.setNome(rs.getString("nome"));
                        pacienteVO.setIdPaciente(rs.getLong("id_paciente"));
                        pacienteVO.setIdPessoa(rs.getLong("id_paciente_pessoa"));
                        pacientes.add(pacienteVO);

                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return pacientes;
        }
    }

    public void Editar(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }

    public void Excluir(AtendenteVO vo) {
        // TODO Auto-generated method stub
        
    }
}
