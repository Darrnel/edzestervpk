package Controller;

/*
The MIT License

Copyright 2018 darrnel.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

import Modell.Validate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller osztály, amely a program kezdőlaját jeleníti meg.  
 *
 * @author darrnel
 */
public class KezdolapController implements Initializable {

    @FXML
    private Label label_kiegeszito;
    Validate v = new Validate();
    
    private static final Logger logger = LoggerFactory.getLogger(KezdolapController.class);

    @FXML
    public void handleKezdesButtonAction(ActionEvent event) throws IOException {
            logger.info("Kezdés...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Adatok.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Adatok megadása");
            stage.setScene(new Scene(root));

            stage.show();
    }
    
    @FXML
    public void handleKiegeszitokButtonAction(ActionEvent event) throws IOException {
               
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kiegeszitok.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setTitle("Kiegeszitok");
        stage.setScene(new Scene(root));

        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
