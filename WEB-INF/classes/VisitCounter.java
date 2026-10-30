import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class VisitCounter extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
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
		int s = 0;
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("count")){
					Cookie c1 = new Cookie("count",String.valueOf(Integer.parseInt(c.getValue())+1));
					out.println("<p> visits = "+c1.getValue()+"</p>");
					response.addCookie(c1); 
					s++;
				}
			}
		}
		if(s==0){
			Cookie c1 = new Cookie("count","1");
			out.println("<p> visits = "+c1.getValue()+"</p>");
			response.addCookie(c1);
		}
		out.println("</body>");
		out.println("</html>");
	}
}