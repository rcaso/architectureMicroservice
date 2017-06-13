package com.shava.core.configuration;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Interface StageDependent.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@Qualifier
@Inherited
@Target({PARAMETER, FIELD,METHOD })
@Retention(RUNTIME)
@Documented
public @interface StageDependent {

}
