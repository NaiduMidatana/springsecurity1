package com.mouritech.rolebasedstaffapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffId;
	private String staffName;
	private String staffEmail;
	private String staffPw;
	private float staffCommission;
	private long staffMobile;
	private String staffRole;
	private double staffSalary;
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffPw() {
		return staffPw;
	}
	public void setStaffPw(String staffPw) {
		this.staffPw = staffPw;
	}
	public float getStaffCommission() {
		return staffCommission;
	}
	public void setStaffCommission(float staffCommission) {
		this.staffCommission = staffCommission;
	}
	public long getStaffMobile() {
		return staffMobile;
	}
	public void setStaffMobile(long staffMobile) {
		this.staffMobile = staffMobile;
	}
	public String getStaffRole() {
		return staffRole;
	}
	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}
	public double getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(double staffSalary) {
		this.staffSalary = staffSalary;
	}

	
	
	public Staff(int staffId, String staffName, String staffEmail, String staffPw, float staffCommission,
			long staffMobile, String staffRole, double staffSalary, boolean isActive) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffEmail = staffEmail;
		this.staffPw = staffPw;
		this.staffCommission = staffCommission;
		this.staffMobile = staffMobile;
		this.staffRole = staffRole;
		this.staffSalary = staffSalary;
		this.isActive = isActive;
	}
	public Staff(String staffName, String staffEmail, String staffPw, float staffCommission, long staffMobile,
			String staffRole, double staffSalary, boolean isActive) {
		super();
		this.staffName = staffName;
		this.staffEmail = staffEmail;
		this.staffPw = staffPw;
		this.staffCommission = staffCommission;
		this.staffMobile = staffMobile;
		this.staffRole = staffRole;
		this.staffSalary = staffSalary;
		this.isActive = isActive;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
