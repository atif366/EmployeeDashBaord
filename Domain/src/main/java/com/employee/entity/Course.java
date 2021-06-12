package com.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "courseName")
    private String courseName;
}

