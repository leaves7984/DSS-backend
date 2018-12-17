package com.example.easynotes.module.patient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@lombok.Data
@Entity
@Table(name = "Patient")
@EntityListeners(AuditingEntityListener.class)
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String username;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String description;
    private Boolean deleted;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedAt;

    public Patient() {
    }

}
