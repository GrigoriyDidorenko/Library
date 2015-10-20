package net.didorenko.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * package: net.didorenko.listeners
 * project: Library
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 20.10.2015
 */
public class ContextListener implements ServletContextListener {

    private HashMap sessionMap = new HashMap<String, HttpSession>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().removeAttribute("sessionMap");
        sessionMap = null;
    }
}
