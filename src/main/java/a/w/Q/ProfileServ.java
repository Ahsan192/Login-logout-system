package a.w.Q;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServ
 */
public class ProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServ() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession htp = request.getSession(false);
		
		if(htp!=null) {
			String name = (String) htp.getAttribute("n");
			out.println("<h3 style='color:green; text-alogn:center;'>Hello"+name+"welcome to product page</h3>");
			
		}else {
			out.println("<h3 style='color:red; text-align:center'> you may login  first</h3>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

}
