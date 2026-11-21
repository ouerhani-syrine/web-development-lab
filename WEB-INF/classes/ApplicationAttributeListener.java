import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
public class ApplicationAttributeListener implements ServletContextAttributeListener{
	@Override
	public void attributeAdded(ServletContextAttributeEvent event){
		System.out.println("Application attribute added : " + event.getName() + " = " + event.getValue());
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event){
		System.out.println("Application attribute replaced : " + event.getName() + " = " + event.getValue());
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event){
		System.out.println("Application attribute removed : " + event.getName() + " = " + event.getValue());
	}
}