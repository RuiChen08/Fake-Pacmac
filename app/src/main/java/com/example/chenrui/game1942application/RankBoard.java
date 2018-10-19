package com.example.chenrui.game1942application;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * Use PersistantDataXML load and store the Mark Rank
 * @author Chucheng Qian(u6451847)
 * @Date 17/10/2018
 */


public class RankBoard {
    private static final String Rank = "rank";
    private static final String Player = "player";
    private static final String Mark = "mark";
    private static final String NAME = "name";
    String name;
    int mark;

    /*
     * @author: Chucheng Qian(u6451847)
     * @date: 18/10/2018
     */
    RankBoard(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    RankBoard() {
    }


    /*
     * @author: Chucheng Qian(u6451847)
     * @date: 18/10/2018
     */
    static ArrayList<RankBoard> load(String filename) {
        File f = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;

        ArrayList<RankBoard> rankList = new ArrayList<>();

        try {
            // load the xml tree
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);

            // parse the tree and obtain the player info
            Node rank = doc.getFirstChild();

            NodeList nl = rank.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                RankBoard res = new RankBoard();
                Node n = nl.item(i);


                NodeList nll = n.getChildNodes();
                for (int ii = 0; ii < nll.getLength(); ii++) {
                    Node nn = nll.item(ii);


                    if (nn.getNodeName().equals(NAME)) {
                        res.name = nn.getTextContent();
                    } else if (nn.getNodeName().equals(Mark)) {
                        res.mark = Integer.parseInt(nn.getTextContent());
                    }

                }
                rankList.add(res);
            }

        } catch (Exception e) {
            System.err.println("Problem loading " + filename);
        }
        return rankList;
    }

    /*
     * @author: Chucheng Qian(u6451847)
     * @date: 18/10/2018
     */
    static Document create(String filename) {
        File f = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element rank = doc.createElement(Rank);
            doc.appendChild(rank);
            // set xml encoding to utf-8
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();


            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);

            return doc;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*
     * @author: Chucheng Qian(u6451847)
     * @date: 18/10/2018
     */
    void save(String filename) {
        File f = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            // make the xml tree
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);

            Element rank = doc.getDocumentElement();


            Element player = doc.createElement(Player);

            Element en = doc.createElement(NAME);
            en.appendChild(doc.createTextNode(name));
            player.appendChild(en);

            Element ea = doc.createElement(Mark);
            ea.appendChild(doc.createTextNode(Integer.toString(mark)));
            player.appendChild(ea);


            NodeList players = rank.getChildNodes();

            if (players.getLength() == 0) {
                rank.appendChild(player);

            } else if (players.getLength() == 1) {

                Node n0 = players.item(0);


                NodeList attributes0 = n0.getChildNodes();
                int m1 = Integer.parseInt(attributes0.item(1).getTextContent());
                if (mark >= m1) {
                    rank.insertBefore(player, n0);
                } else {
                    rank.appendChild(player);
                }
            }

            for(int i=0;i<players.getLength()-1;i++){
                Node n1 = players.item(i);
                Node n2 = players.item(i+1);

                NodeList attributes1 = n1.getChildNodes();
                NodeList attributes2 = n2.getChildNodes();

                int  m1 = Integer.parseInt(attributes1.item(1).getTextContent());
                int  m2 = Integer.parseInt(attributes2.item(1).getTextContent());

                if (mark<=m1 && mark >=m2) {
                    rank.insertBefore(player,n2);
                    break;
                }else if(mark>m1){
                    rank.insertBefore(player,n1);
                    break;
                }

                if(i==players.getLength()-2 && mark<m2 ){
                    rank.appendChild(player);
                }
            }


            // save the xml file
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // set xml encoding to utf-8
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Problem saving " + filename);
        }
    }

}
