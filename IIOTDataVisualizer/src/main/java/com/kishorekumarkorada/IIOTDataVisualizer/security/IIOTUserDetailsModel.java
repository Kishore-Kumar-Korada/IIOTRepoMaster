package com.kishorekumarkorada.IIOTDataVisualizer.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTRoleModel;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTUserModel;

public class IIOTUserDetailsModel implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Collection<? extends GrantedAuthority> authorities;
	private String userName;
	private String password;
	
	
	
	  public IIOTUserDetailsModel(IIOTUserModel user) { 
		  this.userName = user.getUserName(); this.password = user.getUserPassword();
		  if(user.getRoles() != null && user.getRoles().size() > 0) {
			  this.authorities = translate(user.getRoles()); 
		  } 
	  }
	 
	
	
	  public Collection<? extends GrantedAuthority> translate(Collection<IIOTRoleModel> userRoles) { 
		  Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>(); // Build user's authorities 
		  for (IIOTRoleModel userRole : userRoles) { 
			  setAuths.add(new SimpleGrantedAuthority(userRole.getUserRole())); 
		  } 
		  List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths); 
		  return Result; 
	  }
	  
	  @Override 
	  public Collection<? extends GrantedAuthority> getAuthorities() {
		  return this.authorities; 
	  }
	  
	  @Override public String getPassword() { return this.password; }
	  
	  @Override public String getUsername() { return this.userName; }
	  
	  @Override public boolean isAccountNonExpired() { return true; }
	  
	  @Override public boolean isAccountNonLocked() { return true; }
	  
	  @Override public boolean isCredentialsNonExpired() { return true; }
	  
	  @Override public boolean isEnabled() { return true; }
	 

}
