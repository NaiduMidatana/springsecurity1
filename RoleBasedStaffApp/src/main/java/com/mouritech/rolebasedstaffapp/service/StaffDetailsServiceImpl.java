package com.mouritech.rolebasedstaffapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mouritech.rolebasedstaffapp.entity.Staff;
import com.mouritech.rolebasedstaffapp.repository.StaffRepository;

@Service
public class StaffDetailsServiceImpl  implements UserDetailsService {

	@Autowired
	private StaffRepository staffRepo;
	
	@Override
	public UserDetails loadUserByUsername(String staffname) throws UsernameNotFoundException {
		Optional<Staff> staff = staffRepo.findByStaffName(staffname);
		staff.orElseThrow(() -> new UsernameNotFoundException(staffname + "not found."));
		return staff.map(StaffDetailsImpl::new).get();
	}

}
