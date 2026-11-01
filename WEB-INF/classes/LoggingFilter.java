import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/*")
public class LoggingFilter implements Filter{
	private String name;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		System.out.println("hello");
		System.out.println("Prefix : "+filterConfig.getInitParameter("logPrefix"));
		name = filterConfig.getFilterName();
	}
	@Override
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)throws IOException,ServletException{
		HttpServletRequest req = (HttpServletRequest) request;
        	System.out.println("path : " + req.getServletPath());
		System.out.println("["+name+"] : before execution");
		Long start = System.nanoTime();
		chain.doFilter(request,response);
		Long end = System.nanoTime();
		double timeMs = (end-start) / 1_000_000.0;
		System.out.println("["+name+"] : after execution");
		System.out.println("time of execution = "+timeMs);
		System.out.println("Finish the execution of the servlet");
	}
	@Override
	public void destroy(){
		System.out.println("Filter destroyed");
	}
}