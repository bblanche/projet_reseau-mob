package com.example.springauthentification.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Etudiant extends User{
    @Column(name = "niveau")
    private String niveau;

}
