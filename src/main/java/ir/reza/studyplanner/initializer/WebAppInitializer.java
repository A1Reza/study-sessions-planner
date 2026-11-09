package ir.reza.studyplanner.initializer;

import ir.reza.studyplanner.config.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class}; //Introduces the Spring MVC configuration class.
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //Sends all application requests to DispatcherServlet.
    }
}
/*
Spring MVC Startup Architecture

        Tomcat
        Servlet Container

        WebAppInitializer
        Spring MVC Startup

        DispatcherServlet
        Receiving and Handling Requests

        AppConfig
        Component Scan and ViewResolver
*/