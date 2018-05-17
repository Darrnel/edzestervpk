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
 * Egy kiegészítőt reprezentáló osztály.
 * @author darrnel
 */
public class Kiegeszito {

    private String nev;
    private String url;

    /**
     * A Kiegeszito osztály konstruktora.
     * 
     * @param nev a kiegészítő neve.
     * @param url a kiegészítő url-je.
     */
    public Kiegeszito(String nev, String url) {
        this.nev = nev;
        this.url = url;
    }

    /**
     * Visszaadja a kiegészítő nevét.
     * 
     * @return a kiegészítő neve.
     */
    public String getNev() {
        return nev;
    }

    /**
     * Beállítja a kiegészítő nevét.
     * 
     * @param nev a kiegészítő neve.
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja a kiegészítő url-jét.
     * 
     * @return a kiegészítő url-je.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Beállítja a kiegészítő url-jét.
     * 
     * @param url a kiegészítő url-je
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
