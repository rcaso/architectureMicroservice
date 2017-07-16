package com.shava.core.security.provider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;

import com.shava.core.security.TokenAuthenticated;
import com.shava.common.contextholder.ThreadLocalContextHolder;
import com.shava.common.audit.RegistryContextHolder;
import com.shava.common.audit.entity.UserTrack;




/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class BearerTokenFilter.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@Provider
@Priority(Priorities.AUTHORIZATION)
@TokenAuthenticated
public class BearerTokenFilter implements ContainerRequestFilter {
	

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 */
	@Override
	public void filter(ContainerRequestContext ctx) throws IOException {
		KeycloakPrincipal<KeycloakSecurityContext> keyCloak = (KeycloakPrincipal<KeycloakSecurityContext>)ctx.getSecurityContext().getUserPrincipal();
		if(keyCloak != null){
			createUserTrack(keyCloak.getKeycloakSecurityContext().getToken());
		}
	}
	
	/**
	 * Creates the user track.
	 *
	 * @param token el token
	 */
	private void createUserTrack(AccessToken token){
		UserTrack userTrack = new UserTrack();
		userTrack.setUserName(token.getPreferredUsername());
		userTrack.setIpAddress("255.255.255.255");
		List<String> roles = new ArrayList<>(); 
		token.getRealmAccess().getRoles().stream().forEach(role->roles.add(role));
		token.getResourceAccess().entrySet().stream().forEach( entry-> {
    		entry.getValue().getRoles().stream().forEach(rol->roles.add(rol));
    	});
		ThreadLocalContextHolder.put(RegistryContextHolder.USER_TRACK, userTrack);
	}
}
