package com.shava.core.logging;

/**
 * <ul>
 * <li>Copyright 2016 Ministerio Publico - Fiscalia de la Nacion. Todos los derechos reservados.</li>
 * </ul> 
 
 La Interface ShavaLogger.
 *
 * @author OSIS
 * @version 1.0 , 15/04/2016
 */
public interface ShavaLogger {
	
	/**
	 * Debug.
	 *
	 * @param string el string
	 */
	public void debug(String string);
	
	/**
	 * Info.
	 *
	 * @param string el string
	 */
	public void info(String string);
	
	/**
	 * Warn.
	 *
	 * @param string el string
	 */
	public void warn(String string);
	
	/**
	 * Error.
	 *
	 * @param string el string
	 */
	public void error(String string);
}
