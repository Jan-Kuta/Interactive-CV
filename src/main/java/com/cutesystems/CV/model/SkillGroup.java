package com.cutesystems.CV.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SkillGroup implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 694133216L;
	
	private String groupName;
	private List<Skill> skills;
	
	public SkillGroup() {
		this.skills = new ArrayList<Skill>();
	}
	
	public SkillGroup(String groupName) {
		this.groupName = groupName;
		this.skills = new ArrayList<Skill>();
	}
	
	public SkillGroup(String groupName, List<Skill> skills) {
		this.groupName = groupName;
		this.skills = skills;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void addSkills(Skill skill) {
		this.skills.add(skill);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
