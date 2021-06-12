package com.employee.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "courseName")
    private String courseName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
}

