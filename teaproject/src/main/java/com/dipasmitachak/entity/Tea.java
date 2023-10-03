package com.dipasmitachak.entity;

import java.util.UUID;

//adding uniqueness in id that must act as same as primary keys in database
public class Tea {
	private final String id;
	private String name;
	
	//constructor chaining
	public Tea(String name) {
		this(UUID.randomUUID().toString(),name);
	}

	public Tea(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
