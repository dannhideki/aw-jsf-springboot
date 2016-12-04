package br.com.globalcode.jsf.config;

import java.util.HashMap;
import java.util.Map;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class WebJsfConfig implements ServletContextAware {

	    @Bean
	    public static CustomScopeConfigurer getViewScopeConfigurer() {
	        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
	        Map<String, Object> view = new HashMap<>();
	        view.put("view", viewScope());
	        customScopeConfigurer.setScopes(view);
	        return customScopeConfigurer;
	    }

	    @Bean
	    public static ViewScope viewScope() {
	        return new ViewScope();
	    } 

	    @Bean
	    public FacesServlet facesServlet() {
	        return new FacesServlet();
	    }
	    
	    @Bean
	    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
	        return new ServletListenerRegistrationBean<ConfigureListener>(
	                new ConfigureListener());
	    }

	    @Override
	    public void setServletContext(ServletContext servletContext) {
	    	
	    	ServletRegistration servletRegistration = servletContext.getServletRegistration("FacesServlet");
	        if (servletRegistration != null) {
	            servletRegistration.addMapping("*.xhtml");
	            servletRegistration.addMapping("*.jsf");
	            servletRegistration.addMapping("*.faces");
	        }
	        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	    }
	}
