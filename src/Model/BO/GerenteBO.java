package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.*;
import Model.Exception.*;
import Model.VO.*;

public class GerenteBO {

    /* =============== MÉTODOS DE CADASTRO =============== */

    public void CadastrarMedico(MedicoVO vo) throws InsertException{
        if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
            throw new InsertException("CPF está vazio");
        }
        if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new InsertException("CPF só pode conter números");
        }
        if(vo.getNome() == null || vo.getNome() == ""){ // verificando se existe dados no nome
            throw new InsertException("Médico com nome vazio");
        }
        if(vo.getEndereco() == null || vo.getEndereco() == ""){ // verificando se existe dados no nome
            throw new InsertException("Médico com endereço vazio");
        }
        if(vo.getCrm() == null || vo.getCrm() == ""){ // verificando se existe dados de CRM cadastrados
            throw new InsertException("Médico com CRM vazio");
        }
        if(vo.getValorConsulta() == null){ // verificando se existe dados de valor de consulta cadastrado
            throw new InsertException("Não há valor de consulta cadastrado");
        }
        else {
                MedicoDAO dao = new MedicoDAO();
                ResultSet rs;
                try {
                    rs = dao.ListarPorId(vo);
                    if(rs.next()){
                        throw new InsertException("Médico com mesmo ID já cadastrado");
                    } else{
                        dao.Inserir(vo);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } 

    public void CadastrarPaciente(PacienteVO vo) throws InsertException{
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

    public void CadastrarAtendente(AtendenteVO vo) throws InsertException{
        if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
            throw new InsertException("CPF está vazio");
        }
        if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new InsertException("CPF só pode conter números");
        }
        if(vo.getClass() == null || vo.getNome() == ""){ // verificando se existe dados no nome
            throw new InsertException("Atendente com nome vazio");
        }
        else {
                AtendenteDAO dao = new AtendenteDAO();
                ResultSet rs;
                try {
                    rs = dao.ListarPorId(vo);
                    if(rs.next()){
                        throw new InsertException("Atendente com mesmo ID já cadastrado");
                    } else{
                        dao.Inserir(vo);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

    public void CadastrarGerente(GerenteVO vo) throws InsertException{
        if(vo.getCpf().length() != 11){ // verificando se a string de cpf possui 11 digitos
            throw new InsertException("CPF inválido, não possui 11 digitos, não escreva pontos e nem linhas");
        }
        if(vo.getCpf() == null){ // verificando se existe dados dentro do cpf
            throw new InsertException("CPF está vazio");
        }
        if(vo.getCpf().matches("^[0-9]*$") == false){ // verificando se só contem números no cpf
            throw new InsertException("CPF só pode conter números");
        }
        if(vo.getNome() == null || vo.getNome() == ""){ // verificando se existe dados no nome
            throw new InsertException("Gerente com nome vazio");
        }
    
        else {
                GerenteDAO dao = new GerenteDAO();
                ResultSet rs;
                try {
                    rs = dao.ListarPorId(vo);
                    if(rs.next()){
                        throw new InsertException("Gerente com mesmo ID já cadastrado");
                    } else{
                        dao.Inserir(vo);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }    
    }

    /* ============================================================= */


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

    public List <AtendenteVO> BuscarAtendentePorNome (AtendenteVO vo) throws Exception {
        if(vo.getNome() == null || vo.getNome() == ""){ // verirficando se existe dados no nome
            throw new Exception("Atendente com nome vazio");
        }
        else{ // metodo de busca
            ResultSet rs;
            List <AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
            AtendenteDAO dao = new AtendenteDAO();
            try {
                rs = dao.ListarPorNome(vo);
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
