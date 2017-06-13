package com.shava.core.configuration.producer;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.shava.core.configuration.Configurable;
import com.shava.core.configuration.FilesConfiguration;
import com.shava.core.configuration.type.StageApplication;
import com.shava.core.logging.ShavaLogger;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class StageProducer.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@ApplicationScoped
public class StageProducer implements Serializable {

	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 6348463581994618847L;
	
	/** La log. */
	@Inject
	ShavaLogger log;
	
	/** La configuration file. */
	private Properties configurationFile;

	/**
	 * Instancia un nuevo stage producer.
	 */
	public StageProducer() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init(){
		try(InputStream is = Configurable.class.getResourceAsStream("/"+FilesConfiguration.FILE_NAME_STAGE)) {
			configurationFile=new Properties();
			configurationFile.load(is);
		} catch(IOException iox) {
			log.info(iox.getMessage());
		}
	}
	
	/**
	 * Obtiene stage.
	 *
	 * @return stage
	 */
	@Produces
	public StageApplication getStage() {
		return StageApplication.valueOf(configurationFile.getProperty("app.stage.key", "Production"));
	}

}
