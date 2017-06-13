package com.shava.security.security.authorization.type;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Enum HeaderValuesType.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
public enum HeaderValuesType {
	
	/** La cause. */
	CAUSE("cause"),
	
	/** La authorization. */
	AUTHORIZATION("Authorization"),
	
	/** La bearer. */
	BEARER("Bearer");
	
	/** La value. */
	private String value;
	
	/**
	 * Instancia un nuevo header values type.
	 *
	 * @param value el value
	 */
	private HeaderValuesType(String value){
		this.value=value;
	}
	
	/**
	 * Obtiene value.
	 *
	 * @return value
	 */
	public String getValue(){
		return this.value;
	}
}
