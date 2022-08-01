package com.dbs.mappingdemo.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	
	//lets call the Address object
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_vehicle", joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_mobile_mapping", joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="mobile_id"))
	private Collection<Mobile> mobile = new ArrayList<Mobile>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}


	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}


	public Collection<Mobile> getMobile() {
		return mobile;
	}


	public void setMobile(Collection<Mobile> mobile) {
		this.mobile = mobile;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", address=" + address + ", vehicle=" + vehicle
				+ ", mobile=" + mobile + "]";
	}
	
	
	
	

}
