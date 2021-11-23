package Controller;

import javax.swing.Action;

import Model.VO.MedicoVO;
import Model.VO.PacienteVO;
import Model.VO.UsuarioVO;
import VIEW.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AtendenteController {

    @FXML private Button botao_paciente;
    @FXML private Button botao_medico;
    @FXML private Button botao_consulta;
    @FXML private Button botao_cadastro_paciente;

    @FXML private TextField barra_pesquisa;

    //cadastro de pacientes
    @FXML private TextField nome_paciente;
    @FXML private TextField cpf_paciente;
    @FXML private DatePicker data_nascimento;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField peso;
    @FXML private TextField altura;
    @FXML private TextField imc;
    @FXML private TextField remedios;
    @FXML private TextField obs;

    //cadastro de médicos
    @FXML private TextField nome_medico, cpf_medico, rua_medico, numero_medico, crm, valor_consulta;
    

    public void telaPaciente (ActionEvent e) throws Exception {
        Telas.telaAtendente_Pacientes();
    }

    public void telaCadastroPaciente (ActionEvent e) throws Exception {
        Telas.telaAtendente_CadastroPaciente();
        PacienteVO vo = new PacienteVO();
        vo.setNome(nome_paciente.getText());
        vo.setCpf(cpf_paciente.getText());
        vo.setEndereco(rua.getText() + ", número " + numero.getText());

    }
    
    public void telaMedico (ActionEvent e) throws Exception {
        Telas.telaAtendente_Medicos();
    }

    public void CadastroMedico (ActionEvent e) throws Exception {
        Telas.telaAtendente_CadastroMedico();
        MedicoVO vo = new MedicoVO();
        double valorconsulta;
        vo.setNome(nome_medico.getText());
        vo.setCpf(cpf_medico.getText());
        vo.setEndereco(rua_medico.getText() + ", número " + numero_medico.getText());
        vo.setCrm(crm.getText());
        valorconsulta = Double.parseDouble(valor_consulta.getText());
        vo.setValorConsulta(valorconsulta);
    }
}