package com.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;

/**
 * 过滤器
 */
public class CharacterEncodingFilter implements Filter {
	private final Logger log = Logger.getLogger(CharacterEncodingFilter.class);
	private String charset = null;

	public void init(FilterConfig arg0) throws ServletException {
		String initParam = arg0.getInitParameter("charset");
		if (initParam != null && (initParam = initParam.trim()).length() != 0) {
			log.info("将CharacterEncodingFilter的charset设置为" + initParam);
			charset = initParam;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chan) throws IOException, ServletException {
		log.info("进入CharacterEncodingFilter的doFilter()方法");

		if (charset != null) {
			request.setCharacterEncoding(charset); // 设置请求内容的字符集
			response.setCharacterEncoding(charset); // 设置响应内容的字符集
		}
		chan.doFilter(request, response); // 继续请求处理流程
		log.info("退出CharacterEncodingFilter的doFilter()方法");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
