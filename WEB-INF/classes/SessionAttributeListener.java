import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent event){
		System.out.println("Attribute added ! ");
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event){
		System.out.println("Attribute replaced !");
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event){
		System.out.println("Attribute removed !");
	}
}