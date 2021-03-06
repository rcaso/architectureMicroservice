package com.shava.core.exception.provider;

import com.shava.core.logging.ShavaLogger;
import com.shava.common.authorization.type.HeaderValuesType;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;



/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class EJBExceptionMapper.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBException> {
	
	/** La log. */
	@Inject
	ShavaLogger log;

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
    public Response toResponse(EJBException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof OptimisticLockException) {
            OptimisticLockException actual = (OptimisticLockException) cause;
            log.error(actual.getMessage() + actual.getEntity()!=null?actual.getEntity().toString():"");
            return Response.status(Response.Status.CONFLICT).
                    header(HeaderValuesType.CAUSE.getValue(), "El registro ya fue procesado : ").
//                    header("additional-info", actual.getMessage()).
                    build();

        } else if(cause instanceof EntityNotFoundException){
        	EntityNotFoundException actual = (EntityNotFoundException)cause;
        	log.error(actual.getMessage());
        	return Response.status(Response.Status.NOT_FOUND).
        			header(HeaderValuesType.CAUSE.getValue(), "Entidad no se encuentra registrada ").build();
        }
        else {
            //Otra exception EJB
        	log.error(cause.getMessage());
        	log.error(ex.toString());
        	return Response.serverError().
                    header(HeaderValuesType.CAUSE.getValue(),"Un error inesperado ha ocurrido en el servidor").build();
        }
    }

}
