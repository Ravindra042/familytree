package com.rd.familytree.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="member")
public class MemberDTO {
	
	@XmlElement(name="id")
    private Long id;
	
	@XmlElement(name="firstName")
    private String firstName;
    
	@XmlElement(name="lastName")
    private String lastName;
	
	@XmlElement(name="nickName")
	private String nickName;
	
	@XmlElement(name="about")
	private String about;

	@XmlElement(name="dateOfBirth")
	private String dateOfBirth;
	
	private String gender;
	
	private boolean married;
	
	@XmlElement(name="weddingAnniversaryDate")
	private String weddingAnniversaryDate;
	
	@XmlElement(name="profileCompleted")
	private boolean profileCompleted;
	
	private boolean active;
	
	private boolean alive;
	
	@XmlElement(name="deathDate")
	private String deathDate;
	
    @XmlElement(name = "father")
	private MemberDTO father;
	
    @XmlElement(name = "mother")
	private MemberDTO mother;
	
	@XmlElement(name="lifePartner")
	private MemberDTO lifePartner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getWeddingAnniversaryDate() {
		return weddingAnniversaryDate;
	}

	public void setWeddingAnniversaryDate(String weddingAnniversaryDate) {
		this.weddingAnniversaryDate = weddingAnniversaryDate;
	}

	public boolean isProfileCompleted() {
		return profileCompleted;
	}

	public void setProfileCompleted(boolean profileCompleted) {
		this.profileCompleted = profileCompleted;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public MemberDTO getFather() {
		return father;
	}

	public void setFather(MemberDTO father) {
		this.father = father;
	}

	public MemberDTO getMother() {
		return mother;
	}

	public void setMother(MemberDTO mother) {
		this.mother = mother;
	}

	public MemberDTO getLifePartner() {
		return lifePartner;
	}

	public void setLifePartner(MemberDTO lifePartner) {
		this.lifePartner = lifePartner;
	}

}
