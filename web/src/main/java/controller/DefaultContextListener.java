package controller;

import by.epam.parser.service.ParserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Set;

@WebListener
public class DefaultContextListener implements ServletContextListener {

    private static final String PARSERS = "parsers";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Set<String> parsers = ParserUtil.getParsers();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(PARSERS, parsers);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
