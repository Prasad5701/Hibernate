package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class Student {

    @Id
    @Column(name = "sid")
	private int id ;
	private String name;
	@Column(unique = true)
	private long phone;
	@Column(unique = true)
	private String email;
	private String address;
	private double marks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", marks=" + marks + "]";
	}
}



