package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Model.DAO.*;
import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.VO.*;
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

    public List <MedicoVO> BuscarMedicoPorCpf (MedicoVO vo) throws ListException {
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
            List <MedicoVO> medicos = new ArrayList<MedicoVO>();
            MedicoDAO dao = new MedicoDAO();
            try {
                rs = dao.ListarPorCpf(vo);
                    while(rs.next()){
                        MedicoVO medicoVO = new MedicoVO();
                        medicoVO.setCpf(rs.getString("CPF"));
                        medicoVO.setNome(rs.getString("nome"));
                        medicoVO.setEndereco(rs.getString("endereco"));
                        medicoVO.setCrm(rs.getString("crm"));
                        medicos.add(medicoVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return medicos;
        }
    }

    public List <ProntuarioVO> BuscarProntuario (ProntuarioVO vo) throws ListException {
            ResultSet rs;
            List <ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
            ProntuarioDAO dao = new ProntuarioDAO();
            try {
                rs = dao.ListarPorId(vo);
                    while(rs.next()){
                        ProntuarioVO prontuarioVO = new ProntuarioVO();
                        prontuarioVO.setIdPaciente(rs.getLong("id_paciente"));
                        prontuarioVO.setIdProntuario(rs.getLong("id_prontuario"));
                        prontuarioVO.setPeso(rs.getFloat("peso"));
                        prontuarioVO.setAltura(rs.getFloat("altura"));
                        prontuarioVO.setAntenPatologico(rs.getString("ante_patologico"));
                        prontuarioVO.setHistoricoDoenca(rs.getString("historico_doenças"));
                        prontuarioVO.setMediAlergia(rs.getString("medi_alergicos"));
                        prontuarioVO.setMediAtuais(rs.getString("medi_atuais"));
                        prontuarios.add(prontuarioVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return prontuarios;
        }
    }
    
}
