package br.senai.sc.ctai.ti20151n1.pwa.agtur.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.mb.SessaoMb;

@WebFilter(urlPatterns="/admin/*")
public class SessaoFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		SessaoMb sessaoMb = (SessaoMb) httpServletRequest.getSession().getAttribute("sessaoMb"); 
		
		if(sessaoMb == null || !sessaoMb.ehAdmin()){
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect(
					httpServletRequest.getContextPath().concat("/login.xhtml?msg=Acesso restrito."));
			return;
		}
		
		filterChain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}



