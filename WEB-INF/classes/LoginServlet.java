import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userName = request.getParameter("userName");
		HttpSession s = request.getSession(true);
		s.setAttribute("user",userName);
		PrintWriter out;
		out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Confirmed ! you can access now to items page </p>");
		out.println("<a href=\"/web-development-lab/items.html\">Go to items</a>");
		out.println("</body>");
		out.println("</html>");
	}
}