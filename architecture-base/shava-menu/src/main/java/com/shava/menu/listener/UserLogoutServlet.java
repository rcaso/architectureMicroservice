package com.shava.menu.listener;

import com.shava.core.configuration.Configurable;
import com.shava.core.configuration.StageDependent;
import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * <ul>
 * <li>Copyright 2017 Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class UserLogoutServlet.
 *
 * @author RCASO
 * @version 1.0 , 08-jun-2017
 */
@WebServlet("/userLogout")
public class UserLogoutServlet extends HttpServlet {
	
	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** La module name. */
	@Resource(lookup="java:module/ModuleName")
	private String moduleName;
	
	/** La service user menu url. */
	@Inject @StageDependent
	private String serviceUserMenuUrl;
	
	/** La url index. */
	@Inject
	@Configurable
	private String urlIndex;
	
	
       
    /**
     * Instancia un nuevo user logout servlet.
     */
    public UserLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	/**
	 * Process request.
	 *
	 * @param request el request
	 * @param response el response
	 * @throws ServletException the servlet exception
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.logout();
		request.getSession().invalidate();
		response.sendRedirect("/"+moduleName+"/"+urlIndex);
	}

}
