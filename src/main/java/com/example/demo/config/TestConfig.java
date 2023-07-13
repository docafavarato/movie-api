package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Actor;
import com.example.demo.entities.Category;
import com.example.demo.entities.Movie;
import com.example.demo.entities.Streaming;
import com.example.demo.repositories.ActorRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.StreamingRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StreamingRepository streamingRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category("ROMANCE");
		Category c2 = new Category("ANIMATED");
		Category c3 = new Category("FAMILY");
		Category c4 = new Category("SCIENCE FICTION");
		Category c5 = new Category("ACTION");
		
		Streaming s1 = new Streaming("Netflix");
		Streaming s2 = new Streaming("Prime");
		Streaming s3 = new Streaming("Disney+");
		
		Movie m1 = new Movie("Titanic", 1978, "https://upload.wikimedia.org/wikipedia/en/1/18/Titanic_%281997_film%29_poster.png");
		Movie m2 = new Movie("Toy Story", 2009, "https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_.jpg");
		Movie m3 = new Movie("Interstellar", 2009, "https://m.media-amazon.com/images/I/A1JVqNMI7UL._AC_UF894,1000_QL80_.jpg");
		Movie m4 = new Movie("Toy Story 2", 2011, "https://br.web.img2.acsta.net/medias/nmedia/18/91/05/37/20127443.jpg");
		Movie m5 = new Movie("Batman", 2022, "https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_.jpg");
		
		Actor a1 = new Actor("Leonardo DiCaprio", 52);
		Actor a2 = new Actor("Jennifer Lawrence", 32);
		Actor a3 = new Actor("Walter White", 56);
		Actor a4 = new Actor("Patrick Bateman", 44);
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		streamingRepository.saveAll(Arrays.asList(s1, s2, s3));
		movieRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		actorRepository.saveAll(Arrays.asList(a1, a2, a3, a4));
		
		m1.getCategories().add(c1);
		m1.getCategories().add(c5);
		m2.getCategories().add(c2);
		m2.getCategories().add(c3);
		m3.getCategories().add(c4);
		m4.getCategories().add(c2);
		m4.getCategories().add(c3);
		m5.getCategories().add(c5);
		
		m1.getStreamings().add(s1);
		m1.getStreamings().add(s2);
		m2.getStreamings().add(s3);
		m3.getStreamings().add(s1);
		m3.getStreamings().add(s3);
		m4.getStreamings().add(s2);
		m4.getStreamings().add(s1);
		m5.getStreamings().add(s1);
		m5.getStreamings().add(s2);
		
		m1.getActors().add(a1);
		m1.getActors().add(a3);
		m2.getActors().add(a2);
		m3.getActors().add(a1);
		m4.getActors().add(a2);
		m5.getActors().add(a4);
		
		movieRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		actorRepository.saveAll(Arrays.asList(a1, a2, a3, a4));
	}
}
