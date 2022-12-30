package com.hieulexuan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tutorial")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "first_name")
	private String title;

	@Column(name = "last_name")
	private String description;

	@Column(name = "email")
	private boolean published;

	public Tutorial() {
	}

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", published=" + published
				+ "]";
	}
}
