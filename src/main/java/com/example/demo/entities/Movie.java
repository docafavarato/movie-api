package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_movie")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Integer yearReleased;
	private String imgPath;
	
	@ManyToMany
	@JoinTable(name="tb_movie_categories", joinColumns=@JoinColumn(name="movie_id"), inverseJoinColumns=@JoinColumn(name="categories_id"))
	private Set<Category> categories = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="tb_movie_actor", joinColumns=@JoinColumn(name="movie_id"), inverseJoinColumns=@JoinColumn(name="actor_id"))
	private Set<Actor> actors = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="tb_movie_streaming", joinColumns=@JoinColumn(name="movie_id"), inverseJoinColumns=@JoinColumn(name="streaming_id"))
	private Set<Streaming> streamings = new HashSet<>();
	
	public Movie() {
	}
	
	public Movie(String name, Integer yearReleased, String imgPath) {
		this.name = name;
		this.yearReleased = yearReleased;
		this.imgPath = imgPath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(Integer yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getImgPath() {
		return imgPath;
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}
	
	public Set<Streaming> getStreamings() {
		return streamings;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}
}
