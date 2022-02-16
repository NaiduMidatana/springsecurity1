package com.mouritech.rolebasedstaffapp.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mouritech.rolebasedstaffapp.entity.Staff;
import com.mouritech.rolebasedstaffapp.repository.StaffRepository;

@RestController
public class MainController {
	
	@Autowired
	private StaffRepository staffRepo;
	
	@GetMapping("/manager/updatestaffsalary")
	@PutMapping("/customers/{id}")
    public ResponseEntity<Staff> updateCustomer(@PathVariable(value = "id") Long staffId,
          @RequestBody Staff staffDetails) throws Exception {
		Staff staff = staffRepo.findById(staffId)
        .orElseThrow(() -> new Exception("Staff not found for this id :: " + staffId));

        staff.setStaffSalary(staffDetails.getStaffSalary());
        final Staff updatedStaff = staffRepo.save(staff);
        return ResponseEntity.ok(updatedStaff);
    }
	@GetMapping("/manager/getallstaff")
	public List<Staff> getAllStaffs(){
		return staffRepo.findAll();
		
	}
	
	@GetMapping("/salesperson")
	@PutMapping("updatestaff/{sid}")
	public Staff updateStaffById(@PathVariable("sid") Long staffid,@RequestBody Staff staff) throws Exception{
		Staff existingStaff = staffRepo.findById(staffid).orElseThrow(() -> new Exception("Staff not found with id " + staffid));
		existingStaff.setStaffMobile(staff.getStaffMobile());
		existingStaff.setStaffEmail(staff.getStaffEmail());
		
		return existingStaff;
		
	}
	
	
	@GetMapping("/ceo/getallstaff")
	public List<Staff> showAllStaffs(){
		return staffRepo.findAll();
		
	}
	@GetMapping("/ceo/insertstaff")
	public Staff insertStaffs(Staff staff){
		return staffRepo.save(staff);
		
	}

}
