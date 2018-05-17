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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import Modell.EdzesDAO;
import java.io.IOException;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * Controller osztály, amely egyelőre elkészített edzésterv megjelenítésére szolgál.
 * 
 * <p>
 * Az előre elkészített edzéstervek közül az kerül megjelenítésre,
 * amely ideális a felhasználó számára.
 *
 * @author darrnel
 */
public class SablonController implements Initializable {

    @FXML
    private TextFlow hetfoTipus, keddTipus, szerdaTipus, csutortokTipus, pentekTipus;
    @FXML
    private TextArea hetfoGyak, keddGyak, szerdaGyak, csutortokGyak, pentekGyak;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SablonController.class);

    
    //EdzesDAO EdzesDAO;
    @FXML
    private void handleVisszaButtonAction(ActionEvent event) {
        Stage stage_vissza = (Stage) hetfoTipus.getScene().getWindow();
        stage_vissza.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        logger.info("Sablon oldal betöltése...");
        
        hetfoGyak.setEditable(false);
        keddGyak.setEditable(false);
        szerdaGyak.setEditable(false);
        csutortokGyak.setEditable(false);
        pentekGyak.setEditable(false);

        keddGyak.setText("PIHENŐ NAP");
        csutortokGyak.setText("PIHENŐ NAP");

        String sablonTipus;

        try {
            if (EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getTtindex() < 27) {
                sablonTipus = "tomegXML.xml";
            } else {
                sablonTipus = "fogyasXML.xml";
            }
            
            //EdzesDAO.MoveXML(sablonTipus);

            hetfoTipus.getChildren().add(new Text(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getTipus()));

            for (int i = 0; i < EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().size(); i++) {
                hetfoGyak.appendText(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getNev());
                hetfoGyak.appendText("\n    - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getSuly()) + "kg");
                hetfoGyak.appendText("\n    - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getSorozat()) + "x");
                hetfoGyak.appendText(String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getIsmetles()) + "\n");

            }

            szerdaTipus.getChildren().add(new Text(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getTipus()));

            for (int i = 0; i < EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().size(); i++) {
                szerdaGyak.appendText(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getNev());
                szerdaGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getSuly()) + "kg");
                szerdaGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getSorozat()) + "x");
                szerdaGyak.appendText(String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getIsmetles()) + "\n");
            }

            pentekTipus.getChildren().add(new Text(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getTipus()));

            for (int i = 0; i < EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().size(); i++) {
                pentekGyak.appendText(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getNev());
                pentekGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getSuly()) + "kg");
                pentekGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getSorozat()) + "x");
                pentekGyak.appendText(String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getIsmetles()) + "\n");
            }

        } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
        }

    }
}
