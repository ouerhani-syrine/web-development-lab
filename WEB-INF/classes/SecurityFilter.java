import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter{
	private String name;
	@Override
	public void init(FilterConfig config){
		name = config.getFilterName();
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession s = req.getSession(false);
		System.out.println("["+name+"] : before execution");
		if(s!=null && s.getAttribute("user")!=null){
			chain.doFilter(request,response);	
		}
		else{
			res.sendRedirect("/web-development-lab/login.html");
		}
		System.out.println("["+name+"] : after execution");
	}
}