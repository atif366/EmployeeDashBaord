package com.employee.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "employeeName")
    private String employeeName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
