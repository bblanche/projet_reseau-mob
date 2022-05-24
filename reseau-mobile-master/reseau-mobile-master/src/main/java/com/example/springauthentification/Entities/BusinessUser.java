package com.example.springauthentification.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BusinessUser extends User{
    @Column(name = "localisation")
    protected String localisation;
    @Column(name = "adresse")
    protected String adresse;
    @Column(name = "name_business")
    protected String name_business;
    @Column(name = "horaire")
    protected String horaire;
}
