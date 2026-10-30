import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShowSession extends HttpServlet{
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
		HttpSession s = request.getSession(true);
		if(s.isNew()){
			s.setAttribute("countVisit","1");
			out.println("<h1>Welcome on my site</h1>");
			out.println("<form method=\"post\" action=\"Show\">");
        		out.println("<label >First Name : </label>");
        		out.println("<input type=\"text\" name=\"firstName\"/>");
        		out.println("<br>");
        		out.println("<label>Last Name : </label>");
        		out.println("<input type=\"text\" name=\"lastName\"/>");
        		out.println("<br>");
        		out.println("<label>Birth Date : </label>");
        		out.println("<input type=\"date\" name=\"birthDate\"/>");
        		out.println("<br>");
			out.println("<input type=\"submit\" value=\"Submit\">");
			out.println("<br>");
    			out.println("</form>");
		}
		else{
			out.println("<h1>Welcome back !</h1>");
			s.setAttribute("countVisit",String.valueOf(Integer.parseInt((String)s.getAttribute("countVisit"))+1));
			LocalDate birthDate = LocalDate.parse((String) s.getAttribute("birthDate"));
			LocalDate today = LocalDate.now();
			LocalDate nextBirthday = birthDate.withYear(today.getYear());
			if (!nextBirthday.isAfter(today)) {
    				nextBirthday = nextBirthday.plusYears(1);
			}
			long days = ChronoUnit.DAYS.between(today, nextBirthday);
			out.println("Hi, "+s.getAttribute("firstName")+" "+(String)s.getAttribute("lastName")+". There are "+days+" days to your birthday");
		}
		out.println("<p> visits = "+s.getAttribute("countVisit")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession s = request.getSession(false);
		if(s!=null){
			s.setAttribute("firstName",request.getParameter("firstName"));
			s.setAttribute("lastName",request.getParameter("lastName"));
			s.setAttribute("birthDate",request.getParameter("birthDate"));
			s.setAttribute("countVisit","0");
			response.sendRedirect("Show");
		}
	}
}