import javax.servlet.ServletContext;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletRequestEvent;

@WebListener
public class RequestListener implements ServletRequestListener {
	@Override 
	public void requestInitialized(ServletRequestEvent event){
		System.out.println("Request initialized !");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent event){
		System.out.println("Request destroyed");
	}
}