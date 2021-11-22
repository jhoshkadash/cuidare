package Controller;

import Model.BO.UsuarioBO;
import Model.VO.*;
import VIEW.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FrontController{
    
    @FXML private TextField login;
    @FXML private TextField senha;
    @FXML private Label erroAut;

    UsuarioBO usuBO = new UsuarioBO();
    public void autenticar(ActionEvent event) {
        UsuarioVO vo = new UsuarioVO();
        vo.setLogin(login.getText());
        vo.setSenha(senha.getText());

        try {
            UsuarioVO autenticado = usuBO.autenticar(vo.getLogin(), vo.getSenha());

            if(autenticado.getTipo() == 1) {
                Telas.telaPrincipalAtendente();
            }
            if(autenticado.getTipo() == 2) {
                Telas.telaPrincipalMedico();
            }
            if(autenticado.getTipo() == 3) {
                Telas.telaPrincipalGerente();
            }

        } catch (Exception e) {
            erroAut.setVisible(true);
        }
    }
}
