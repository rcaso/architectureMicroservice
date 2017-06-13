package com.shava.jsf.core.bean.base;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.ws.rs.client.Client;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import com.shava.jsf.core.client.filter.HeaderTokenFilter;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class BaseBean.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
public abstract class BaseBean implements Serializable {

	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = -4904050226282386710L;
	
	/** La header token filter. */
	@Inject
	HeaderTokenFilter headerTokenFilter;
	
	/** La jaxrs client. */
	protected Client jaxrsClient;

	/**
	 * Instancia un nuevo base bean.
	 */
	public BaseBean() {
		
	}
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init(){
		//Especifico con wildfly
				jaxrsClient = new ResteasyClientBuilder()
		                .establishConnectionTimeout(2, TimeUnit.SECONDS)
//		                .socketTimeout(2, TimeUnit.SECONDS)
		                .register(headerTokenFilter)
		                .build();
	}
	
	/**
	 * Destroy.
	 */
	@PreDestroy
	public void destroy(){
		jaxrsClient.close();
	}
	
	

}
