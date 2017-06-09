package com.shava.jsf.core.exception.global;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;



/**
 * A factory for creating DefaultExceptionHandler objects.
 */
public class DefaultExceptionHandlerFactory extends ExceptionHandlerFactory {


	/** La parent. */
	private ExceptionHandlerFactory parent;

	/**
	 * Instancia un nuevo default exception handler factory.
	 *
	 * @param parent el parent
	 */
	public DefaultExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
	 */
	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler eh = parent.getExceptionHandler();
		eh = new DefaultExceptionHandler(eh);
		return eh;
	}
}
