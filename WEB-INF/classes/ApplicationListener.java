import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener{
	@Override 
	public void contextInitialized(ServletContextEvent event){
		System.out.println("Context initialized !");
		ServletContext context = event.getServletContext();
		context.setAttribute("appName","ING1 Web Application");
	}
	@Override 
	public void contextDestroyed(ServletContextEvent event){
		System.out.println("Context Destroyed");
	}
}