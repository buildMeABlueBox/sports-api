package com.homebase.sportsapi;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Player
 */
 @XmlRootElement
 public class Player {
    private String firstName, lastName, position, nameBrief, id;
    private int age;
    
    public Player(){

    }

	public Player(String firstName, String lastName, String position, int age, String nameBrief, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
        this.nameBrief = nameBrief;
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPosition(){
        return position;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
        /**
	 * @return the nameBrief
	 */
	public String getNameBrief() {
		return nameBrief;
	}

	/**
	 * @param nameBrief the nameBrief to set
	 */
	public void setNameBrief(String nameBrief) {
		this.nameBrief = nameBrief;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}