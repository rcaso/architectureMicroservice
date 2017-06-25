package com.shava.entitymanager.converter;

import com.shava.common.converter.DateConverter;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class LocalDateTimeConverter.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public Date convertToDatabaseColumn(LocalDateTime date) {
		// TODO Auto-generated method stub
                return DateConverter.converToDate(date);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public LocalDateTime convertToEntityAttribute(Date value) {
		// TODO Auto-generated method stub
		return DateConverter.convertToLocalDateTime(value);
	}

}
