package com.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="SECURITY_USER")
public class ServiceUser {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="Username")
	private String userName;
	
	@Column(name="Role")
	private String role;
	
	@Column(name="Password")
	private String password;
	
	
}
