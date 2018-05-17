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
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * Controller osztály, amely az étrendedk megjelenítésére szolgál.
 *  
 * @author darrnel
 */
public class EtrendController implements Initializable {

    @FXML
    Label reggeliLabel;
    @FXML
    TextFlow reggeliA, reggeliB, reggeliC, reggeliD, tizoraiA, tizoraiB, tizoraiC, tizoraiD, ebedA, ebedB,
            ebedC, ebedD, uzsonnaA, uzsonnaB, uzsonnaC, uzsonnaD, vacsoraA, vacsoraB, vacsoraC, vacsoraD;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AdatokController.class);

    /**
     * Az Adatok lapra való visszalépést megvalósító függvény.
     * @param event 
     */
    @FXML
    public void handleVisszaButtonAction(ActionEvent event) {
        try {
            Stage stage_vissza = (Stage) reggeliLabel.getScene().getWindow();
            stage_vissza.hide();
        } catch (Exception e) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    	
        logger.info("Étrend lap betöltése...");
        
        String etrendTipus;

        try {
            if (EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getTtindex() < 27) {
                etrendTipus = "tomegEtrendXML.xml";
            } else {
                etrendTipus = "fogyasEtrendXML.xml";
            }
           // EdzesDAO.MoveXML(etrendTipus);
            

            reggeliA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getReggeli()));
            reggeliB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getReggeli()));
            reggeliC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getReggeli()));
            reggeliD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getReggeli()));

            tizoraiA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getTizorai()));
            tizoraiB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getTizorai()));
            tizoraiC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getTizorai()));
            tizoraiD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getTizorai()));

            ebedA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getEbed()));
            ebedB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getEbed()));
            ebedC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getEbed()));
            ebedD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getEbed()));

            uzsonnaA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getUzsonna()));
            uzsonnaB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getUzsonna()));
            uzsonnaC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getUzsonna()));
            uzsonnaD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getUzsonna()));

            vacsoraA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getVacsora()));
            vacsoraB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getVacsora()));
            vacsoraC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getVacsora()));
            vacsoraD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getVacsora()));

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
        }

    }

}
