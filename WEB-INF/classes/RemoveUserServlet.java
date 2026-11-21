import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveUserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
        }
        response.setContentType("text/html");
        response.getWriter().println("<h1>SessionUser removed from session!</h1>");
    }
}