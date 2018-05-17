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

import java.util.ArrayList;
import java.util.List;

/**
 * Egy edzést reprezentáló osztály.
 * 
 * @author darrnel
 */
public class Edzes {

    private String tipus;
    private List<Gyakorlat> gyakorlatok;

    /**
     * Az Edzes osztály konstruktora.
     * 
     * @param tipus az edzés típusa. 
     */
    public Edzes(String tipus) {
        if (tipus.equals("Pihenő")) {
            this.tipus = tipus;
            this.gyakorlatok = null;
        } else {
            this.tipus = tipus;
            this.gyakorlatok = new ArrayList<>();
        }
    }

    /**
     * Az Edzes osztály konstruktora.
     * 
     * @param tipus az edzés típusa
     * @param gyakorlatok az edzés gyakorlatainak listája.
     */
    public Edzes(String tipus, List<Gyakorlat> gyakorlatok) {
        if (tipus.equals("Pihenő")) {
            this.tipus = tipus;
            this.gyakorlatok = null;
        } else {
            this.tipus = tipus;
            this.gyakorlatok = gyakorlatok;
        }
    }

    /**
     * Visszaadja az edzés típusát.
     * 
     * @return az edzés típusa.
     */
    public String getTipus() {
        return tipus;
    }

    /**
     * Beállítja az edzés típusát.
     * 
     * @param tipus az edzés típusa.
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    /**
     * Visszaadja az edzés gyakorlatait.
     * 
     * @return az edzés gyakorlatainak listája. 
     */
    public List<Gyakorlat> getGyakorlatok() {
        return gyakorlatok;
    }

    /**
     * Hozzáad az edzéshez egy gyakorlatot
     * 
     * @param gyakorlat a hozzáadni kívánt gyakorlat. 
     */
    public void addGyakorlat(Gyakorlat gyakorlat) {
        getGyakorlatok().add(gyakorlat);
    }

    /**
     * Töröl egy gyakorlatot az edzés gyakorlatai közül.
     * 
     * @param gyakorlat a törölni kívánt gyakorlat.
     */
    public void removeGyakorlat(Gyakorlat gyakorlat) {
        getGyakorlatok().remove(gyakorlat);
    }

    @Override
    public String toString() {
        return "        \nEdzes{" + "tipus=" + tipus + ", gyakorlatok=" + gyakorlatok + "}\n";
    }

}
