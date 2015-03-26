package com.cutesystems.CV.model;

import java.io.Serializable;


public class Skill implements Serializable{
	
	private static final long serialVersionUID = 1654684L;
	
	private String name;
	private String description;
	private float level;
	private boolean isRelevant;
	
	
	public Skill(String name, String description, float level, boolean isRelevant) {
		this.name = name;
		this.description = description;
		this.level = level;
		this.isRelevant = isRelevant;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getLevel() {
		return level;
	}
	public void setLevel(float level) {
		this.level = level;
	}
	public boolean isRelevant() {
		return isRelevant;
	}
	public void setRelevant(boolean isRelevant) {
		this.isRelevant = isRelevant;
	}
	
	
}
