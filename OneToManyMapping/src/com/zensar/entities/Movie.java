package com.zensar.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Prachi Gaikwad
 * @creation_date 27th Sep 2019 4:42pm
 * @modification_date 27th Sep 2019 4:51pm
 * @version 1.0
 * @copyright Zensar Technologies.All rights reserved.
 * @description It is a Persistent class. 
 * 
 */

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String title;
	private LocalDate releaseDate;
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
	private List<Song> songs;
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
	
}
