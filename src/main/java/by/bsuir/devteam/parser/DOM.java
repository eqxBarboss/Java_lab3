package by.bsuir.devteam.parser;

import by.bsuir.devteam.entity.SoftwareProduct;

import by.bsuir.devteam.entity.Team;
import by.bsuir.devteam.entity.employee.TeamLead;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import org.w3c.dom.Node;

public class DOM {

    private static Document document = null;
    private static DOM instance = new DOM();

    public static DOM getInstance() {
        return instance;
    }

    private static void parseXmlFile(File xmlFile) throws IOException, SAXException, ParserConfigurationException {
        if (document == null) {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
            document.normalize();
        }
    }

    public void manageTeam(Team team, String filepath) throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File(filepath);
        DOM.parseXmlFile(xmlFile);

        NodeList nodes = document.getDocumentElement().getElementsByTagName("softwareProduct");
        SoftwareProduct softwareProduct = getSoftwareProductFromNode(nodes.item(0));
        softwareProduct.setId(Integer.parseInt(((Element) nodes.item(0)).getAttribute("id").substring(1)));

        nodes = document.getDocumentElement().getElementsByTagName("teamLead");
        TeamLead teamLead = getTeamLeadFromNode(nodes.item(0));
        teamLead.setId(Integer.parseInt(((Element) nodes.item(0)).getAttribute("id").substring(2)));

        team.setSoftwareProduct(softwareProduct);
        team.setTeamLead(teamLead);
    }

    private SoftwareProduct getSoftwareProductFromNode(Node node) {
        SoftwareProduct softwareProduct = new SoftwareProduct();
        NodeList spProps = node.getChildNodes();
        String nodeName;
        for (int j = 0; j < spProps.getLength(); j++) {
            if (spProps.item(j).getNodeType() != Node.TEXT_NODE) {
                nodeName = spProps.item(j).getNodeName();
                switch (nodeName) {
                    case "title":
                        softwareProduct.setTitle(spProps.item(j).getTextContent());
                        break;
                    case "customer":
                        softwareProduct.setCustomer(spProps.item(j).getTextContent());
                        break;
                }
            }
        }
        return softwareProduct;
    }

    private TeamLead getTeamLeadFromNode(Node node) {
        TeamLead teamLead = new TeamLead();
        NodeList spProps = node.getChildNodes();
        String nodeName;
        for (int j = 0; j < spProps.getLength(); j++) {
            if (spProps.item(j).getNodeType() != Node.TEXT_NODE) {
                nodeName = spProps.item(j).getNodeName();
                switch (nodeName) {
                    case "name":
                        teamLead.setName(spProps.item(j).getTextContent());
                        break;
                    case "surname":
                        teamLead.setSurname(spProps.item(j).getTextContent());
                        break;
                    case "phoneNumber":
                        teamLead.setPhoneNumber(spProps.item(j).getTextContent());
                        break;
                    case "favoriteGame":
                        teamLead.setFavoriteGame(spProps.item(j).getTextContent());
                        break;
                    case "motto":
                        teamLead.setMotto(spProps.item(j).getTextContent());
                        break;
                }
            }
        }
        return teamLead;
    }
}