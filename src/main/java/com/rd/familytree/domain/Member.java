package com.rd.familytree.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="first_name")
    private String firstName;
    
	@Column(name="last_name")
    private String lastName;
	
	@Column(name="nick_name")
	private String nickName;
	
	private String about;

	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	private String gender;
	
	private boolean married;
	
	@Column(name="wedding_anniversary_date")
	private Date weddingAnniversaryDate;
	
	@Column(name="profile_completed")
	private boolean profileCompleted;
	
	private boolean active;
	
	private boolean alive;
	
	@Column(name="death_date")
	private Date deathDate;
	
	@ManyToOne
    @JoinColumn(name = "father_id")
	private Member father;
	
	@ManyToOne
    @JoinColumn(name = "mother_id")
	private Member mother;
	
	@OneToOne
	@JoinColumn(name="life_partner_id")
	private Member lifePartner;

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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

	public Date getWeddingAnniversaryDate() {
		return weddingAnniversaryDate;
	}

	public void setWeddingAnniversaryDate(Date weddingAnniversaryDate) {
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

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public Member getFather() {
		return father;
	}

	public void setFather(Member father) {
		this.father = father;
	}

	public Member getMother() {
		return mother;
	}

	public void setMother(Member mother) {
		this.mother = mother;
	}

	public Member getLifePartner() {
		return lifePartner;
	}

	public void setLifePartner(Member lifePartner) {
		this.lifePartner = lifePartner;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
