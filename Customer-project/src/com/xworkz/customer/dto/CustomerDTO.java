package com.xworkz.customer.dto;

import java.io.Serializable;


import com.xworkz.customer.constant.EducationType ;

public class CustomerDTO implements Serializable {
private int id;
private String name;
private String from;;
private String to;
private String address;
private String married;
private int passportNo;

public CustomerDTO(String name, String from, String to, String address, String married, int passportNo,EducationType educationType) {
	super();
	this.name = name;
	this.from = from;
	this.to = to;
	this.address = address;
	this.married = married;
	this.passportNo = passportNo;
	this.educationType = educationType;
}
private EducationType  educationType;
	
	
public CustomerDTO() {
			super();
	 }
		
public CustomerDTO(int id, String name, String from, String to, String address, String married, int passportNo,EducationType educationType) {
			super();
			this.id = id;
			this.name = name;
			this.from = from;
			this.to = to;
			this.address = address;
			this.married = married;
			this.passportNo = passportNo;
			this.educationType = educationType;
		}

@Override
public String toString() {
	return "CustomerDTO [id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + ", address=" + address
			+ ", married=" + married + ", passportNo=" + passportNo + ", educationType=" + educationType + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((educationType == null) ? 0 : educationType.hashCode());
	result = prime * result + ((from == null) ? 0 : from.hashCode());
	result = prime * result + id;
	result = prime * result + ((married == null) ? 0 : married.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + passportNo;
	result = prime * result + ((to == null) ? 0 : to.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CustomerDTO other = (CustomerDTO) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (educationType == null) {
		if (other.educationType != null)
			return false;
	} else if (!educationType.equals(other.educationType))
		return false;
	if (from == null) {
		if (other.from != null)
			return false;
	} else if (!from.equals(other.from))
		return false;
	if (id != other.id)
		return false;
	if (married == null) {
		if (other.married != null)
			return false;
	} else if (!married.equals(other.married))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (passportNo != other.passportNo)
		return false;
	if (to == null) {
		if (other.to != null)
			return false;
	} else if (!to.equals(other.to))
		return false;
	return true;
}

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
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getMarried() {
			return married;
		}
		public void setMarried(String married) {
			this.married = married;
		}
		public int getPassportNo() {
			return passportNo;
		}
		public void setPassportNo(int passportNo) {
			this.passportNo = passportNo;
		}
		public EducationType getEducation() {
			return educationType;
		}
		public void setEducation(String education) {
			this.educationType = educationType;
		}

		
		

}



