package com.example.oauth2.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Hua-cloud
 */
@Data
public class JwtUserDetails implements UserDetails {
 
	private String userName;
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {

		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
 
	@Override
	public boolean isCredentialsNonExpired() {
 
		return true;
	}
 
	@Override
	public boolean isEnabled() {
		return true;
	}
 
}