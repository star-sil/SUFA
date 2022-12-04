package com.example.sufa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Stock {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String explanation;
}
