package com.frank.boot.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CrossFilter implements Filter{

	@Value("${system.cross.maxAge:3600}")
	private String maxAge;
	@Value("${system.cross.allowedMethods:POST, GET, PUT, OPTIONS, DELETE, PATCH}")
	private String allowedMethods;
	@Value("${system.cross.allowedHeaders:Origin, X-Requested-With, Content-Type, Accept,type}")
	private String allowedHeaders;
	@Value("${system.cross.allowedOrigins:http://localhost:9527,http://127.0.0.1:9527}")
	private String allowedOrigins;
	@Override
	public void init(FilterConfig filterConfig) {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String [] whiteList = allowedOrigins.split(",");
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String myOrigin = req.getHeader("origin");
    	boolean isValid = false;
    	for( String ip : whiteList ) {
    		if( myOrigin != null && myOrigin.equals(ip) ){
    			isValid = true;
    			break;
    		}
    	}
    	res.setHeader("Access-Control-Allow-Origin", isValid ? myOrigin : "null");
		//允许的访问方法
		res.setHeader("Access-Control-Allow-Methods", allowedMethods);
		//Access-Control-Max-Age 用于 CORS 相关配置的缓存
		res.setHeader("Access-Control-Max-Age", maxAge);
		res.setHeader("Access-Control-Allow-Headers", allowedHeaders);
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Allow",allowedMethods);

		if(req.getMethod().equals("OPTIONS")){
			res.setStatus(200);
		}else{
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {

	}

}
