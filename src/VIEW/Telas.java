package VIEW;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
    public static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage (Stage primaryStage) {
        Telas.primaryStage = primaryStage;
    }
    
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setTitle("CUIDARE");
        primaryStage.show();
        telaLogin();
    }
    
    
    public static void telaLogin() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }
    /* =============== TELAS PRINCIPAIS =============== */
    public static void telaPrincipalGerente() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalGerente.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }

    public static void telaPrincipalAtendente() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalAtendente.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }

    public static void telaPrincipalMedico() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalMedico.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }
    /* =============================================== */

    /* =============== TELAS ATENDENTE =============== */
    public static void telaAtendente_Pacientes() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAtendente_Pacientes.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }

    public static void telaAtendente_Medicos() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAtendente_Medicos.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }

    public static void telaAtendente_Consultas() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAtendente_Consultas.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }

    public static void telaAtendente_CadastroPaciente() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAtendente_CadastroPaciente.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }

    public static void telaAtendente_CadastroMedico() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAtendente_CadastroMedico.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);   
    }


}
