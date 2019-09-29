package com.example.oauth2.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Hua-cloud
 */
@Entity
@Data
public class Permission {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "descritpion")
    private String descritpion;
    @Column(name = "url")
    private String url;
    @Column(name = "pid")
    private int pid;
}
