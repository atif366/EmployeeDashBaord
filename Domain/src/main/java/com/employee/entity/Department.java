package com.employee.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "departmentName")
    private String departmentName;

    @OneToOne(mappedBy = "department")
    private Employee employee;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> course;
}
