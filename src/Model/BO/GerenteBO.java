package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.*;
import Model.Exception.*;
import Model.VO.*;

public class GerenteBO {

    /* =============== MÉTODOS DE CADASTRO =============== */

    public void CadastrarMedico(String nome, String cpf, String endereco, String crm, String valorconsulta) throws InsertException {
        if(cpf.length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(cpf == null){
            throw new InsertException("CPF está vazio");
        }
        if(cpf.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new InsertException("CPF só pode conter números");
        }
        if(nome == null || nome == ""){ // verificando se existe dados no nome
            throw new InsertException("Médico com nome vazio");
        }
        if(endereco == null || endereco == " "){ // verificando se existe dados no endereço
            throw new InsertException("Médico com endereço vazio");
        } 
        if(crm == null || crm == " "){ // verificando se existe dados no crm
            throw new InsertException("Médico com CRM vazio");
        }
        if(valorconsulta == null || valorconsulta == " "){ // verificando se existe dados no valorconsulta
            throw new InsertException("Médico com valor de consulta não especificado");
        }
        else {
                Double valorConsultaD = Double.parseDouble(valorconsulta);
                MedicoVO vo = new MedicoVO(nome, cpf, endereco, crm, valorConsultaD);
                MedicoDAO dao = new MedicoDAO();
                ResultSet rs;
                try {
                    rs = dao.ListarPorCrm(vo);
                    if(rs.next()){
                        throw new InsertException("Médico com mesmo crm já cadastrado");
                    } else{
                        dao.Inserir(vo);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } 

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

            public void CadastrarAtendente(String nome, String cpf, String login, String senha) throws InsertException {
                if(cpf.length() != 11){ // verificando se a string de cpf possui 11 digitos
                    throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
                }
                if(cpf == null){
                    throw new InsertException("CPF está vazio");
                }
                if(cpf.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
                    throw new InsertException("CPF só pode conter números");
                }
                if(nome == null || nome == " "){ // verificando se existe dados no nome
                    throw new InsertException("Atendente com nome vazio");
                }
                if(login == null || login == " "){
                    throw new InsertException("Login não informado");
                }
                if(senha == null || senha.length() < 6){
                    throw new InsertException("Senha não informada ou muito curta. Tamanho mínimo de 6 caracteres para a senha");
                }
                else {
                        AtendenteVO vo = new AtendenteVO(nome, cpf, login, senha);
                        AtendenteDAO dao = new AtendenteDAO();
                        ResultSet rs;
                        try {
                            rs = dao.ListarPorCpf(vo);
                            if(rs.next()){
                                throw new InsertException("Atendente com mesmo cpf já cadastrado");
                            } else{
                                dao.Inserir(vo);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } 

                public void CadastrarGerente(String nome, String cpf, String login, String senha) throws InsertException {
                    if(cpf.length() != 11){ // verificando se a string de cpf possui 11 digitos
                        throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
                    }
                    if(cpf == null){
                        throw new InsertException("CPF está vazio");
                    }
                    if(cpf.matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
                        throw new InsertException("CPF só pode conter números");
                    }
                    if(nome == null || nome == ""){ // verificando se existe dados no nome
                        throw new InsertException("Gerente com nome vazio");
                    }
                    if(login == null || login == " "){
                        throw new InsertException("Login não informado");
                    }
                    if(senha == null || senha.length() < 6){
                        throw new InsertException("Senha não informada ou muito curta. Tamanho mínimo de 6 caracteres para a senha");
                    }
                    else {
                            GerenteVO vo = new GerenteVO(nome, cpf, login, senha);
                            GerenteDAO dao = new GerenteDAO();
                            ResultSet rs;
                            try {
                                rs = dao.ListarPorCpf(vo);
                                if(rs.next()){
                                    throw new InsertException("Gerente com mesmo cpf já cadastrado");
                                } else{
                                    dao.Inserir(vo);
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

    /* ============================================================= */

    /* ================ MÉTODOS DE EDITAR (CONSULTA) ================ */
    
    public void EditarDataConsulta(String idConsulta, String dataNova) throws UpdateException{
        if(idConsulta == null || idConsulta == " "){
            throw new UpdateException("Id da consulta não informado");
        }
        if(dataNova == null || dataNova == ""){
            throw new UpdateException("Data nova não informada");
        }
        Long idConsultaL = Long.parseLong(idConsulta); 
        ConsultaVO consulta = new ConsultaVO(0L, 0L, false, dataNova);
        consulta.setIdConsulta(idConsultaL);
        ConsultaDAO dao = new ConsultaDAO();
        try {
            ResultSet rs = dao.ListarPorId(consulta);
            if(rs.next()){ // consulta se a consulta informada existe
                consulta.setIdMedico(rs.getLong("id_medico"));
                consulta.setIdPaciente(rs.getLong("id_paciente"));
                consulta.setStatus(rs.getBoolean("status"));
                try {
                    rs = dao.ListarPorData(consulta);
                    if(rs.next()){ // consulta se já existe uma consulta do mesmo médico no horario
                        ConsultaVO aux = new ConsultaVO();
                        aux.setDataConsultaDao(rs.getTimestamp("data"));
                        aux.setIdConsulta(rs.getLong("id_consulta"));
                        aux.setIdMedico(rs.getLong("id_medico"));
                        aux.setIdPaciente(rs.getLong("id_paciente"));
                        aux.setStatus(rs.getBoolean("status"));
                        if(aux.getDataConsulta() == consulta.getDataConsulta() && aux.getIdMedico() == consulta.getIdMedico()){
                            throw new UpdateException("Consulta já marcada com o mesmo médico para o mesmo horário e data");
                        }else{
                            dao.AtualizarDataConsulta(consulta);
                        }
                    }else{
                        dao.AtualizarDataConsulta(consulta);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    /* ================ MÉTODOS DE BUSCA (PACIENTE) ================ */

    public List <PacienteVO> BuscarPacientePorNome (PacienteVO vo) throws Exception {
        if(vo.getNome() == null || vo.getNome() == ""){ // verirficando se existe dados no nome
            throw new Exception("Paciente com nome vazio");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <PacienteVO> pacientes = new ArrayList<PacienteVO>();
            PacienteDAO dao = new PacienteDAO();
            try {
                rs = dao.ListarPorNome(vo);
                    while(rs.next()){
                        PacienteVO pacienteVO = new PacienteVO();
                        pacienteVO.setCpf(rs.getString("CPF"));
                        pacienteVO.setEndereco(rs.getString("endereco"));
                        pacienteVO.setNome(rs.getString("nome"));
                        pacientes.add(pacienteVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return pacientes;
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
                        pacientes.add(pacienteVO);

                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return pacientes;
        }
    }

    /* =========================================================== */ 


    /* ================ MÉTODOS DE BUSCA (MÉDICO) ================ */    
    
    public List <MedicoVO> BuscarMedicoPorNome (MedicoVO vo) throws Exception {
        if(vo.getNome() == null || vo.getNome() == ""){ // verirficando se existe dados no nome
            throw new Exception("Médico com nome vazio");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <MedicoVO> medicos = new ArrayList<MedicoVO>();
            MedicoDAO dao = new MedicoDAO();
            try {
                rs = dao.ListarPorNome(vo);
                    while(rs.next()){
                        MedicoVO medicoVO = new MedicoVO();
                        medicoVO.setNome(rs.getString("nome"));
                        medicoVO.setCpf(rs.getString("CPF"));
                        medicoVO.setEndereco(rs.getString("endereco"));
                        medicoVO.setCrm(rs.getString("crm"));
                        medicoVO.setValorConsulta(rs.getDouble("valorconsulta"));
                        medicos.add(medicoVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return medicos;
        }
    }

    public List <MedicoVO> BuscarMedicoPorCpf (MedicoVO vo) throws Exception {
        if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new Exception("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
            throw new Exception("CPF está vazio");
        }
        if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new Exception("CPF só pode conter números");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <MedicoVO> medicos = new ArrayList<MedicoVO>();
            MedicoDAO dao = new MedicoDAO();
            try {
                rs = dao.ListarPorCpf(vo);
                    while(rs.next()){
                        MedicoVO medicoVO = new MedicoVO();
                        medicoVO.setNome(rs.getString("nome"));
                        medicoVO.setCpf(rs.getString("CPF"));
                        medicoVO.setEndereco(rs.getString("endereco"));
                        medicoVO.setCrm(rs.getString("crm"));
                        medicoVO.setValorConsulta(rs.getDouble("valorconsulta"));
                        medicos.add(medicoVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return medicos;
        }
    }

    public List <MedicoVO> BuscarMedicoPorCrm (MedicoVO vo) throws Exception {
        if(vo.getCrm() == null || vo.getCrm() == ""){ // verificando se existe dados de CRM cadastrados
            throw new Exception("Médico com CRM vazio");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <MedicoVO> medicos = new ArrayList<MedicoVO>();
            MedicoDAO dao = new MedicoDAO();
            try {
                rs = dao.ListarPorCrm(vo);
                    while(rs.next()){
                        MedicoVO medicoVO = new MedicoVO();
                        medicoVO.setNome(rs.getString("nome"));
                        medicoVO.setCpf(rs.getString("CPF"));
                        medicoVO.setEndereco(rs.getString("endereco"));
                        medicoVO.setCrm(rs.getString("crm"));
                        medicoVO.setValorConsulta(rs.getDouble("valorconsulta"));
                        medicos.add(medicoVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return medicos;
        }
    }

    /* =========================================================== */
    

    /* ================ MÉTODOS DE BUSCA (ATENDENTE) ================ */    

    public List <AtendenteVO> BuscarAtendentePorNome (String nome) throws Exception {
        if(nome == null || nome == ""){ // verirficando se existe dados no nome
            throw new Exception("Atendente com nome vazio");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
            AtendenteDAO dao = new AtendenteDAO();
            try {
                AtendenteVO  vo = new AtendenteVO();
                vo.setNome(nome);
                rs = dao.ListarPorNome(vo);
                    while(rs.next()){
                        vo.setNome(rs.getString("nome"));
                        vo.setCpf(rs.getString("CPF"));
                        atendentes.add(vo);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return atendentes;
        }
    } 

    public List <AtendenteVO> BuscarAtendentePorCpf (AtendenteVO vo) throws Exception {
        if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new Exception("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
            throw new Exception("CPF está vazio");
        }
        if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new Exception("CPF só pode conter números");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
            AtendenteDAO dao = new AtendenteDAO();
            try {
                rs = dao.ListarPorCpf(vo);
                    while(rs.next()){
                        AtendenteVO atendenteVO = new AtendenteVO();
                        atendenteVO.setNome(rs.getString("nome"));
                        atendenteVO.setCpf(rs.getString("CPF"));
                        atendentes.add(atendenteVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return atendentes;
        }
    }

    /* =========================================================== */
    

    /* ================ MÉTODOS DE BUSCA (GERENTE) ================ */ 

    public List <GerenteVO> BuscarGerentePorNome (GerenteVO vo) throws Exception {
        if(vo.getNome() == null || vo.getNome() == ""){ // verirficando se existe dados no nome
            throw new Exception("Gerente com nome vazio");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <GerenteVO> gerentes = new ArrayList<GerenteVO>();
            GerenteDAO dao = new GerenteDAO();
            try {
                rs = dao.ListarPorNome(vo);
                    while(rs.next()){
                        GerenteVO gerenteVO = new GerenteVO();
                        gerenteVO.setNome(rs.getString("nome"));
                        gerenteVO.setCpf(rs.getString("CPF"));
                        gerentes.add(gerenteVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return gerentes;
        }
    } 

    public List <GerenteVO> BuscarGerentePorCpf (GerenteVO vo) throws Exception {
        if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new Exception("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
            throw new Exception("CPF está vazio");
        }
        if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new Exception("CPF só pode conter números");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <GerenteVO> gerentes = new ArrayList<GerenteVO>();
            GerenteDAO dao = new GerenteDAO();
            try {
                rs = dao.ListarPorCpf(vo);
                    while(rs.next()){
                        GerenteVO gerenteVO = new GerenteVO();
                        gerenteVO.setNome(rs.getString("nome"));
                        gerenteVO.setCpf(rs.getString("CPF"));
                        gerentes.add(gerenteVO);
                    }
                }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return gerentes;
        }
    }


}
