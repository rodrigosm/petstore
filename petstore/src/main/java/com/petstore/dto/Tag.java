package com.petstore.dto;

public class Tag {
	
	Integer id;
	String name;
	
	
	public Tag () {
		
	}
	
	public Tag (int id) {
		this.id = Integer.valueOf(id);
		this.name = null;
	}
	
	public Tag (String  name) {
		this.id = null;
		this.name = name;		
	}
	
	public Tag(int id, String name) {
		this.id = Integer.valueOf(id);
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
