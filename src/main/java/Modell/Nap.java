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
 * Egy edzésnapot reprezentáló osztály.
 * @author darrnel
 */
public class Nap {

    private String nap;
    private Edzes edzes;

    /**
     * A Nap osztály konstruktora.
     * @param nap a nap neve.
     * @param edzes a nep edzése.
     */
    public Nap(String nap, Edzes edzes) {
        this.nap = nap;
        this.edzes = edzes;
    }

    /**
     * Visszaadja a nap nevét.
     * 
     * @return a nap neve.
     */
    public String getNap() {
        return nap;
    }

    /**
     * Beállítja a nap nevét.
     * 
     * @param nap a nap neve.
     */
    public void setNap(String nap) {
        this.nap = nap;
    }

    /**
     * Visszaadja a nap edzését.
     * 
     * @return a nap edzése.
     */
    public Edzes getEdzes() {
        return edzes;
    }

    /**
     * Beállítja a nap edzését.
     * 
     * @param edzes a nap edzése.
     */
    public void setEdzes(Edzes edzes) {
        this.edzes = edzes;
    }

    @Override
    public String toString() {
        return "    \nNap{" + "nap=" + nap + ", edzes=" + edzes + "}\n";
    }
}
