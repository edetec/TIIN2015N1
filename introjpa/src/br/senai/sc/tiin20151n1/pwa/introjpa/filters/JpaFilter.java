package br.senai.sc.tiin20151n1.pwa.introjpa.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.senai.sc.tiin20151n1.pwa.introjpa.commons.JpaUtil;

@WebFilter(urlPatterns="*.xhtml")
public class JpaFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		JpaUtil.init();
	}

	@Override
	public void destroy() {
		JpaUtil.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		filterChain.doFilter(request, response);
	}
}
