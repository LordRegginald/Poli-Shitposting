package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlABMUsuario;
import entity.Usuario;
import util.AppDataException;
//import util.Emailer;

/**
 * Servlet implementation class Start
 */
@WebServlet({ "/Start", "/start" })
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private Logger logger;
    /**
     * Default constructor. 
     */
    public Start() {
 //   	logger = LogManager.getLogger(getClass());
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String us=request.getParameter("email");
			String pass=request.getParameter("password");
			
			Usuario usu=new Usuario();
			usu.setNombre_de_usuario(us);
			usu.setClave(pass);
			
			CtrlABMUsuario ctrl= new CtrlABMUsuario();
			
			Usuario user=ctrl.login(usu);
			
		/*	try {
				request.setAttribute("listaUsuarios", ctrl.getAll());
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (Exception e) {
				response.setStatus(502);
			}*/
			request.getSession().setAttribute("user", user);
			
	//		Emailer.getInstance().send("cirotikoso@gmail.com","Lista Personas",ctrl.personaListText());
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			//response.getWriter().append(user).append(" ").append(pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
