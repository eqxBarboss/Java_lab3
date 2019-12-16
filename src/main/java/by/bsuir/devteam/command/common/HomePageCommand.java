package by.bsuir.devteam.command.common;

import by.bsuir.devteam.command.Command;
import by.bsuir.devteam.command.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommand implements Command {

    private final Logger logger = LogManager.getLogger();
    private final static String xmlFile = "/Users/barboss/JavaProjects/LAB_3/src/main/resources/team.xml";

    public Page execute(HttpServletRequest request) {
        return new Page(Page.MAIN_PAGE_PATH, false);
    }
}