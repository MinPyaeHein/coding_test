package com.example.demo.form;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class StaffRegForm {
private String staffId;
private String groupId;
private String name;
private String email;
private String password;
private List<String> pages;
private List<String> departments;
public String getStaffId() {
	return staffId;
}
public void setStaffId(String staffId) {
	this.staffId = staffId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<String> getPages() {
	return pages;
}
public void setPages(List<String> pages) {
	this.pages = pages;
}
public List<String> getDepartments() {
	return departments;
}
public String getGroupId() {
	return groupId;
}
public void setGroupId(String groupId) {
	this.groupId = groupId;
}
public void setDepartments(List<String> departments) {
	this.departments = departments;
}

}
