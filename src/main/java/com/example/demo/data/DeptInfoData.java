package com.example.demo.data;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptInfoData implements Comparable<DeptInfoData>, Serializable {

	private static final long serialVersionUID = 1L;
	  	
		private Long id;
	    private String name;
		private String desc;

	
	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof DeptInfoData)) {
			return false;
		}
		final DeptInfoData data = (DeptInfoData) obj;
		return this.id.equals(data.id);
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public int compareTo(final DeptInfoData obj) {
		if (obj == null) {
			return -1;
		}

		return obj.id.compareTo(this.id);
	}

	public static DeptInfoData instance(final Long id, final String name, final String desc) {

		return new DeptInfoData(id, name, desc);
	}


}
