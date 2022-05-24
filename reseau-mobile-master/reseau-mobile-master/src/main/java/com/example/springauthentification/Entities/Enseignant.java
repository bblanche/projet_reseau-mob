package com.example.springauthentification.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.*;


@Table
@Entity
public class Enseignant extends User{

    @Column(name = "etablissement")
    protected String etablissemnt;
}
