package by.bsuir.devteam.command.common;

import by.bsuir.devteam.command.Command;
import by.bsuir.devteam.command.Page;
import by.bsuir.devteam.entity.Team;
import by.bsuir.devteam.entity.employee.Tester;
import by.bsuir.devteam.parser.DOM;
import by.bsuir.devteam.parser.StaX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ShowTL_SP implements Command {

    private final Logger logger = LogManager.getLogger();
    private final static String xmlFile = "/Users/barboss/JavaProjects/LAB_3/src/main/resources/team.xml";

    @Override
    public Page execute(HttpServletRequest request) {

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

        DOM dom = DOM.getInstance();
        Team team = new Team();
        try{
            dom.manageTeam(team, xmlFile);
        }
        catch (SAXException | IOException | ParserConfigurationException e){
            logger.error(e.getMessage());
        }

        request.setAttribute("softwareProduct", team.getSoftwareProduct());
        request.setAttribute("teamLead", team.getTeamLead());

        return new Page(Page.TL_SP_PAGE_PATH, false);
    }

}