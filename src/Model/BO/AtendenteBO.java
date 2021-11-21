package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DAO.ConsultaDAO;
import Model.DAO.MedicoDAO;
import Model.DAO.PacienteDAO;
import Model.DAO.ProntuarioDAO;
import Model.Exception.InsertException;
import Model.Exception.ListException;
import Model.VO.ConsultaVO;
import Model.VO.MedicoVO;
import Model.VO.PacienteVO;
import Model.VO.ProntuarioVO;

public class AtendenteBO{

    public void CadastrarPaciente(String nome, String cpf, String endereco) throws InsertException {
            if(cpf.length() != 11){ // verificando se a string de cpf possui 11 digitos
                throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
            }
            if(cpf == null){
                throw new InsertException("CPF está vazio");
            }
            if(cpf.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
                throw new InsertException("CPF só pode conter números");
            }
            if(nome == null || nome == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com nome vazio");
            }
            if(endereco == null || endereco == ""){ // verirficando se existe dados no nome
                throw new InsertException("Paciente com endereço vazio");
            } 
            else {
                    PacienteVO vo = new PacienteVO(nome, cpf, endereco);
                    PacienteDAO dao = new PacienteDAO();
                    ResultSet rs;
                    try {
                        rs = dao.ListarPorCpf(vo);
                        if(rs.next()){
                            throw new InsertException("Paciente com mesmo cpf já cadastrado");
                        } else{
                            dao.Inserir(vo);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } 
    

    public void CriarProntuario(String cpfPaciente, String altura, String peso, String mediAlergico, String mediAtuais, String historicoDoencas, String antePato, String dataNascimento) throws InsertException {
        Float pesoF = Float.valueOf(peso).floatValue(); Float alturaF = Float.valueOf(altura).floatValue() ;
        PacienteVO paciente = new PacienteVO("", cpfPaciente, "");
        PacienteDAO pacienteD = new PacienteDAO();
        
        try {
            ResultSet rs;
            rs = pacienteD.ListarPorCpf(paciente);
            if(rs.next()){
                paciente.setIdPaciente(rs.getLong("id_paciente"));
                paciente.setIdPessoa(rs.getLong("id_paciente_pessoa"));
            }else{
                throw new InsertException("Nenhum paciente encontrado com esse cpf");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if(alturaF == null || alturaF == 0 || alturaF < 0){
            throw new InsertException("Altura não informada ou inválida");
        }
        if(dataNascimento == null || dataNascimento == ""){
            throw new InsertException("Data de nascimento não informada");
        }
        if(pesoF == null || pesoF == 0 || pesoF < 0){
            throw new InsertException("Peso não informado ou inválido");
        }
        if(paciente.getIdPaciente() == null){
            throw new InsertException("Paciente informado sem id cadastrado");
        }

        else{
            ProntuarioVO vo = new ProntuarioVO(dataNascimento, antePato, mediAtuais, mediAlergico, pesoF, alturaF, historicoDoencas, paciente.getIdPaciente());
            ProntuarioDAO dao = new ProntuarioDAO();
            try {
                dao.Inserir(vo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void MarcarConsulta (String dataConsulta, String cpfPaciente, String nomeMedico) throws InsertException {
        if(dataConsulta == null){
          throw new InsertException("Data não informada");
        }
        if(nomeMedico == null || nomeMedico == ""){ // verirficando se existe dados no nome
            throw new InsertException("Paciente com nome vazio");
        }
        if(cpfPaciente.length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(cpfPaciente == null){
            throw new InsertException("CPF está vazio");
        }
        if(cpfPaciente.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new InsertException("CPF só pode conter números");
        }else{
        try {
            PacienteVO paciente = new PacienteVO("", cpfPaciente, "");
            MedicoVO medico = new MedicoVO(nomeMedico, "", "", "", "", null, "");
            PacienteDAO pacienteD = new PacienteDAO();
            MedicoDAO medicoD = new MedicoDAO();
            ResultSet rs;
            rs = pacienteD.ListarPorCpf(paciente);
            if(rs.next()){
                paciente.setNome(rs.getString("nome"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setIdPaciente(rs.getLong("id_paciente"));
                paciente.setIdPessoa(rs.getLong("id_paciente_pessoa"));
                }
            rs = medicoD.ListarPorNome(medico);
            if(rs.next()){
                medico.setNome(rs.getString("nome"));
                medico.setCrm(rs.getString("crm"));
                medico.setValorConsulta(rs.getDouble("valorconsulta"));
                medico.setIdMedico(rs.getLong("id_medico"));
                medico.setIdPessoa(rs.getLong("id_medico_pessoa"));
                medico.setIdUser(rs.getLong("id_medico_user"));
            }

            ConsultaVO consulta = new ConsultaVO(medico.getIdMedico(), paciente.getIdPaciente(), false, dataConsulta);
            ConsultaDAO dao = new ConsultaDAO();
            dao.Inserir(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    }


    public void EditarNomePaciente (String cpf, String nomeNovo) throws InsertException{
        if(cpf.length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(cpf == null){
            throw new InsertException("CPF está vazio");
        }
        if(cpf.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new InsertException("CPF só pode conter números");
        }
        if(nomeNovo == null || nomeNovo == ""){ // verirficando se existe dados no nome
            throw new InsertException("Paciente com nome vazio");
        }else{
            PacienteVO vo = new PacienteVO(nomeNovo, cpf, "");
            PacienteDAO dao = new PacienteDAO();
            try{
                dao.AtualizarNome(vo);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    public List <PacienteVO> BuscarPacientePorCPF (String cpf) throws ListException {
        if(cpf.length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new ListException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(cpf == null){ // verificando se existe dados dentro do cpf
            throw new ListException("CPF está vazio");
        }
        if(cpf.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new ListException("CPF só pode conter números");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <PacienteVO> pacientes = new ArrayList<PacienteVO>();
            PacienteDAO dao = new PacienteDAO();
            PacienteVO vo = new PacienteVO("", cpf, "");
            try {
                rs = dao.ListarPorCpf(vo);
                    while(rs.next()){
                        vo.setEndereco(rs.getString("endereco"));
                        vo.setNome(rs.getString("nome"));
                        vo.setIdPaciente(rs.getLong("id_paciente"));
                        vo.setIdPessoa(rs.getLong("id_paciente_pessoa"));
                        pacientes.add(vo);

                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return pacientes;
        }
    }

    public List <MedicoVO> BuscarMedicoPorCpf (String cpf) throws ListException {
        if(cpf.length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new ListException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(cpf == null){ // verificando se existe dados dentro do cpf
            throw new ListException("CPF está vazio");
        }
        if(cpf.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new ListException("CPF só pode conter números");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <MedicoVO> medicos = new ArrayList<MedicoVO>();
            MedicoDAO dao = new MedicoDAO();
            MedicoVO medicoVO = new MedicoVO("", cpf, "", "", "", 0d, "");
            try {
                rs = dao.ListarPorCpf(medicoVO);
                    while(rs.next()){
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
    public List <ProntuarioVO> BuscarProntuario (String cpfPaciente) throws ListException {
            ResultSet rs;
            List <ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
            List <PacienteVO> pacientes = new ArrayList<PacienteVO>();
            PacienteDAO dao = new PacienteDAO();
            ProntuarioDAO prontDao = new ProntuarioDAO();
            PacienteVO paciente = new PacienteVO("", cpfPaciente, "");
            try {
                rs = dao.ListarPorCpf(paciente);
                while(rs.next()){
                    paciente.setIdPaciente(rs.getLong("id_paciente"));
                    paciente.setIdPessoa(rs.getLong("id_paciente_pessoa"));
                    pacientes.add(paciente);
                }    
                rs = prontDao.ListarPorPaciente(paciente);
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
                        prontuarios.add(prontuarioVO); 
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return prontuarios;
        }
    }
    
