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

/**
 * Egy étrendet reprezentáló osztály.
 * @author darrnel
 */
public class Etrend {

    String reggeli;
    String tizorai;
    String ebed;
    String uzsonna;
    String vacsora;

    /**
     * Az Etrend osztály konstruktora.
     * 
     * @param reggeli az étrendhez tartozó reggeli.
     * @param tizorai az étrendhez tartozó tízórai.
     * @param ebed az étrendhez tartozó ebéd.
     * @param uzsonna az étrendhez tartozó uzsonna.
     * @param vacsora az étrendhez tartozó vacsora.
     */
    public Etrend(String reggeli, String tizorai, String ebed, String uzsonna, String vacsora) {
        this.reggeli = reggeli;
        this.tizorai = tizorai;
        this.ebed = ebed;
        this.uzsonna = uzsonna;
        this.vacsora = vacsora;
    }

    @Override
    public String toString() {
        return "Etrend{" + "reggeli=" + reggeli + ", tizorai=" + tizorai + ", ebed=" + ebed + ", uzsonna=" + uzsonna + ", vacsora=" + vacsora + '}';
    }

    /**
     * Visszaadja az étrendhez tartozó reggelit.
     * 
     * @return az étrendhez tartozó reggeli.
     */
    public String getReggeli() {
        return reggeli;
    }

    /**
     * Beállítja az étrendhez tartozó reggelit.
     * 
     * @param reggeli az étrendhez tartozó reggeli. 
     */
    public void setReggeli(String reggeli) {
        this.reggeli = reggeli;
    }

    /**
     * Visszaadja az étrendhez tartozó tízórait.
     * 
     * @return az étrendhez tartozó tízórai.
     */
    public String getTizorai() {
        return tizorai;
    }
    /**
     * Beállítja az étrendhez tartozó tízórait.
     * 
     * @param tizorai az étrendhez tartozó tízórai.
     */
    public void setTizorai(String tizorai) {
        this.tizorai = tizorai;
    }

    /**
     * Visszaadja az étrendhez tartozó ebédet.
     * 
     * @return az étrendhez tartozó ebéd.
     */
    public String getEbed() {
        return ebed;
    }
    
    /**
    * Beállítja az étrendhez tartozó ebédet
    * 
    * @param ebed az étrendhez tartozó ebéd. 
    */
    public void setEbed(String ebed) {
        this.ebed = ebed;
    }

    /**
     * Visszaadja az étrendhez tartozó uzsonnát.
     * 
     * @return az étrendhez tartozó uzsonna.
     */
    public String getUzsonna() {
        return uzsonna;
    }

    /**
     * Beállítja az étrendhez tartozó uzsonnát.
     * 
     * @param uzsonna az étrendhez tartozó uzsonna.
     */
    public void setUzsonna(String uzsonna) {
        this.uzsonna = uzsonna;
    }

    /**
     * Visszaadja az étrendhez tartozó vacsorát.
     * 
     * @return az étrendhez tartozó vacsora.
     */
    public String getVacsora() {
        return vacsora;
    }

    
    /**
     * Beállítja az étrendhez tartozó vacsorát.
     * 
     * @param vacsora az étrendhez tartozó vacsora.
     */
    public void setVacsora(String vacsora) {
        this.vacsora = vacsora;
    }

}
