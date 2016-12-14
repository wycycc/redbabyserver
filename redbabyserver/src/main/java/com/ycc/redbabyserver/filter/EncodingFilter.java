package com.ycc.redbabyserver.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	//解决全站乱码问题
	String encode = null;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MyRequest myRequest = new MyRequest(req);
		chain.doFilter(myRequest, res);
	
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encode = filterConfig.getInitParameter("encode");
	}
	
	@Override
	public void destroy() {
		
	}
	class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request = null;
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		@Override
		public String getParameter(String name) {
			try {
			String value = this.request.getParameter(name);
			if(value==null){
				return null;
			}
			if(!this.request.getMethod().equalsIgnoreCase("get")){
				return value;
			}
			value = new String(value.getBytes("ISO8859-1"),"UTF-8");
			return value;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		@Override
		public Map<String, String[]> getParameterMap() {
			return super.getParameterMap();
		}
	}

}
