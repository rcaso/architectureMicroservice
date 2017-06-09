package com.shava.menu.model;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Enum LanguageType.
 *
 * @author OSIS
 * @version 1.0 , 08-jun-2017
 */
public enum LanguageType {
	
	/** La spanish. */
	SPANISH("es"),
	
	/** La english. */
	ENGLISH("en");
	
	/** La value. */
	private String value;
	
	/**
	 * Instancia un nuevo language type.
	 *
	 * @param value el value
	 */
	private LanguageType(String value) {
		this.value = value;
	}
	
	/**
	 * Obtiene value.
	 *
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	
	
}
