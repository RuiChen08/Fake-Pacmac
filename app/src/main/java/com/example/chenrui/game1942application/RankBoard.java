package com.example.chenrui.game1942application;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 *
 * Use PersistantDataXML load and store the Mark Rank
 * @author Chucheng Qian
 * @Date 14/10/2018
 */


public class RankBoard {
    private static final String Player = "player";
    private static final String Mark = "mark";
    private static final String NAME = "name";
    String name;
    int mark;

    public RankBoard(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }
    public RankBoard() {

    }

    static public RankBoard load(String filename) {
        File f = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        RankBoard res = new RankBoard();

        try {
            // load the xml tree
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);

            // parse the tree and obtain the player info
            Node player = doc.getFirstChild();

            NodeList nl = player.getChildNodes();
            for (int i =0;i< nl.getLength();i++) {
                Node n = nl.item(i);
                if (n.getNodeName().equals(NAME)) {
                    res.name = n.getTextContent();
                } else if (n.getNodeName().equals(Mark)) {
                    res.mark = Integer.parseInt(n.getTextContent());
                }
            }

        } catch (Exception e) {
            System.err.println("Problem loading " + filename);
        }
        return res;
    }

    public void save(String filename) {
        File f = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            // make the xml tree
            db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element player = doc.createElement(Player);

            Element en = doc.createElement(NAME);
            en.appendChild(doc.createTextNode(name));
            player.appendChild(en);

            Element ea = doc.createElement(Mark);
            ea.appendChild(doc.createTextNode(Integer.toString(mark)));
            player.appendChild(ea);

            doc.appendChild(player);
            // save the xml file
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // set xml encoding to utf-8
            transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Problem saving " + filename);
        }
    }

    public void show() {
        System.out.println("Name : " + name);
        System.out.println("Mark : " + mark);
    }

    public static void main(String[] args) {
        RankBoard data = new RankBoard("Hugh",10);
        data.save("RankData.xml");
        RankBoard dataload = load("RankData.xml");
        dataload.show();
    }



}
