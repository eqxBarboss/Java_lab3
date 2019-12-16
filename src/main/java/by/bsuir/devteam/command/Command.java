package by.bsuir.devteam.command;

import by.bsuir.devteam.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Page execute(HttpServletRequest request) throws ServiceException;
}
