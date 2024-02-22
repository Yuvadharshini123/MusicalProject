package com.musical.project.Entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="package_tb")
public class Package {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="pack_name")
	private String pname;
	
	@Column(name="pack_price")
	private int pprice;

}
