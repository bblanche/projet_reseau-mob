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
public class Keyword {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;
    @Column(name="word")
    private String word;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;
}
