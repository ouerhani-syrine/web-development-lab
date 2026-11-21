import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class ActiveSessionListener implements HttpSessionListener{
	private static final AtomicInteger counter = new AtomicInteger(0);
	@Override
	public void sessionCreated(HttpSessionEvent event){
		ServletContext context = event.getSession().getServletContext();
		synchronized (context){
			int count = counter.incrementAndGet();
			context.setAttribute("activeSessions",count);
		}
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent event){
		ServletContext context = event.getSession().getServletContext();
		synchronized (context) {
			int count = counter.decrementAndGet();
			context.setAttribute("activeSessions",count);
		}
	}
}