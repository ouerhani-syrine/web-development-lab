import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class AttributeTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        getServletContext().setAttribute("appMessage", "Hello");
        getServletContext().setAttribute("appMessage", "Welcome");
        getServletContext().removeAttribute("appMessage");
        request.setAttribute("requestMessage", "First value");
        request.setAttribute("requestMessage", "Second value");
        request.removeAttribute("requestMessage");
        response.setContentType("text/html");
        response.getWriter().println("<h1>Listeners tested successfully!</h1>");
    }
}