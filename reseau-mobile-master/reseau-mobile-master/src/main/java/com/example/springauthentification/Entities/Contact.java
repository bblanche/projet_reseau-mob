package com.example.springauthentification.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
  import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;
    @Column(name="number", unique = true)
    protected String number;
    @Column(name = "name")
    protected String name;
    @Column(name = "telephone")
    protected String telephone;
    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;


}
