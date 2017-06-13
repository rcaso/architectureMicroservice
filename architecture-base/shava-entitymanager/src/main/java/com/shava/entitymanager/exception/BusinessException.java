package com.shava.entitymanager.exception;

import javax.ejb.ApplicationException;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class BusinessException.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@ApplicationException(inherited=true,rollback=true)
public class BusinessException extends Exception {

	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 6242547663324560044L;

	/**
	 * Instancia un nuevo business exception.
	 */
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instancia un nuevo business exception.
	 *
	 * @param message el message
	 */
	public BusinessException(String message) {
		super(message);
	}
	
	

}
