package cn.dw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class EnCodingFilter implements Filter {

	
	public EnCodingFilter() {
		System.out.println("EnCodingFilter().........");
	}
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter.......");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//过滤链：如果有下一个过滤器则跳到下一个过滤器，否则跳转到目标页面
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
