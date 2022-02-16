package com.mouritech.rolebasedstaffapp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mouritech.rolebasedstaffapp.entity.Staff;

public class StaffDetailsImpl implements UserDetails {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2465326869008175934L;

	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;
	
	
	public StaffDetailsImpl(Staff staff) {
		super();
		this.userName = staff.getStaffName();
		this.password = staff.getStaffPw();
		this.isActive = staff.isActive();
		this.authorities = Arrays.stream(staff.getStaffRole().split(","))
									.map(SimpleGrantedAuthority::new)
									.collect(Collectors.toList());
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isActive;
	}

}
