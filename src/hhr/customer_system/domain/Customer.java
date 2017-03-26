package hhr.customer_system.domain;

import java.sql.Date;


/*
 id varchar(100) primary key,
	name varchar(30),
	gender varchar(10),
	birthday date,
	email varchar(20),
	cellphone varchar(20),
	preference varchar(100),
	type varchar(20),
	description varchar(250)
 */
public class Customer {

	private String id;
	private String name;
	private String gender;
	private Date birthday;
	private String email;
	private String cellphone;
	private String preference;
	private String type;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
