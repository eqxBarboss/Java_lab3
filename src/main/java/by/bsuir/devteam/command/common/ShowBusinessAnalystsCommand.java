package by.bsuir.devteam.command.common;


import by.bsuir.devteam.command.Command;
import by.bsuir.devteam.command.Page;
import by.bsuir.devteam.entity.employee.BusinessAnalyst;
import by.bsuir.devteam.entity.employee.Tester;
import by.bsuir.devteam.parser.StaX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShowBusinessAnalystsCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final static String xmlFile = "/Users/barboss/JavaProjects/LAB_3/src/main/resources/team.xml";

    @Override
    public Page execute(HttpServletRequest request) {

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

        List<BusinessAnalyst> businessAnalysts = new ArrayList<>();
        try (StaX processor = new StaX(Files.newInputStream(Paths.get(xmlFile)))) {
            businessAnalysts = processor.getBusinessAnalysts();
        }
        catch (XMLStreamException | IOException e){
            logger.error(e.getMessage());
        }

        int rows = businessAnalysts.size();

        if (currentPage * recordsPerPage >= rows) {
            request.setAttribute("businessAnalysts", businessAnalysts.subList((currentPage - 1) * recordsPerPage, rows));
        } else {
            request.setAttribute("businessAnalysts", businessAnalysts.subList((currentPage - 1) * recordsPerPage, currentPage * recordsPerPage));
        }

        int nOfPages = rows / recordsPerPage;

        if (rows % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        return new Page(Page.BUSINESS_ANALYSTS_PAGE_PATH, false);
    }

}

