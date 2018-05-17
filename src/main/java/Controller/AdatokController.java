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

import Modell.EdzesDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Modell.Felhasznalo;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import Modell.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller osztály, amely az adatok megadására szolgál.
 *
 * @author darrnel
 */
public class AdatokController implements Initializable {

    @FXML
    private TextField nev_TF, testsuly_TF, magassag_TF;
    @FXML
    private Label label1, ttindexLabel, kcalLabel, ajanlottLabel;

    boolean kiSzamolte = false;
    Validate v = new Validate();
    
    
    private static final Logger logger = LoggerFactory.getLogger(AdatokController.class);

    @FXML
    public void handleVisszaButtonAction(ActionEvent event) {
                       
            Stage stage = (Stage) label1.getScene().getWindow();

            stage.hide();        
    }

    @FXML
    public void handleEgyeniButtonAction(ActionEvent event) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        if (kiSzamolte) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Egyeni.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Egyéni edzésterv összeállítása");
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            v.szamaolasSzukseges();
        }
    }

    @FXML
    public void handleSablonButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, TransformerException, IOException {

        if (kiSzamolte) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Sablon.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Ajánlott edzésterv");
            stage.setScene(new Scene(root));

            stage.show();
        } else {
            v.szamaolasSzukseges();
        }

    }
    
    @FXML
    public void handleEtrendButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        if (kiSzamolte) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Etrend.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Ajánlott étrendek");
            stage.setScene(new Scene(root));

            stage.show();
        } else {
            v.szamaolasSzukseges();
        }

    }

    @FXML
    public void handleSzamolButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        EdzesDAO.CreateXML("dataXML.xml","felhasználók");
    	Validate v = new Validate();
        logger.debug("Testtömegindex számítása...");
        
        if (v.isKarakterBemenet(nev_TF.getText(), "Név") && v.isSzamBemenet(magassag_TF.getText(), "Magasság")
                && v.isSzamBemenet(testsuly_TF.getText(), "Súly") && v.isNotNullValue(magassag_TF.getText(), "Magasság")
                && v.isNotNullValue(testsuly_TF.getText(), "Súly")) {
            EdzesDAO.createFelhasznalo(nev_TF.getText(), magassag_TF.getText(), testsuly_TF.getText());

            Felhasznalo f = new Felhasznalo(nev_TF.getText(), parseInt(magassag_TF.getText()), parseInt(testsuly_TF.getText()));

            ttindexLabel.setText(String.valueOf(f.getTtindex()));
            ajanlottLabel.setText(f.getAjanlott());
            kcalLabel.setText(String.valueOf(f.getKcal()));

            kiSzamolte = true;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        logger.info("Adatok oldal betöltése...");
    }
}
