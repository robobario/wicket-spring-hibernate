package org.example.app;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setInitParameter(ContextLoader.CONTEXT_CLASS_PARAM, "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        event.getServletContext().setInitParameter(ContextLoader.CONFIG_LOCATION_PARAM, "org.example.app.Context");
        super.contextInitialized(event);
    }
}
