package com.example.demo.form;
public class StaffRegForm {
	
private String staffId;
private String groupId;
private String name;
private String email;
private String password;
private String[] pages;
private String[] departments;

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

public String getGroupId() {
	return groupId;
}
public void setGroupId(String groupId) {
	this.groupId = groupId;
}
public String[] getPages() {
	return pages;
}
public void setPages(String[] pages) {
	this.pages = pages;
}
public String[] getDepartments() {
	return departments;
}
public void setDepartments(String[] departments) {
	this.departments = departments;
}

}
