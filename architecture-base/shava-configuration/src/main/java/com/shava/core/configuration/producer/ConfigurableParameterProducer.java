package com.shava.core.configuration.producer;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import com.shava.core.configuration.Configurable;
import com.shava.core.configuration.FilesConfiguration;
import com.shava.core.logging.ShavaLogger;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class ConfigurableParameterProducer.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@ApplicationScoped
public class ConfigurableParameterProducer implements Serializable {

	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 3854336594189260914L;
	
	/** La log. */
	@Inject
	ShavaLogger log;

	/** La configuration file. */
	private Properties configurationFile;

	/**
	 * Instancia un nuevo configurable parameter producer.
	 */
	public ConfigurableParameterProducer() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init(){
		try(InputStream is = Configurable.class.getResourceAsStream("/"+FilesConfiguration.FILE_NAME_CONFIGURATION)) {
			configurationFile=new Properties();
			configurationFile.load(is);
		} catch(IOException iox) {
			log.info(iox.getMessage());
		}
	}
	
	/**
	 * Obtiene parameter string.
	 *
	 * @param point el point
	 * @return parameter string
	 */
	@Produces @Configurable
	public String getParameterString(InjectionPoint point){
		return getConfigurableNameField(point);
	}
	
	/**
	 * Obtiene parameter integer.
	 *
	 * @param point el point
	 * @return parameter integer
	 */
	@Produces @Configurable
	public Integer getParameterInteger(InjectionPoint point) {
		String value = getConfigurableNameField(point);
		return (value != null) ? Integer.valueOf(value) : null;
	}
	
	/**
	 * Obtiene parameter long.
	 *
	 * @param point el point
	 * @return parameter long
	 */
	@Produces @Configurable
	public Long getParameterLong(InjectionPoint point) {
		String value = getConfigurableNameField(point);
		return (value != null) ? Long.valueOf(value) : null;
	}
	
	/**
	 * Obtiene parameter boolean.
	 *
	 * @param point el point
	 * @return parameter boolean
	 */
	@Produces @Configurable
	public boolean getParameterBoolean(InjectionPoint point){
		String value = getConfigurableNameField(point);
		return (value != null) ? Boolean.parseBoolean(value) : false;
	}
	
	/**
	 * Obtiene configurable name field.
	 *
	 * @param point el point
	 * @return configurable name field
	 */
	private String getConfigurableNameField(InjectionPoint point) {
		AnnotatedField<Configurable> field = (AnnotatedField)point.getAnnotated();
		Configurable configurable = field.getAnnotation(Configurable.class);
		String value = null;
		if (configurable != null) {
			if (configurable.value()!= null && !configurable.value().isEmpty()) {
				value = getValueForKey(configurable.value());
			} else {
				value = getValueForKey(getNameField(point));
			}
		}
		return value;
	}
	
	/**
	 * Obtiene name field.
	 *
	 * @param point el point
	 * @return name field
	 */
	private String getNameField(InjectionPoint point) {
		return point.getMember().getName();
	}
	
	/**
	 * Obtiene value for key.
	 *
	 * @param fieldName el field name
	 * @return value for key
	 */
	private String getValueForKey(String fieldName) {
		return configurationFile.getProperty(fieldName);
	}

}
