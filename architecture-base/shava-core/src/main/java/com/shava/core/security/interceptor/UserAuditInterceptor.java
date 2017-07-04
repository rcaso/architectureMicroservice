package com.shava.core.security.interceptor;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.TransactionSynchronizationRegistry;

import com.shava.core.security.UserAudit;
import com.shava.common.contextholder.ThreadLocalContextHolder;
import com.shava.common.audit.RegistryContextHolder;


/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class UserAuditInterceptor.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@UserAudit
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class UserAuditInterceptor implements Serializable {

	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 8594142776848001204L;
	
	/** La registry. */
	@Resource
	private TransactionSynchronizationRegistry registry;

	/**
	 * Instancia un nuevo user audit interceptor.
	 */
	public UserAuditInterceptor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Around invoke.
	 *
	 * @param ic el ic
	 * @return the object
	 * @throws Exception the exception
	 */
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		if (ThreadLocalContextHolder.checkInitialited()) {
			//agregamos a la transaccion la pista de auditoria del usuario que llamo al servicio
			registry.putResource(RegistryContextHolder.USER_TRACK,
					ThreadLocalContextHolder.get(RegistryContextHolder.USER_TRACK));
		}
		return ic.proceed();
	}

}
