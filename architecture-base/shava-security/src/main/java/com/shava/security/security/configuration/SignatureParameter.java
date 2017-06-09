package com.shava.security.security.configuration;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class SignatureParameter.
 *
 * @author OSIS
 * @version 1.0 , 08-jun-2017
 */
public class SignatureParameter {
	
	/** La log. */
	private static Logger LOG = Logger.getLogger(SignatureParameter.class.getName());
	
	/** La issuer signature. */
	private String issuerSignature;
	
	/** La key signature. */
	private String keySignature;
	
	/** La user name. */
	private String userName="nombre";
	
	/** La user DNI. */
	private String userDNI="dni";
	
	/** La user IP. */
	private String userIP="ip";
	
	/** La signature parameter. */
	private static SignatureParameter signatureParameter;
	
	/**
	 * Obtiene la instancia de SignatureParameter.
	 *
	 * @return instancia de SignatureParameter
	 */
	public static SignatureParameter getInstance(){
		if(signatureParameter==null){
			signatureParameter = new SignatureParameter();
		}
		return signatureParameter;
	}
	
	/**
	 * Instancia un nuevo signature parameter.
	 */
	private SignatureParameter(){
		try(InputStream file = SignatureParameter.class.getResourceAsStream("/signature.properties")){
			Properties keys=new Properties();
			keys.load(file);
			issuerSignature=keys.getProperty("issuer.signature");
			keySignature=keys.getProperty("key.signature");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "No pudo cargar configuracion del cifrado Json");
		}
	}
	
	/**
	 * Obtiene issuer signature.
	 *
	 * @return issuer signature
	 */
	public String getIssuerSignature() {
		return issuerSignature;
	}

	/**
	 * Obtiene key signature.
	 *
	 * @return key signature
	 */
	public String getKeySignature() {
		return keySignature;
	}

	/**
	 * Obtiene user name.
	 *
	 * @return user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Obtiene user DNI.
	 *
	 * @return user DNI
	 */
	public String getUserDNI() {
		return userDNI;
	}

	/**
	 * Obtiene user IP.
	 *
	 * @return user IP
	 */
	public String getUserIP() {
		return userIP;
	}
	
}
