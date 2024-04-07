package a.w.Q;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(password.equals("cnc123")) {
			out.println("<h3 style='color:green; text-align:center'>Welcome to our webSite "+ name+"</h3>");
			HttpSession htp = request.getSession();
			htp.setAttribute("n", name);
		}else {
			out.println("<h3 style='color:red; text-align:center'>Inavalid user or password</h3>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

}
