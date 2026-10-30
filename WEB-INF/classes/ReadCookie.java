import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class ReadCookie extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
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
		Cookie[] cookies = request.getCookies();
		if(cookies == null){out.println("<p>No cookies found!</p>");}
		else{
			for(Cookie c : cookies){
				out.println("<p>"+c.getName()+" "+c.getValue()+"</p>");
				out.println("<br>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}
}