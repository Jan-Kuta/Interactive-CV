package com.cutesystems.CV.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkExperience implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 536461L;
	
	private SimpleDateFormat dateFormatter;
	private String companyName;
	private String companyAddress;
	private String companyWeb;
	private String jobName;
	private String employmentType;
	private List<String> liabilities;
	private List<String> references;
	private Date start;
	private Date end;
	
	public WorkExperience(){
		this.dateFormatter = new SimpleDateFormat("yyyy/mm/dd");
		this.liabilities = new ArrayList<String>();
		this.references = new ArrayList<String>();
	}
	
	public WorkExperience(String formatter, String companyName, String companyAddress,
			String companyWeb, String jobName, String employmentType,
			String start, String end) throws ParseException {
		super();
		this.dateFormatter = new SimpleDateFormat(formatter);
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyWeb = companyWeb;
		this.jobName = jobName;
		this.employmentType = employmentType;
		this.liabilities = new ArrayList<String>();
		this.references = new ArrayList<String>();
		this.start = start == null? null : dateFormatter.parse(start);
		this.end = end == null? null :dateFormatter.parse(end);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyWeb() {
		return companyWeb;
	}

	public void setCompanyWeb(String companyWeb) {
		this.companyWeb = companyWeb;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public List<String> getLiabilities() {
		return liabilities;
	}

	public void addReference(String refernce) {
		this.liabilities.add(refernce);
	}

	public List<String> getReferences() {
		return references;
	}

	public void addLiabilitiy(String liability) {
		this.liabilities.add(liability);
	}
	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public String setStartStr() {
		return start == null? "":dateFormatter.format(start);
	}

	public void setStartrStr(String start) throws ParseException {
		this.start = dateFormatter.parse(start);
	}
	
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	public String getEndStr() {
		
		return end==null?"":dateFormatter.format(end);
	}

	public void setBirthDateStr(String end) throws ParseException {
		this.end = dateFormatter.parse(end);
	}
	
	
}
