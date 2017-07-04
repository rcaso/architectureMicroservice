/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shava.entitymanager.converter;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * <ul>
 * <li>Copyright 2017  Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class CryptoConverter.
 *
 * @author raul
 * @version 1.0 , 04/07/2017
 */
@Converter
public class CryptoConverter implements AttributeConverter<String, String>  {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final byte[] KEY = "secretKeyCrypto".getBytes();

    @Override
    public String convertToDatabaseColumn(String ccNumber) {
      // do some encryption
      Key key = new SecretKeySpec(KEY, "AES");
      try {
         Cipher c = Cipher.getInstance(ALGORITHM);
         c.init(Cipher.ENCRYPT_MODE, key);
         return Base64.getEncoder().encodeToString(c.doFinal(ccNumber.getBytes()));
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
      // do some decryption
      Key key = new SecretKeySpec(KEY, "AES");
      try {
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        return new String(c.doFinal(Base64.getDecoder().decode(dbData)));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

}
