package VIEW;

import controller.FrontController;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.*;

public class telaLogin extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader= FXMLLoader.load(getClass().getResource("G:/Documentos/UFERSA/Disciplinas/POO/cuidare/src/VIEW/VE/telaLogin.fxml"));

        Parent root = loader.load();

        Scene cena = new Scene(root);

        primaryStage.setTitle("CUIDARE");
        primaryStage.setScene(cena);
        primaryStage.show();
    }    
}
