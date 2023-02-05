package com.example.demo.entity;
// Generated May 28, 2020 10:14:49 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BookAuthorId generated by hbm2java
 */
@Embeddable
public class StaffDepartmentId implements java.io.Serializable {

	private int staffId;
	

	private int depId;

	public StaffDepartmentId() {
	}

	
	public StaffDepartmentId(int staffId, int depId) {
		
		this.staffId = staffId;
		this.depId = depId;
	}
	@Column(name = "staff_id", nullable = false)
	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	@Column(name = "dep_id", nullable = false)
	public int getDepId() {
		return this.depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StaffDepartmentId))
			return false;
		StaffDepartmentId castOther = (StaffDepartmentId) other;

		return (this.getStaffId() == castOther.getStaffId()) && (this.getDepId() == castOther.getDepId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getStaffId();
		result = 37 * result + this.getDepId();
		return result;
	}

}