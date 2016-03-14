package com.thomsonreuters.ccertool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by artur on 11/03/15.
 */
public class AppContextController {

    private static ClassPathXmlApplicationContext context;
    public static final String DEFAULT_CONTEXT_DEFINITION_FILE = "applicationContext.xml";

    public static ApplicationContext loadAndStartContext() {
        return loadAndStartContext(DEFAULT_CONTEXT_DEFINITION_FILE);
    }

    public static ApplicationContext loadAndStartContext(String contextDefinition) {
        
        context = new ClassPathXmlApplicationContext(contextDefinition);
        context.registerShutdownHook();
        context.start();
        return context;
    }

    public static void stopContext() {
        context.close();
    }
}
