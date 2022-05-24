package com.example.springauthentification.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="users")
@Data
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)


public class User {
    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUrlPhoto() {
		return urlPhoto;
	}


	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}


	public Boolean getConnected() {
		return connected;
	}


	public void setConnected(Boolean connected) {
		this.connected = connected;
	}


	public Boolean getVisibility() {
		return visibility;
	}


	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}


	public String getShort_bio() {
		return short_bio;
	}


	public void setShort_bio(String short_bio) {
		this.short_bio = short_bio;
	}


	public String getUrl_cv() {
		return url_cv;
	}


	public void setUrl_cv(String url_cv) {
		this.url_cv = url_cv;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUrl_video() {
		return url_video;
	}


	public void setUrl_video(String url_video) {
		this.url_video = url_video;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public Boolean getIsHelpNeeder() {
		return isHelpNeeder;
	}


	public void setIsHelpNeeder(Boolean isHelpNeeder) {
		this.isHelpNeeder = isHelpNeeder;
	}


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;

    @Column(name = "number",unique = true)
    protected String number;

    @Column(name = "username")
    protected String username;
    @Column(name = "localisation")
    protected String localisation;
    @Column(name = "surname")
    protected String surname;
    @Column(name = "password")
    protected String password;
    @Column(name = "url_photo")
    protected String urlPhoto;
    @Column(name = "connected")
    protected Boolean connected;
    @Column(name = "visibility")
    protected Boolean visibility;
    @Column(name = "short_bio")
    protected String short_bio;
    @Column(name = "CV")
    protected String url_cv;
    @Column(name = "email")
    protected String email;
    @Column(name = "url_video")
    protected String url_video;
    @Column(name = "Pseudo")
    protected String pseudo;
    @Column(name = "isHelpNeeder")
    protected Boolean isHelpNeeder;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", localisation='" + localisation + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}