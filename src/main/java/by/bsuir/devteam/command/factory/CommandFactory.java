package by.bsuir.devteam.command.factory;


import by.bsuir.devteam.command.Command;
import by.bsuir.devteam.command.CommandType;
import by.bsuir.devteam.command.common.HomePageCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

    private final Logger logger = LogManager.getLogger();

    public Command getCommand(HttpServletRequest req) {
        Command currCommand = new HomePageCommand();
        String command = req.getParameter("command");
        try {
            String commandTypeValue = command.toUpperCase();
            CommandType currentType = CommandType.getCommand(commandTypeValue);
            currCommand = currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
           logger.error(e.getMessage());
        }
        return currCommand;
    }
}
