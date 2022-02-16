package com.mouritech.rolebasedstaffapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.rolebasedstaffapp.entity.Staff;


@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	Optional<Staff> findByStaffName(String staffName);
}
