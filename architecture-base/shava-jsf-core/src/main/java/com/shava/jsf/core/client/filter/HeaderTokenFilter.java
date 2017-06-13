package com.shava.jsf.core.client.filter;

import com.shava.core.configuration.Configurable;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;


import com.shava.jsf.core.client.extractor.TokenExtractor;
import com.shava.security.security.authorization.type.HeaderValuesType;


/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class HeaderTokenFilter.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@ApplicationScoped
@Provider
public class HeaderTokenFilter implements ClientRequestFilter {
	
	/** La token extractor. */
	@Inject
	TokenExtractor tokenExtractor;
	
	/** La client id services app. */
	@Inject @Configurable
	String clientIdServicesApp;
	
	/** La authorization enabled. */
	@Inject @Configurable
	boolean authorizationEnabled;
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.client.ClientRequestFilter#filter(javax.ws.rs.client.ClientRequestContext)
	 */
	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().
		putSingle(HeaderValuesType.AUTHORIZATION.getValue(),HeaderValuesType.BEARER.getValue()+" "+tokenExtractor.getAccessToken(clientIdServicesApp,authorizationEnabled));
	}

}
