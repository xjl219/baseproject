package com.xujl.base.security;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

/**
 * �Զ�������������û�����
 * 2015��12��7��
 */
@Service("securityInterceptor")
public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
    @Resource(name="customFilterInvocationSecurityMetadataSource")
	CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
	
    @Resource(name="accessDecisionManager")
	CustomAccessDecisionManager accessDecisionManager;
    
	@Autowired
	AuthenticationManager myAuthenticationManager ;

	@PostConstruct
	public void init(){
		
	 super.setAccessDecisionManager(accessDecisionManager);
     super.setAuthenticationManager(myAuthenticationManager);
}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		infoke(fi);
	}
   
	
	

	/**
	 * 
	 * @param fi
	 * @throws ServletException
	 * @throws IOException
	 */
	private void infoke(FilterInvocation fi) throws IOException,
			ServletException {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		InterceptorStatusToken token = super.beforeInvocation(fi);

		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	

	}

	@Override
	public Class<?> getSecureObjectClass() {
		// TODO Auto-generated method stub
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.customFilterInvocationSecurityMetadataSource;
	}

	
   
}
