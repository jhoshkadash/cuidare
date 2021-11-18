package VIEW;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class telaLogin extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/telaLogin.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setTitle("CUIDARE");
        primaryStage.setScene(cena);
        primaryStage.show();
    }    
}
