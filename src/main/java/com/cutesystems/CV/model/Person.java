package com.cutesystems.CV.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person implements Serializable{
	private static final long serialVersionUID = 5648681L;
	
	private SimpleDateFormat dateFormatter;
	private Date birthDate;
	private String firstname;
	private String lastname;
	private String address;
	private String temporarryAddress;
	private String phone;
	private String email;
	private String driverLicence;
	private String linkedinAccount;
	private String fotoUrl;
	
	private List<SkillGroup> skillGroups;
	private List<Education> education;
	private List<WorkExperience> workExpirience;
	private Map<String,String> otherStuff;
	
	
	public Person(){
		this.dateFormatter = new SimpleDateFormat("yyyy/mm/dd");
		this.skillGroups = new ArrayList<SkillGroup>();
		this.education = new ArrayList<Education>();
		this.workExpirience = new ArrayList<WorkExperience>();
		this.otherStuff = new HashMap<String, String>();
	}
	
	public Person(String dateFormat, String birthDate, String firstname, String lastname, String address,
			String temporarryAddress, String phone, String email, String driverLicence,  String linkedinAccount, String fotoUrl) throws ParseException {
		
		this.dateFormatter = new SimpleDateFormat(dateFormat);
		this.birthDate = this.dateFormatter.parse(birthDate);
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.temporarryAddress = temporarryAddress;
		this.phone = phone;
		this.email = email;
		this.driverLicence = driverLicence;
		this.linkedinAccount = linkedinAccount;
		this.fotoUrl = fotoUrl;
		this.skillGroups = new ArrayList<SkillGroup>();
		this.education = new ArrayList<Education>();
		this.workExpirience = new ArrayList<WorkExperience>();
		this.otherStuff = new HashMap<String, String>();
	}
	
	public Person(String dateFormat, String birthDate, String firstname, String lastname, String address,
			String temporarryAddress, String phone, String email, String driverLicence,  String linkedinAccount, String fotoUrl,
			List<SkillGroup> skillGroups, List<Education> education,
			List<WorkExperience> workExpirience, Map<String, String> otherStuff) throws ParseException {
		
		this.dateFormatter = new SimpleDateFormat(dateFormat);
		this.birthDate = this.dateFormatter.parse(birthDate);
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.temporarryAddress = temporarryAddress;
		this.phone = phone;
		this.email = email;
		this.driverLicence = driverLicence;
		this.linkedinAccount = linkedinAccount;
		this.fotoUrl = fotoUrl;
		this.skillGroups = skillGroups;
		this.education = education;
		this.workExpirience = workExpirience;
		this.otherStuff = otherStuff;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBirthDateStr() {
		return dateFormatter.format(birthDate);
	}

	public void setBirthDateStr(String birthDate) throws ParseException {
		this.birthDate = dateFormatter.parse(birthDate);
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFoto(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTemporarryAddress() {
		return temporarryAddress;
	}

	public void setTemporarryAddress(String temporarryAddress) {
		this.temporarryAddress = temporarryAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}

	public String getLinkedinAccount() {
		return linkedinAccount;
	}

	public void setLinkedinAccount(String linkedinAccount) {
		this.linkedinAccount = linkedinAccount;
	}

	public List<SkillGroup> getSkillGroups() {
		return skillGroups;
	}

	public void addSkillGroups(SkillGroup skillGroup) {
		this.skillGroups.add(skillGroup);
	}

	public List<Education> getEducation() {
		return education;
	}

	public void addEducation(Education education) {
		this.education.add(education);
	}

	public List<WorkExperience> getWorkExpirience() {
		return workExpirience;
	}

	public void addWorkExpirience(WorkExperience workExpirience) {
		this.workExpirience.add(workExpirience);
	}

	public Map<String, String> getOtherStuff() {
		return otherStuff;
	}

	public void addOtherStuff(String key, String value) {
		this.otherStuff.put(key, value);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
