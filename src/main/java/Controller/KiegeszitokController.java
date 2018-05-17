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

import Modell.Kiegeszito;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller osztály, amely a kiegészítők és a hozzájuk tartozó linkek megjelenitésére szolgál.
 *
 * @author darrnel
 */
public class KiegeszitokController implements Initializable {
    
    @FXML
    private Label label_kieg;
    @FXML
    private TextFlow kieg_TF;
    @FXML
    private TextFlow kiegUrl_TF;
    @FXML
    private TextFlow felsz_TF;
    @FXML
    private TextFlow felszUrl_TF;
    @FXML
    private Text cipoText;
    @FXML
    private Hyperlink cipoLink;
    
    private static final Logger logger = LoggerFactory.getLogger(KezdolapController.class);


    Kiegeszito cipo = new Kiegeszito("Cipő", "https://www.fitbuilder.hu/termekek/Cipo.html");
    Kiegeszito nadrag = new Kiegeszito("Nadrág", "https://www.fitbuilder.hu/termekek/Edzo-nadrag.html");
    Kiegeszito polo = new Kiegeszito("Póló", "https://www.fitbuilder.hu/termekek/Polo.html");

    Kiegeszito feherje = new Kiegeszito("Fehérje", "https://www.fitbuilder.hu/termekek/Feherje.html");
    Kiegeszito tomegnovelo = new Kiegeszito("Tömegnövelő", "https://www.fitbuilder.hu/termekek/Tomegnovelo-Szenhidrat.html");
    Kiegeszito zsiregeto = new Kiegeszito("Zsírégető", "https://www.fitbuilder.hu/termekek/Dieta-Zsiregeto.html");


    @FXML
    private void handleVisszaButtonAction(ActionEvent event) {
        logger.info("Vissza a kezdőlapra...");
        Stage stage_vissza = (Stage) label_kieg.getScene().getWindow();
        stage_vissza.hide();
    }

    @FXML
    private void cipoLinkAction(ActionEvent event) {
        try {
            logger.debug("Cipőlink megnyitása.");
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(cipo.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void nadragLinkAction(ActionEvent event) {
        try {
            logger.debug("Nadráglink megnyitása.");
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(nadrag.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void poloLinkAction(ActionEvent event) {
        try {
            logger.debug("Pololink megnyitása.");
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(polo.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void feherjeLinkAction(ActionEvent event) {
        try {
            logger.debug("Fehérjelink megnyitása.");
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(feherje.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void tomegnoveloLinkAction(ActionEvent event) {
        try {
            logger.debug("Tömegnövelőlink megnyitása.");
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(tomegnovelo.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void zsiregetoLinkAction(ActionEvent event) {
        try {
            logger.debug("Zsírégetőlink megnyitása.");
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(zsiregeto.getUrl()));

        } catch (IOException e) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
