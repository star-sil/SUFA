package com.example.sufa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Company {

    @Id @GeneratedValue
    private Integer id;
    private String name;
}
