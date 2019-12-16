package by.bsuir.devteam.parser;

import by.bsuir.devteam.entity.employee.BusinessAnalyst;
import by.bsuir.devteam.entity.employee.Developer;
import by.bsuir.devteam.entity.employee.Tester;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaX implements AutoCloseable {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public StaX(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

    private boolean startElement(String element, String parent) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (parent != null && event == XMLEvent.END_ELEMENT &&
                    parent.equals(reader.getLocalName())) {
                return false;
            }
            if (event == XMLEvent.START_ELEMENT &&
                    element.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    private String getAttribute(String name) {
        return reader.getAttributeValue(null, name);
    }

    private String getText() throws XMLStreamException {
        return reader.getElementText();
    }

    public List<Developer> getDevelopers() throws XMLStreamException {
        List<Developer> developers = new ArrayList<>();

        while (startElement("developer", "developers")) {
            Developer developer = new Developer();
            developer.setId(Integer.parseInt(getAttribute("id").substring(1)));
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.END_ELEMENT && "developer".equals(reader.getLocalName())) {
                    developers.add(developer);
                    break;
                }
                if (event == XMLEvent.START_ELEMENT) {
                    String data = getText();
                    switch (reader.getLocalName()) {
                        case "name":
                            developer.setName(data);
                            break;
                        case "surname":
                            developer.setSurname(data);
                            break;
                        case "phoneNumber":
                            developer.setPhoneNumber(data);
                            break;
                        case "favoriteGame":
                            developer.setFavoriteGame(data);
                            break;
                    }
                }
            }
        }
        return developers;
    }

    public List<Tester> getTesters() throws XMLStreamException {
        List<Tester> testers = new ArrayList<>();

        while (startElement("tester", "testers")) {
            Tester tester = new Tester();
            tester.setId(Integer.parseInt(getAttribute("id").substring(1)));
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.END_ELEMENT && "tester".equals(reader.getLocalName())) {
                    testers.add(tester);
                    break;
                }
                if (event == XMLEvent.START_ELEMENT) {
                    String data = getText();
                    switch (reader.getLocalName()) {
                        case "name":
                            tester.setName(data);
                            break;
                        case "surname":
                            tester.setSurname(data);
                            break;
                        case "phoneNumber":
                            tester.setPhoneNumber(data);
                            break;
                        case "testsWritten":
                            tester.setTestWritten(Integer.parseInt(data));
                            break;
                    }
                }
            }
        }
        return testers;
    }

    public List<BusinessAnalyst> getBusinessAnalysts() throws XMLStreamException {
        List<BusinessAnalyst> businessAnalysts = new ArrayList<>();

        while (startElement("businessAnalyst", "businessAnalysts")) {
            BusinessAnalyst businessAnalyst = new BusinessAnalyst();
            businessAnalyst.setId(Integer.parseInt(getAttribute("id").substring(1)));
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.END_ELEMENT && "businessAnalyst".equals(reader.getLocalName())) {
                    businessAnalysts.add(businessAnalyst);
                    break;
                }
                if (event == XMLEvent.START_ELEMENT) {
                    String data = getText();
                    switch (reader.getLocalName()) {
                        case "name":
                            businessAnalyst.setName(data);
                            break;
                        case "surname":
                            businessAnalyst.setSurname(data);
                            break;
                        case "phoneNumber":
                            businessAnalyst.setPhoneNumber(data);
                            break;
                        case "nickName":
                            businessAnalyst.setNickName(data);
                            break;
                    }
                }
            }
        }
        return businessAnalysts;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { }
        }
    }
}

