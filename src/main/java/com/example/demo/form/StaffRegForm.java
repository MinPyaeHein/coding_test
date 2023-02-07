package com.example.demo.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.entity.Department;
import com.example.demo.entity.Group;
import com.example.demo.entity.Page;

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
private Group group;
private String accountStatus;
private Date createAt;
private Date updateAt;
private List<Page> listPages;
private List<Department> listDepartments;
private List<String> pages = new ArrayList<String>();;
private List<String> departments = new ArrayList<String>();

public String getStaffId() {
	return staffId;
}
public void setStaffId(String staffId) {
	this.staffId = staffId;
}
public String getGroupId() {
	return groupId;
}
public void setGroupId(String groupId) {
	this.groupId = groupId;
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
public Group getGroup() {
	return group;
}
public void setGroup(Group group) {
	this.group = group;
}
public String getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}
public Date getCreateAt() {
	return createAt;
}
public void setCreateAt(Date createAt) {
	this.createAt = createAt;
}
public Date getUpdateAt() {
	return updateAt;
}
public void setUpdateAt(Date updateAt) {
	this.updateAt = updateAt;
}
public List<Page> getListPages() {
	return listPages;
}
public void setListPages(List<Page> listPages) {
	
	this.listPages = listPages;
	
	for(Page page : this.listPages)
	{
		this.pages.add(page.getPageId()+"");
	}

}

public List<String> getPages() {
	return pages;
}
public List<String> getDepartments() {
	return departments;
}
public void setPages(List<String> pages) {
	this.pages = pages;
}
public void setDepartments(List<String> departments) {
	this.departments = departments;
}


public List<Department> getListDepartments() {
	return listDepartments;
}

public void setListDepartments(List<Department> listDepartments) {
	this.listDepartments = listDepartments;
	for(Department d : this.listDepartments)
	{
		this.departments.add(d.getDepId()+"");
	}
}
@Override
public String toString() {
	return "StaffRegForm [staffId=" + staffId + ", groupId=" + groupId + ", name=" + name + ", email=" + email
			+ ", password=" + password + ", group=" + group + ", accountStatus=" + accountStatus + ", createAt="
			+ createAt + ", updateAt=" + updateAt + ", listPages=" + listPages + ", listDepartments=" + listDepartments
			+ ", pages=" + pages + ", departments=" + departments + "]";
}

}
