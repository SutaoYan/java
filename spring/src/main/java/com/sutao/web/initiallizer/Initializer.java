package com.sutao.web.initiallizer;

import com.sutao.web.configuration.AppConfiguration;
import com.sutao.web.controller.Hello;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/** Indirectly invoked by {@link SpringServletContainerInitializer} in a Servlet 3+ container */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  @Override protected Class<?>[] getRootConfigClasses() {
    return new Class[] { AppConfiguration.class};
  }

  @Override protected Class<?>[] getServletConfigClasses() {
    return new Class[] {Hello.class};
  }
}