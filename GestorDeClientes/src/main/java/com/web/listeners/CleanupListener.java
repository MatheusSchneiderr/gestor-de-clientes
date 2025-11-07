package com.web.listeners;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CleanupListener
 *
 */
@WebListener
public class CleanupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CleanupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[MySQL] CleanupListener initialized successfully!");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[MySQL] Cleaning up JDBC resources...");
        try {
            AbandonedConnectionCleanupThread.checkedShutdown();
            System.out.println("[MySQL] Cleanup thread stopped successfully.");
        } catch (Exception e) {
            System.err.println("[MySQL] Error shutting down cleanup thread: " + e.getMessage());
        }
    }
	
}
