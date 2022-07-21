

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/ok")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		//String init = getInitParameter("") // Getting init parameters in servlet scope
		// String contextParams = getServletContext().getInitParameter("") // Getting the parameters in entire app scope 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie aux : cookies){    
				response.getWriter().append("\n"+ aux.getName()+" - "+ aux.getValue());
			}
		}*/
		response.getWriter().append("First name: " + firstName).append("\nLast name: " + lastName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String subjects = String.join(", ", request.getParameterValues("subject"));
		//Cookie cookie =new Cookie("aula", "web");
		//response.addCookie(cookie);
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("first_name") == null) {
			session.setAttribute("first_name", firstName);
			response.getWriter().append("Session created!");
		} else {
			response.getWriter().append("Session exists!");
		}
		
		//response.getWriter().append(subjects);
	}

}
