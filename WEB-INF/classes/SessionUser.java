import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionUser implements HttpSessionBindingListener {
    private String userName;
    public SessionUser(String userName) {
        this.userName = userName;
    }
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(userName + " : value bound");
    }
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(userName + " : value unbound");
    }
}