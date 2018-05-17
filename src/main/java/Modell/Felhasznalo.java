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
 * Egy felhasználót reprezentáló osztály.
 * @author darrnel
 */
public class Felhasznalo {

    private String nev;
    private int magassag;
    private int suly;
    private long ttindex;
    private long kcal;
    private String ajanlott;
    private Edzesterv edzesterv;

    /**
     * A Felhasznalo osztály konstruktora.
     */
    public Felhasznalo() {
    }

    /**
     * A Felhasznalo osztály konstruktora.
     * 
     * @param nev a felhasználó neve.
     * @param edzesterv a felhasználó edzésterve.
     * @param magassag a felhasználó magassága.
     * @param suly a felhasználó súlya.
     */
    public Felhasznalo(String nev, Edzesterv edzesterv, int magassag, int suly) {
        this.nev = nev;
        this.magassag = magassag;
        this.suly = suly;
        this.ttindex = ttindexSzamol(suly, magassag);
        this.edzesterv = edzesterv;
        this.ajanlott = ajanlottSzamol(ttindex);
        this.kcal = kcalSzamol(ttindex, suly);
    }
    
    /**
     * A Felhasznalo osztály kontruktora.
     * 
     * @param nev a felhasználó neve.
     * @param edzesterv a felhasználó edzésterve.
     * @param ttindex a felhasználó testtömegindexe.
     * @param kcal a felhasználó kalóriaigénye.
     */
    public Felhasznalo(String nev, Edzesterv edzesterv, long ttindex, long kcal) {
        this.nev = nev;
        this.ttindex = ttindex;
        this.edzesterv = edzesterv;
        this.kcal = kcal;
    }

    /**
     * A Felhasznalo osztály konstruktora.
     * 
     * @param nev a felhasználó neve.
     * @param ttindex a felhasználó testtömegindexe.
     * @param kcal a felhasználó kalóriaigénye.
     */
    public Felhasznalo(String nev, long ttindex, long kcal) {
        this.nev = nev;
        this.ttindex = ttindex;
        this.kcal = kcal;
    }

    /**
     * A Felhasznalo osztály konstruktora
     * 
     * @param nev a felhasználó neve.
     * @param magassag afelhasználó magassága.
     * @param suly afelhasználó súlya.
     */
    public Felhasznalo(String nev, int magassag, int suly) {
        this.nev = nev;
        this.magassag = magassag;
        this.suly = suly;
        this.ttindex = ttindexSzamol(suly, magassag);
        this.ajanlott = ajanlottSzamol(ttindex);
        this.kcal = kcalSzamol(ttindex, suly);
    }

    /**
     * Visszaadja a felhasználó nevét.
     * 
     * @return a felhasználó neve.
     */
    public String getNev() {
        return nev;
    }

    /**
     * Beállítja a felhasználó nevét
     * 
     * @param nev a felhasználó neve.
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja a felhasználó magasságát.
     * 
     * @return a felhasználó magassága.
     */
    public int getMagassag() {
        return magassag;
    }

    /**
     * Beállítja a felhasználó magasságát.
     * 
     * @param magassag a felhasználó magassága.
     */
    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    /**
     * Visszaadja a felhasználó súlyát.
     * 
     * @return a felhasználó súlya.
     */
    public int getSuly() {
        return suly;
    }

    /**
     * Beállítja a a felhasználó súlyát.
     * 
     * @param suly a felhasználó súlya.
     */
    public void setSuly(int suly) {
        this.suly = suly;
    }

    /**
     * Visszaadja a felhasználó ajánlott edzéstípusát.
     * 
     * @return a felhasználó ajánlott edzéstípusa.
     */
    public String getAjanlott() {
        return ajanlott;
    }

    /**
     * Beállítja a felhasználó ajánlott edzéstípusát
     * 
     * @param ajanlott a felhasználó ajánlott edzéstípusa.
     */
    public void setAjanlott(String ajanlott) {
        this.ajanlott = ajanlott;
    }

    /**
     * Visszaadja a felhasználó testtömegindexét.
     * 
     * @return a felhasználó testtömegindexe.
     */
    public long getTtindex() {
        return ttindex;
    }

    /**
     * Beállítja a felhasználó testtömegindexét.
     * 
     * @param ttindex a felhasználó testtömegindexe.
     */
    public void setTtindex(long ttindex) {
        this.ttindex = ttindex;
    }

    /**
     * Visszaadja a felhasználó edzéstervét.
     * 
     * @return a felhasználó edzésterve.
     */
    public Edzesterv getEdzesterv() {
        return edzesterv;
    }

    /**
     * Beállítja a felhasználó edzéstervét.
     * 
     * @param edzesterv a felhasználó edzésterve.
     */
    public void setEdzesterv(Edzesterv edzesterv) {
        this.edzesterv = edzesterv;
    }

    /**
     * Beállítja a felhasználó kalóriaigényét.
     * 
     * @param kcal a felhasználó kalóriaigénye.
     */
    public void setKcal(long kcal) {
        this.kcal = kcal;
    }

    /**
     * Visszaadja a felhasználó kalóriaigényét.
     * 
     * @return a felhasználó kalóriaigénye.
     */
    public long getKcal() {
        return kcal;
    }

    @Override
    public String toString() {
        return "Felhasznalo{" + "nev=" + nev + ", ttindex=" + ttindex + ", kcal=" + ", edzesterv=" + edzesterv + "}\n";
    }

    /**
     * A felhasználó testtömegindexét kiszámító függvény
     * 
     * @param testsuly a felhasználó súlya.
     * @param magassag a felhasználó magassága.
     * @return a felhasználó testtömegindexe. 
     */
    public long ttindexSzamol(int testsuly, int magassag) {
        return Math.round(1.3 * testsuly / Math.pow((double) magassag / 100, 2.5));
    }
    
    /**
     * A felhasználó ajánlott edzéstervét kiszámító függvény.
     * 
     * @param ttindex a felhasználó testtömegindexe.
     * @return a felhasználó ajánlott edzésterve.
     */
    public String ajanlottSzamol(long ttindex) {

        if (ttindex >= 20 && ttindex <= 26) {
            return "Normál edzés";
        } else if (ttindex < 20) {
            return "Tömegnövelő edzés";
        } else {
            return "Zsírégető edzés";
        }

    }
    
    /**
     * A felhasználó kalóriaigényét kiszámító függvény.
     * 
     * @param ttindex a felhasználó testtömegindexe.
     * @param suly a felhasználó súlya.
     * @return a felhasználó kalóriaigénye.
     */
    public long kcalSzamol(long ttindex, int suly) {

        if (ttindex >= 20 && ttindex <= 26) {
            return suly * 35;
        } else if (ttindex < 20) {
            return suly * 45;
        } else {
            return suly * 20;
        }

    }

}
