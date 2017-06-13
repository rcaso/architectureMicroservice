package com.shava.core.logging.producer;

import org.slf4j.Logger;

import com.shava.core.logging.ShavaLogger;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class Slf4Logger.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
public class Slf4Logger implements ShavaLogger {
	
	/** La logger. */
	private Logger logger; 

	/**
	 * Instancia un nuevo slf 4 logger.
	 *
	 * @param logger el logger
	 */
	public Slf4Logger(Logger logger) {
		this.logger = logger;
	}

	/* (non-Javadoc)
	 * @see pe.gob.mpfn.core.logging.ShavaLogger#debug(java.lang.String)
	 */
	@Override
	public void debug(String mensaje) {
		logger.debug(mensaje);
	}

	/* (non-Javadoc)
	 * @see pe.gob.mpfn.core.logging.ShavaLogger#info(java.lang.String)
	 */
	@Override
	public void info(String mensaje) {
		logger.info(mensaje);
		
	}

	/* (non-Javadoc)
	 * @see pe.gob.mpfn.core.logging.ShavaLogger#warn(java.lang.String)
	 */
	@Override
	public void warn(String mensaje) {
		logger.warn(mensaje);
	}

	/* (non-Javadoc)
	 * @see pe.gob.mpfn.core.logging.ShavaLogger#error(java.lang.String)
	 */
	@Override
	public void error(String mensaje) {
		logger.error(mensaje);
	}

}
