package com.github.xuexi.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Audio {
	@Id
	private String title;
	private LocalDate date;
	
	Audio(){}
	
	public Audio(String title) {
		super();
		this.title = title;
		this.date = LocalDate.now();
	}
	
	public LocalDate date() {
		return date;
	}
}
