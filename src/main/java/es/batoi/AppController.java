package es.batoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class AppController implements Initializable {

    @FXML
    private TextArea taContenido;
//    @FXML
//    private Button btnLeer;
    @FXML
    private TextField tfURL;

    @FXML
    private void handleLeer() {
        String lin;
        taContenido.setText("");
        try {
            URL url = new URL(tfURL.getText());
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                while ((lin = br.readLine()) != null) {
                    taContenido.setText(taContenido.getText()+lin+System.getProperty("line.separator"));
                }
            } catch (IOException ex) {
                 taContenido.setText("Error de lectura en origen");
            }

//            Scanner sc;
//            try {
//                sc = new Scanner(url.openStream());
//                while (sc.hasNextLine()) {
//                    lin = sc.nextLine();
//                    taContenido.setText(taContenido.getText() + lin + System.getProperty("line.separator"));
//                }
//            } catch (IOException ex) {
//                taContenido.setText("Error de lectura en origen");
//            }
        } catch (MalformedURLException ex) {
            taContenido.setText("URL incorrecta");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfURL.setOnKeyReleased((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleLeer();
            }
        });
    }
}
