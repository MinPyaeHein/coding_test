package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@Table(name = "staff_page")
public class StaffPage implements Serializable {
	
	private StaffPageId id;
	
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "pageId", column = @Column(name = "page_id", nullable = false)),
			@AttributeOverride(name = "staffId", column = @Column(name = "staff_id", nullable = false)) })
	public StaffPageId getId() {
		return this.id;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id", nullable = false)
	private Staff staff;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "page_id", nullable = false)
	private Page page;

	
	}

