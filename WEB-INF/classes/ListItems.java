import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList<String> items =(ArrayList<String>) session.getAttribute("items");
        if (items == null) {
            items = new ArrayList<String>();
        }
        String newItem = request.getParameter("newItem");
        items.add(newItem);
        session.setAttribute("items", items);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>My Items</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>My Items</h1>");
        for (String item : items) {
            out.println("<p>" + item + "</p>");
        }
        out.println("<h2>Number of times each item was input</h2>");
        ArrayList<String> displayedItems = new ArrayList<String>();
        for (String item : items) {
            if (!displayedItems.contains(item)) {
                int count = 0;
                for (String currentItem : items) {
                    if (currentItem.equals(item)) {
                        count++;
                    }
                }
                out.println("<p>" + item + " : " + count + "</p>");
                displayedItems.add(item);
            }
        }
        out.println("<br>");
        out.println("<a href=\"items.html\">Add another item</a>");
        out.println("</body>");
        out.println("</html>");
    }
}