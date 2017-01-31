package hei.tp05.web;

import hei.tp05.core.config.AppConfig;
import hei.tp05.core.config.DBConfig;
import hei.tp05.web.config.WSConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Thomas on 31/01/2017.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ AppConfig.class, DBConfig.class, WSConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }


    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        ServletRegistration.Dynamic cfxServlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        cfxServlet.addMapping("/services/*");
    }
}