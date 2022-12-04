package com.example.sufa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Document {

    @Id @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    private String text;
    @Column(name = "pdf_link")
    private String link;
}
