package by.bsuir.devteam.controller;

import by.bsuir.devteam.command.Command;
import by.bsuir.devteam.command.Page;
import by.bsuir.devteam.command.factory.CommandFactory;
import by.bsuir.devteam.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            CommandFactory commandFactory = new CommandFactory();
            Command command = commandFactory.getCommand(req);
            Page page = command.execute(req);
            boolean isRedirect = page.isRedirect();
            if (isRedirect) {
                redirect(page, req, resp);
            } else {
                forward(page, req, resp);
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ServletException(e.getMessage(), e);
        }
    }

    private void redirect(Page page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = page.getPageUrl();
        response.sendRedirect(request.getContextPath() + url);
    }

    private void forward(Page page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = page.getPageUrl();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}