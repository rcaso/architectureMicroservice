package com.shava.jsf.core.bean.base;

import com.shava.core.configuration.Configurable;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;



/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class ApplicationParameters.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@Named
@ApplicationScoped
public class ApplicationParameters implements Serializable{

	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 4398059015825404504L;
	
	/** La url index. */
	@Inject @Configurable
	private String urlIndex;
	

	/**
	 * Instancia un nuevo application parameters.
	 */
	public ApplicationParameters() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Obtiene url index.
	 *
	 * @return url index
	 */
	public String getUrlIndex() {
		return urlIndex;
	}

}
