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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import static java.nio.file.StandardCopyOption.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import Controller.AdatokController;

/**
 * Adatok adatbázisba írását illetve olvasását megvalósító osztály.
 * 
 * @author darrnel
 */
public class EdzesDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdatokController.class);
	
	/**
	 * A dataXML.xml adatbázis elkészítését végző függvény.
	 */
	public static void CreateXML(String filename,String rootName) {
        try {
        	
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            
            Document doc;
            Element root ;

            File inputFile;
            inputFile = new File(System.getProperty("user.home") + "/."+filename);

            if (inputFile.exists()) {
                doc = db.parse(inputFile);
            } else {
                doc = db.newDocument();
            }

            if (doc.getDocumentElement() == null) {
                root = doc.createElement(rootName);
                doc.appendChild(root);
            } else {
                root = doc.getDocumentElement();
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(inputFile);

            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apche.org/xslt}indent-amount", "4");
            t.transform(source, result);

        } catch (TransformerConfigurationException | ParserConfigurationException | IOException e) {

        } catch (TransformerException | SAXException e) {
        }
	}
	
	/*public static void MoveXML(String filename) {
        File input = new File("/src/main/resources/xml/"+filename);
        File output = new File(System.getProperty("user.home")+"/."+filename);
        
        logger.info(input.getAbsolutePath());
        
       // File input2 = input.renameTo(new File(System.getProperty("user.home")+"/."+filename));
        
        try {
        	Files.copy(input.toPath(),output.toPath(),StandardCopyOption.REPLACE_EXISTING);
        	//Files.move(input.toPath(), output.toPath().resolve(input.getName()), REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Nem sikerült áthelyezni a fájlt.");
		}
        
        logger.info(input.getAbsolutePath());
	}*/

	 public static void createFelhasznalo(String felhNev, String felhMagassag, String felhSuly) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

	        //InputStream inputFile = EdzesDAO.class.getResourceAsStream("dataXML.xml");
	    	File inputFile = new File(System.getProperty("user.home") + "/.dataXML.xml");
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.parse(inputFile);
	        Element root = doc.getDocumentElement();

	        Element felhasznaloE = doc.createElement("felhasznalo");

	        Felhasznalo f = new Felhasznalo(felhNev, parseInt(felhMagassag), parseInt(felhSuly));

	        long felhTtindex = f.getTtindex();

	        long felhKcal = f.getKcal();

	        Attr nev = doc.createAttribute("nev");
	        Attr ttindex = doc.createAttribute("ttindex");
	        Attr kcal = doc.createAttribute("kcal");

	        nev.setNodeValue(felhNev);
	        ttindex.setNodeValue(String.valueOf(felhTtindex));
	        kcal.setNodeValue(String.valueOf(felhKcal));

	        felhasznaloE.setAttributeNode(kcal);
	        felhasznaloE.setAttributeNode(nev);
	        felhasznaloE.setAttributeNode(ttindex);

	        root.appendChild(felhasznaloE);

	        Element edzestervE = doc.createElement("edzesterv");

	        felhasznaloE.appendChild(edzestervE);

	        DOMSource source = new DOMSource(doc);

	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer t = tf.newTransformer();
	        t.setOutputProperty(OutputKeys.INDENT, "yes");
	        t.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
	        StreamResult result = new StreamResult(inputFile);
	        t.transform(source, result);

	    }
	
    /**
     * Egy előre elkészített edzésterv adatbázisból való beolvasására szolgáló függvény.
     * 
     * @param filename az xml fájl neve, amiből olvasni akarunk.
     * @return a beolvasott edzésterv.
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException 
     */
    public static Edzesterv getSablonEdzesterv(String filename) throws SAXException, IOException, ParserConfigurationException  {
        
        //InputStream inputFile = EdzesDAO.class.getResourceAsStream(filename);
    	
    	File inputFile = new File("src/main/resources/xml/" + filename);
    	//inputFile.renameTo(new File(System.getProperty("user.home") + "/."+filename));
    	
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nl = doc.getElementsByTagName("nap");

        List<Nap> napok = new ArrayList<>();

        for (int i = 0; i < nl.getLength(); i++) {
            List<Gyakorlat> gyakorlatok = new ArrayList<>();

            Element nap = (Element) nl.item(i);

            Element edzese = (Element) nap.getElementsByTagName("edzes").item(0);

            NodeList nl2 = edzese.getElementsByTagName("gyakorlat");

            for (int j = 0; j < nl2.getLength(); j++) {
                Element gyakorlate = (Element) edzese.getElementsByTagName("gyakorlat").item(j);

                String nev = gyakorlate.getAttribute("nev");

                int suly = parseInt(gyakorlate.getElementsByTagName("suly").item(0).getTextContent());
                int sorozat = parseInt(gyakorlate.getElementsByTagName("sorozat").item(0).getTextContent());
                int ismetles = parseInt(gyakorlate.getElementsByTagName("ismetles").item(0).getTextContent());

                Gyakorlat gyakorlat = new Gyakorlat(nev, suly, sorozat, ismetles);

                gyakorlatok.add(gyakorlat);
            }

            String tipus = edzese.getAttribute("tipus");

            Edzes edzes = new Edzes(tipus, gyakorlatok);

            String napnev = nap.getAttribute("nap");

            Nap aktualis_nap = new Nap(napnev, edzes);

            napok.add(aktualis_nap);

        }

        Edzesterv edzesterv = new Edzesterv(napok);

        return edzesterv;
    }
    
    /**
     * Egy előre elkészített étrend lista adatbázisból való beolvasását végző függvény.
     * 
     * @param filename az xml fájl neve amiből olvasni akarunk.
     * @return a beolvasott étrendek listája.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public static List<Etrend> getEtrend(String filename) throws ParserConfigurationException, SAXException, IOException {

        //InputStream inputFile = EdzesDAO.class.getResourceAsStream(filename);
        File inputFile = new File("src/main/resources/xml/" + filename);
    	//File inputFile = new File("user.home"+"/."+filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nl = doc.getElementsByTagName("étrend");

        List<Etrend> etrendek = new ArrayList<>();

        for (int i = 0; i < nl.getLength(); i++) {
            Element etrende = (Element) nl.item(i);

            String reggeli = etrende.getElementsByTagName("reggeli").item(0).getTextContent();
            String tizorai = etrende.getElementsByTagName("tízórai").item(0).getTextContent();
            String ebed = etrende.getElementsByTagName("ebéd").item(0).getTextContent();
            String uzsonna = etrende.getElementsByTagName("uzsonna").item(0).getTextContent();
            String vacsora = etrende.getElementsByTagName("vacsora").item(0).getTextContent();

            Etrend etrend = new Etrend(reggeli, tizorai, ebed, uzsonna, vacsora);

            etrendek.add(etrend);
        }

        return etrendek;
    }
    
    /**
     * Egy felhasználó adatainak adatbáziba való írását végző függvény.
     * 
     * @param felhNev a felhasználó neve.
     * @param felhMagassag a felhasználó magassága.
     * @param felhSuly a felhasználó súlya.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
   
    /**
     * Egy edzésnap adatainak adatbázisba írását végző függvény.
     * 
     * @param felhNev a felhasználó neve.
     * @param felhKcal a felhasználó kalóriaigénye
     * @param napNev az edzés napja.
     * @param edzesTipus az edzés típusa.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
    public static void createNap(String felhNev, String felhKcal, String napNev, String edzesTipus) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        //InputStream inputFile = EdzesDAO.class.getResourceAsStream("dataXML.xml");
    	File inputFile = new File(System.getProperty("user.home") + "/.dataXML.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputFile);
        Element root = doc.getDocumentElement();

        NodeList felhNl = root.getElementsByTagName("felhasznalo");

        for (int i = 0; i < felhNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhNl.item(i);

            if (String.valueOf(felhasznaloE.getAttribute("nev")).equals(felhNev) && String.valueOf(felhasznaloE.getAttribute("kcal")).equals(felhKcal)) {

                Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

                Element napE = doc.createElement("nap");

                Attr napnev = doc.createAttribute("nev");
                napnev.setNodeValue(napNev);
                napE.setAttributeNode(napnev);

                edzestervE.appendChild(napE);

                Element edzesE = doc.createElement("edzes");

                Attr edzestipus = doc.createAttribute("tipus");
                edzestipus.setNodeValue(edzesTipus);
                edzesE.setAttributeNode(edzestipus);

                napE.appendChild(edzesE);

            }
        }

        DOMSource source = new DOMSource(doc);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult(inputFile);
        t.transform(source, result);

    }
    /**
     * Egy gyakorlat adatbázisba írását végző függvény.
     * 
     * @param felhNev a felhasznéló neve.
     * @param felhKcal a felhasználó kalóriaigénye.
     * @param napNev az edzésnap neve.
     * @param gyakNev a gyakorlat neve.
     * @param gyakSuly a gyakorlat súlya.
     * @param gyakSorozat a gyakorlat sorozata.
     * @param gyakIsmetles a gyakorlat ismétlése.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
    public static void createGyakorlat(String felhNev, String felhKcal, String napNev, String gyakNev, String gyakSuly, String gyakSorozat, String gyakIsmetles) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

       // InputStream inputFile = EdzesDAO.class.getResourceAsStream("dataXML.xml");
    	File inputFile = new File(System.getProperty("user.home") + "/.dataXML.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputFile);
        Element root = doc.getDocumentElement();

        NodeList felhNl = root.getElementsByTagName("felhasznalo");

        for (int i = 0; i < felhNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhNl.item(i);

            if (String.valueOf(felhasznaloE.getAttribute("nev")).equals(felhNev) && String.valueOf(felhasznaloE.getAttribute("kcal")).equals(felhKcal)) {

                Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

                NodeList napNl = edzestervE.getElementsByTagName("nap");

                for (int j = 0; j < napNl.getLength(); j++) {
                    Element napE = (Element) napNl.item(j);

                    if (String.valueOf(napE.getAttribute("nev")).equals(napNev)) {
                        Element edzesE = (Element) napE.getElementsByTagName("edzes").item(0);

                        Element gyakE = doc.createElement("gyakorlat");

                        Attr gyaknev = doc.createAttribute("nev");
                        gyaknev.setValue(gyakNev);

                        Element sulyE = doc.createElement("suly");
                        Element sorozatE = doc.createElement("sorozat");
                        Element ismetlesE = doc.createElement("ismetles");

                        sulyE.appendChild(doc.createTextNode(gyakSuly));
                        sorozatE.appendChild(doc.createTextNode(gyakSorozat));
                        ismetlesE.appendChild(doc.createTextNode(gyakIsmetles));

                        gyakE.setAttributeNode(gyaknev);
                        gyakE.appendChild(sulyE);
                        gyakE.appendChild(sorozatE);
                        gyakE.appendChild(ismetlesE);

                        edzesE.appendChild(gyakE);
                    }

                }
            }
        }

        DOMSource source = new DOMSource(doc);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult(inputFile);
        t.transform(source, result);

    }
    
    /**
     * A felhasználók adatbázisból történő kiolvasását végző függvény.
     * 
     * @return a felhasználók listája minden adatukkal együtt.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
    public static List<Felhasznalo> getFelhasznalok() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        //InputStream inputFile = EdzesDAO.class.getResourceAsStream("dataXML.xml");
    	File inputFile = new File(System.getProperty("user.home") + "/.dataXML.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList felhasznaloNl = doc.getElementsByTagName("felhasznalo");

        List<Felhasznalo> felhasznalok = new ArrayList<>();

        for (int i = 0; i < felhasznaloNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhasznaloNl.item(i);

            Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

            NodeList napNl = edzestervE.getElementsByTagName("nap");

            List<Nap> napok = new ArrayList<>();

            for (int j = 0; j < napNl.getLength(); j++) {
                Element napE = (Element) napNl.item(j);

                Element edzesE = (Element) napE.getElementsByTagName("edzes").item(0);

                NodeList gyakorlatNl = edzesE.getElementsByTagName("gyakorlat");

                List<Gyakorlat> gyakorlatok = new ArrayList<>();

                for (int k = 0; k < gyakorlatNl.getLength(); k++) {
                    Element gyakorlatE = (Element) gyakorlatNl.item(k);

                    String gyaknev = gyakorlatE.getAttribute("nev");
                    int gyaksuly = parseInt(gyakorlatE.getElementsByTagName("suly").item(0).getTextContent());
                    int gyaksorozat = parseInt(gyakorlatE.getElementsByTagName("sorozat").item(0).getTextContent());
                    int gyakismetles = parseInt(gyakorlatE.getElementsByTagName("ismetles").item(0).getTextContent());

                    Gyakorlat gyakorlat = new Gyakorlat(gyaknev, gyaksuly, gyaksorozat, gyakismetles);

                    gyakorlatok.add(gyakorlat);
                }

                Edzes edzes = new Edzes(edzesE.getAttribute("tipus"), gyakorlatok);

                Nap nap = new Nap(napE.getAttribute("nev"), edzes);

                napok.add(nap);
            }

            Edzesterv edzesterv = new Edzesterv(napok);

            Felhasznalo felhasznalo = new Felhasznalo(felhasznaloE.getAttribute("nev"), edzesterv, Long.parseLong(felhasznaloE.getAttribute("ttindex")), Long.parseLong(felhasznaloE.getAttribute("kcal")));
            felhasznalok.add(felhasznalo);
        }

        return felhasznalok;
    }

    /**
     * A felhasználók neveit az adatbázisból kiolvasó függvény.
     * 
     * @return a felhasználók nevei.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
    public static List<Felhasznalo> getNevek() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        //InputStream inputFile = EdzesDAO.class.getResourceAsStream("dataXML.xml");
    	File inputFile = new File(System.getProperty("user.home") + "/.dataXML.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList felhasznaloNl = doc.getElementsByTagName("felhasznalo");

        List<Felhasznalo> felhasznalok = new ArrayList<>();
        for (int i = 0; i < felhasznaloNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhasznaloNl.item(i);

            Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

            Felhasznalo felhasznalo = new Felhasznalo(felhasznaloE.getAttribute("nev"), parseInt(felhasznaloE.getAttribute("ttindex")), parseInt(felhasznaloE.getAttribute("kcal")));

            felhasznalok.add(felhasznalo);
        }

        return felhasznalok;
    }
    
    
}
