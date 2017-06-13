package com.shava.core.logging.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shava.core.logging.ShavaLogger;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class LoggerProducer.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@ApplicationScoped
public class LoggerProducer {
	
	/**
	 * Obtiene logger.
	 *
	 * @param ip el ip
	 * @return logger
	 */
	@Produces
	public ShavaLogger getLogger(InjectionPoint ip) {
		Class<?> aClass = ip.getMember().getDeclaringClass();
        Logger logger = LoggerFactory.getLogger(aClass.getName());
        return new Slf4Logger(logger);
	}
}
