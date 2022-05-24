package com.example.springauthentification.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorColumn;

import javax.persistence.*;

@Entity
@Table
@DiscriminatorColumn(name="G")

public class Guest extends User{
    @Column(name = "raisonvisite")
    protected  String raison;
}
