package com.shava.entitymanager.converter;

import com.shava.common.converter.DateConverter;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class LocalDateConverter.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */


@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public Date convertToDatabaseColumn(LocalDate date) {
		// TODO Auto-generated method stub
                return DateConverter.convertToDate(date);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public LocalDate convertToEntityAttribute(Date value) {
		// TODO Auto-generated method stub
		return DateConverter.convertToLocalDate(value);
	}

}
