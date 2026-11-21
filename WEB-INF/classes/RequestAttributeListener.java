import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
public class RequestAttributeListener implements ServletRequestAttributeListener{
	@Override
	public void attributeAdded(ServletRequestAttributeEvent event){
		System.out.println("Application attribute added : " + event.getName() + " = " + event.getValue());
	}
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event){
		System.out.println("Application attribute replaced : " + event.getName() + " = " + event.getValue());
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event){
		System.out.println("Application attribute removed : " + event.getName() + " = " + event.getValue());
	}
}