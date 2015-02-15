package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by vanya on 14.02.15.
 */
public class DomParseXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder =
                builderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("/home/vanya/IdeaProjects/week5/src/users.xml"));
        Element root = document.getDocumentElement();// get root
//        DomParserUtils.printXml(root);
        System.out.println(DomParserUtils.getStringFromXml(root));

    }


}
