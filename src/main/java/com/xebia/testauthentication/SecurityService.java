package com.xebia.testauthentication;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityService implements SecurityServiceInterface {

	public String[] getRoles() {
		Collection<GrantedAuthority> col = SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		String[] roles = new String[col.size()];
		int i = 0;
		for (Iterator<GrantedAuthority> it = col.iterator(); it.hasNext();) {

			GrantedAuthority grantedAuthority = it.next();
			roles[i] = grantedAuthority.getAuthority();
			i++;
		}
		return roles;
	}
}
