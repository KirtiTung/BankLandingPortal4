package com.kirti.portal.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
	private int id;
	private String name;
}
