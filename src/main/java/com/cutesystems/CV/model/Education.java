package com.cutesystems.CV.model;

import java.io.Serializable;

public class Education implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 36641L;
	private String 	schoolName;
	private String faculty;
	private String field;
	private String leavingPaper;
	private Integer start;
	private Integer end;
	
	public Education(){
		super();
	}
	
	public Education(String schoolName, String faculty, String field,
			String leavingPaper, Integer start, Integer end) {
		super();
		this.schoolName = schoolName;
		this.faculty = faculty;
		this.field = field;
		this.leavingPaper = leavingPaper;
		this.start = start;
		this.end = end;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getLeavingPaper() {
		return leavingPaper;
	}
	public void setLeavingPaper(String leavingPaper) {
		this.leavingPaper = leavingPaper;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
