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
public class Illustration {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;

    @Column(name = "refLink")
    protected String refLink;
    @ManyToOne
    @JoinColumn(name = "businessuser_id", updatable = false)
    private BusinessUser businessUser;
}
