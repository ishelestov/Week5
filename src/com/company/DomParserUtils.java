package com.company;

import org.w3c.dom.*;

/**
 * Created by vanya on 14.02.15.
 */
public class DomParserUtils {
    private static String result = "";
    public static String getStringFromXml(Element element){
        result+="<"+element.getTagName()+">";
        if (element.hasAttributes()){
            result+=formatAttr(element);
        }

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                result= getStringFromXml((Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                result+=child.getNodeValue();
            }
        }
        result+="</"+ element.getNodeName()+">";
        return result;
    }
    public static void printXml(Element element){

        System.out.printf("<%s%s>",
                element.getTagName(),
                element.hasAttributes() ? formatAttr(element) : "");
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printXml((Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.print(child.getNodeValue());
            }
        }
        System.out.printf("</%s>", element.getNodeName());

    }

    private static String formatAttr(Element element){
        String result = " ";
        NamedNodeMap namedNodeMap = element.getAttributes();
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            Node node = namedNodeMap.item(i);
            Attr attr = (Attr) node;
            if (i==(namedNodeMap.getLength()-1)){
                result += attr.getName() + "=\"" + attr.getValue() + "\"";// if last attr - print without space in the end
            } else {
                result += attr.getName() + "=\"" + attr.getValue() + "\" ";
            }



        }
        return result;

    }
}
