package com.thomsonreuters.ccertool;

import java.util.concurrent.ExecutorService;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class JettyFactoryBean extends Server implements ApplicationContextAware {

    private String contextConfigLocation;
    private String dispatcherPathSpec;

    private ApplicationContext applicationContext;

    public JettyFactoryBean(int serverPort) {
        super(serverPort);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void doStart() throws Exception {
        init();
        super.doStart();
    }

    public void init() {
        HandlerList handlerList = new HandlerList();
        setHandler(handlerList);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        handlerList.addHandler(context);

        SessionHandler sessionHandler = new SessionHandler();
        context.setSessionHandler(sessionHandler);

        
        GenericWebApplicationContext wac = new GenericWebApplicationContext();
        wac.setParent(applicationContext);
        wac.refresh();
        context.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, wac);
        
        // Add dispatcher servlet if specified
        if (contextConfigLocation != null) {
            DispatcherServlet dispatcher = new DispatcherServlet();
            dispatcher.setContextConfigLocation(contextConfigLocation);
            ServletHolder dispatcherServletHolder = new ServletHolder(dispatcher);
            dispatcherServletHolder.setName("dispatcher");
            context.addServlet(dispatcherServletHolder, dispatcherPathSpec);
        }
        
        

    }

    protected <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

   

    /**
     * Returns the {@link java.util.concurrent.ExecutorService} to inject into the servlet context, or {@code null} if the health checks
     * should be run in the servlet worker thread.
     */
    protected ExecutorService getExecutorService() {
        // don't use a thread pool by default
        return null;
    }

    public void setContextConfigLocation(String contextConfigLocation) {
        this.contextConfigLocation = contextConfigLocation;
    }

    public void setDispatcherPathSpec(String dispatcherPathSpec) {
        this.dispatcherPathSpec = dispatcherPathSpec;
    }

}
