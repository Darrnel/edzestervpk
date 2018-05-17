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
 * Egy gyakorlatot reprezentáló osztály.
 * @author darrnel
 */
public class Gyakorlat {

    private String nev;
    private int suly;
    private int sorozat;
    private int ismetles;
    
    
    /**
     *A Gyakorlat osztály alapértelmezett konstruktora. 
     */
    public Gyakorlat() {
    }

    /**
     * A Gyakorlat osztály konstruktora. 
     * @param nev a gyakorlat neve.
     * @param sorozat a gyakorlat sorozata.
     */
    public Gyakorlat(String nev, int sorozat) {
        this.nev = nev;
        this.sorozat = sorozat;
    }

    /**
     * A Gyakorlat osztály konstruktora.
     * 
     * @param nev a gyakorlat neve.
     * @param sorozat a gyakorlat sorozata.
     * @param ismetles a gyakorlat ismétlése.
     */
    public Gyakorlat(String nev, int sorozat, int ismetles) {
        this.nev = nev;
        this.sorozat = sorozat;
        this.ismetles = ismetles;
    }

    /**
     * A Gyakorlat osztály konstruktora.
     * 
     * @param nev a gyakorlat neve.
     * @param suly a gyakorlat súlya.
     * @param sorozat a gyakorlat sorozata.
     * @param ismetles a gyakorlat ismétlése.
     */
    public Gyakorlat(String nev, int suly, int sorozat, int ismetles) {
        this.nev = nev;
        this.suly = suly;
        this.sorozat = sorozat;
        this.ismetles = ismetles;
    }

    /**
     * Visszaadja a gyakorlat nevét.
     * 
     * @return a gyakorlat neve.
     */
    public String getNev() {
        return nev;
    }

    /**
     * Beállítja a gyakorlat nevét
     * 
     * @param nev a gyakorlat neve.
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja a gyakorlat súlyát.
     * 
     * @return a gyakorlat súlya.
     */
    public int getSuly() {
        return suly;
    }

    /**
     * Beállítja a gyakorlat súlyát.
     * 
     * @param suly a gyakorlat súlya.
     */
    public void setSuly(int suly) {
        this.suly = suly;
    }
    
    /**
     * Visszaadja a gyakorlat sorozatát.
     * 
     * @return a gyakorlat sorozata.
     */
    public int getSorozat() {
        return sorozat;
    }

    /**
     * Beállítja a gyakorlat sorozatát.
     * 
     * @param sorozat a gyakorlat sorozata.
     */
    public void setSorozat(int sorozat) {
        this.sorozat = sorozat;
    }

    /**
     * Visszaadja a gyakorlat ismétlését.
     * 
     * @return a gyakorlat ismétlése
     */
    public int getIsmetles() {
        return ismetles;
    }

    /**
     * Beállítja a gyakorlat ismétlését.
     * 
     * @param ismetles a gyakorlat ismétlése.
     */
    public void setIsmetles(int ismetles) {
        this.ismetles = ismetles;
    }

    public String toString() {
        return "            \nGyakorlat{" + "nev=" + nev + ", suly=" + suly + ", sorozat=" + sorozat + ", ismetles=" + ismetles + "}\n";
    }
}
