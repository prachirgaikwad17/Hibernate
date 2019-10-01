package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Prachi Gaikwad
 * @creation_date 27th Sep 2019 4:42pm
 * @modification_date 27th Sep 2019 4:42pm
 * @version 1.0
 * @copyright Zensar Technologies.All rights reserved.
 * @description It is a Persistent class. 
 * 
 */


@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int songId;
	private String name;
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	
	
	public Song(String name) {
		super();
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Song(int songId, String name) {
		super();
		this.songId = songId;
		this.name = name;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", name=" + name + "]";
	}
	
	
	
}
