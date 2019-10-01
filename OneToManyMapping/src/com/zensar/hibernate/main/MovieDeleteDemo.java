package com.zensar.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class MovieDeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c=new Configuration().configure();
		SessionFactory f=c.buildSessionFactory();
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		
		Movie m=s.get(Movie.class,1);
		System.out.println(m.getTitle());
		System.out.println(m.getReleaseDate());
		
		List<Song> songs=m.getSongs();
		for(Song ss:songs)
		{
			System.out.println(ss);
		}
		if(m!=null)
			s.delete(m);
		else
			System.out.println("Sorry! Movie not found.");
			

		t.commit();
		s.close();
		System.exit(0);
		
	}

}


/*
Select :

Hibernate: select movie0_.movieId as movieId1_0_0_, movie0_.releaseDate as releaseD2_0_0_, movie0_.title as title3_0_0_ from Movie movie0_ where movie0_.movieId=?
Kabir Singh
2019-08-12
Hibernate: select songs0_.movie_id as movie_id3_1_0_, songs0_.songId as songId1_1_0_, songs0_.songId as songId1_1_1_, songs0_.movie_id as movie_id3_1_1_, songs0_.name as name2_1_1_ from Song songs0_ where songs0_.movie_id=?
Song [songId=2, name=Bekhayali]
Song [songId=3, name=Pehla Pehla]
Song [songId=4, name=song3]

Delete :


mysql> select * from Movie;
Empty set (0.00 sec)

mysql> select * from Song;
Empty set (0.00 sec)

 */
