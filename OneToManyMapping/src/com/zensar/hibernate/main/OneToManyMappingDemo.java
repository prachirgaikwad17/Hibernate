package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

/**
 * @author Prachi Gaikwad
 * @creation_date 27th Sep 2019 5:11pm
 * @modification_date 27th Sep 2019 5:11pm
 * @version 1.0
 * @copyright Zensar Technologies.All rights reserved.
 * @description 
 * 
 */

public class OneToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c=new Configuration().configure();
		SessionFactory f=c.buildSessionFactory();
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		
		
		Movie m1=new Movie();
		m1.setTitle("Kabir Singh");
		m1.setReleaseDate(LocalDate.of(2019, 8, 12));
		
		Song s1=new Song("Bekhayali");
		Song s2=new Song("Pehla Pehla");
		Song s3=new Song("song3");
		
		s1.setMovie(m1);
		s2.setMovie(m1);
		s3.setMovie(m1);
		
		List<Song> songs=new ArrayList<Song>();
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		
		m1.setSongs(songs);
		s.save(m1);
		
		s.save(s1);
		s.save(s2);
		s.save(s3);
		
		t.commit();
		s.close();
		System.exit(0);
		
	}

}

/*
mysql> select * from Movie;
+---------+-------------+-------------+
| movieId | releaseDate | title       |
+---------+-------------+-------------+
|       1 | 2019-08-12  | Kabir Singh |
+---------+-------------+-------------+
1 row in set (0.00 sec)

mysql> select * from Song;
+--------+-------------+----------+
| songId | name        | movie_id |
+--------+-------------+----------+
|      2 | Bekhayali   |        1 |
|      3 | Pehla Pehla |        1 |
|      4 | song3       |        1 |
+--------+-------------+----------+
3 rows in set (0.00 sec)
 
*/