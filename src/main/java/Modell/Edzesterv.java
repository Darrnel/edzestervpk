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

import java.util.List;

/**
 * Egy edzéstervet reprezentáló osztály.
 * @author darrnel
 */
public class Edzesterv {
    
    private List<Nap> napok;

    /**
     * Az Edzesterv osztály alapértelmezett konstruktora
     */
    public Edzesterv() {
    }
    
    /**
     * Az edzésterv osztály konstruktora.
     * @param napok az edzésterv napjainak listája.
     */
    public Edzesterv(List<Nap> napok) {
        this.napok = napok;
    }

    /**
     * Visszaadja az edzésterv napjainak listáját.
     * 
     * @return az edzésterv napjai. 
     */
    public List<Nap> getNapok() {
        return napok;
    }

    /**
     * Beállítja az edzésterv napjait. 
     * 
     * @param napok a napok listája.
     */
    public void setNapok(List<Nap> napok) {
        this.napok = napok;
    }

    @Override
    public String toString() {
        return "Edzesterv{" + "napok=" + napok + "}\n";
    }

}
