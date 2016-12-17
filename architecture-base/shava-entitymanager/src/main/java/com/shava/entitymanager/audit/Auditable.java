package com.shava.entitymanager.audit;

import com.shava.security.security.audit.entity.UserTrack;
import java.util.List;
import java.util.Map;



/**
 * <ul>
 * <li>Copyright 2016 Ministerio Publico - Fiscalia de la Nacion. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Interface Auditable.
 *
 * @author OSIS
 * @version 1.0 , 08/04/2016
 */
public interface Auditable {
	
	/**
	 * Establece el audit.
	 *
	 * @param loggerUser el new audit
	 */
	public void setAudit(UserTrack loggerUser);
	
	/**
	 * Gets the list for audit.
	 *
	 * @return the list for audit
	 */
	public Map<String,List<? extends Auditable>> getListForAudit(); 
	
}
