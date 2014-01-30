package com.howtodoinjava.model;

public class Card {
	
	private int id = -1;
	private String name ="";
	private String description ="";
	
	public Card(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getId(){
		return id;
	}
	
	public String toString(){
		return name + " - " + description;
	}
}
