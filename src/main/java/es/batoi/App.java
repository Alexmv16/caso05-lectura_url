package es.batoi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene escena;
//    private 

    @Override
    public void start(Stage stage) {
        try {            
            escena = new Scene(loadFXML("appvista"));
            stage.setTitle("Caso práctico");
            stage.setScene(escena);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error al cargar aplicación..." + ex.getMessage());
        }
    }

//    static void setRoot(String fxml) throws IOException {
//        escena.setRoot(loadFXML(fxml));
//    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
