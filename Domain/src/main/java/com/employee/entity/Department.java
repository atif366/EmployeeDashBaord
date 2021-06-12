package com.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "departmentName")
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name="dp_fk", referencedColumnName = "id")
    private List<Course> course;
}
