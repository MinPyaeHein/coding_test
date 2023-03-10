package com.example.demo.entity;
// Generated May 28, 2020 10:14:49 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StaffDepartmentId implements java.io.Serializable {

	private Long staffId;
	private Long depId;

	public StaffDepartmentId() {
	}

	
	public StaffDepartmentId(Long staffId, Long depId) {
		
		this.staffId = staffId;
		this.depId = depId;
	}
	@Column(name = "staff_id", nullable = false)
	public Long getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	@Column(name = "dep_id", nullable = false)
	public Long getDepId() {
		return this.depId;
	}

	public void setDepId(Long depId) {
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

		result = 37 * result + Integer.parseInt(this.getStaffId()+"");
		result = 37 * result + Integer.parseInt(this.getDepId()+"");
		return result;
	}
	

}
