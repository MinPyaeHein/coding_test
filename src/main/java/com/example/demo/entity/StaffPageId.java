package com.example.demo.entity;
// Generated May 28, 2020 10:14:49 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class StaffPageId implements java.io.Serializable {

	private Long staffId;
	private Long pageId;

	public StaffPageId() {
	}

	
	public StaffPageId(Long staffId, Long pageId) {
		
		this.staffId = staffId;
		this.pageId = pageId;
	}
	@Column(name = "staff_id", nullable = false)
	public Long getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	@Column(name = "page_id", nullable = false)
	public Long getPageId() {
		return this.pageId;
	}

	public void setPageId(Long depId) {
		this.pageId = depId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StaffPageId))
			return false;
		StaffPageId castOther = (StaffPageId) other;

		return (this.getStaffId() == castOther.getStaffId()) && (this.getPageId() == castOther.getPageId());
	}

	

}
