package com.example.oauth2.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Hua-cloud
 */
@Entity
@Data
@Table(name="sys_role")
public class SysRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private  String name;
}
