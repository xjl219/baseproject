package com.xujl.base.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.xujl.base.entity.Role;
import com.xujl.base.entity.User;
import com.xujl.base.service.UserService;
@Repository("customUserDetailsService")
public class CustomUserDetailsService  implements UserDetailsService {
   
	@Autowired
	UserService userServiceImpl ;
	
	/**
	 * the username identifying the user whose data is required
	 * */
	@Override
	public UserDetails loadUserByUsername(String loginUserName) throws UsernameNotFoundException {
		 UserDetails userdetails = null;
		User user = userServiceImpl.getByUserName(loginUserName);
//		Collection<? extends GrantedAuthority> authorities = this.obtionGrantedAuthorities(user);
		userdetails = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), true, true, true, true,  
                 getAuthorities(user));  

		
		return userdetails;
	}
   
	
	  /** 
     *  
     * @param access 
     * @return 
     */  
    public Collection<GrantedAuthority> getAuthorities(User user) {  
    	Set<Role> roles = user.getRoles();
    	 List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			authList.add(new GrantedAuthorityImpl(role.getRoleCode()));
		}
         
        DaoAuthenticationProvider n;
        return authList;  
    }  
}
