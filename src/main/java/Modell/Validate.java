package Modell;

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

import Controller.AdatokController;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Érvényességi teszteket megvalósító osztály.
 * @author darrnel
 */
public class Validate {

    /**
     * A Validate osztály alapértelmezett konstruktora.
     */
    public Validate() {
    }
    
    private static final Logger logger = LoggerFactory.getLogger(AdatokController.class);

    /* public boolean isUresBemenet(String bemenet, String elem){ 
        
        if(bemenet.isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Hibásan adtad meg a következő mezőt: "+ elem);

            alert.showAndWait();
            return true;
        }  
        
        return false;
    }
     */
    /**
     * Karakter bemenetet vizsgáló függvény.
     * 
     * @param bemenet a megvizsgálandó szöveg.
     * @param elem a hibás elem neve.
     * @return true - ha a bemenet szöveg, különben false.
     */
    public boolean isKarakterBemenet(String bemenet, String elem) {

        if ((Pattern.matches("[\\p{L}]+[ ][\\p{L}]+[ ]?[\\p{L}]*", bemenet) && bemenet.length() <= 30) || Pattern.matches("[\\p{L}]+", bemenet)) {
            return true;
        } else {
            
            logger.error("Hibás bemenet.");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Egész szöveget adj meg a következő mezőbe: " + elem);

            alert.showAndWait();
            return false;
        }
    }

    /**
     * Szám bemenetet vizsgáló függvény.
     * 
     * @param bemenet a megvizsgálandó szöveg.
     * @param elem a hibás elem neve.
     * @return true - ha a bemenet szám, különben false.
     */
    public boolean isSzamBemenet(String bemenet, String elem) {

        if (Pattern.matches("[0-9]+", bemenet) && bemenet.length() <= 3) {
            return true;
        } else {
            
            logger.error("Hibás bemenet.");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Egész számot adj meg a következő mezőbe: " + elem);

            alert.showAndWait();
            return false;
        }
    }

    /**
     * Nem 0 bemenetet vizsgáló függvény.
     * 
     * @param bemenet a megvizsgálandó szöveg.
     * @param elem a hibás elem neve.
     * @return true - ha a bemenet nem 0, különben false.
     */
    public boolean isNotNullValue(String bemenet, String elem) {

        if (!Pattern.matches("[0][0-9]*", bemenet)) {
            return true;
        } else {
            
            logger.error("Hibás bemenet.");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Nem adható meg 0 érték a következő helyen: " + elem);

            alert.showAndWait();

            return false;
        }
    }
    
    /**
     * A testtömegindex kiszámolásának hiányát jelző függvény. 
     */
    public void szamaolasSzukseges() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(null);
        alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
        alert.setContentText("Elsőnek add meg az adataid és számold ki a testtömegindexedet!");
        
        logger.error("Hiba, testtömegindex megadása kötelező.");
        
        alert.showAndWait();
    }

}
