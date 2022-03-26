package com.example.Songr;

import com.example.Songr.Models.Albums;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongrApplicationTests {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired SongrApplication songrApplication;

	@BeforeEach
	public void setUp(){

	}

	@Test
	void contextLoads() {
	}

	@Test void albumSetterAndGetterTest(){
		Albums album = new Albums();

		album.setArtist("Suhaib");
		album.setTitle("Love");

		assertEquals("Suhaib",album.getArtist());
		assertEquals("Love",album.getTitle());


	}
	@Test void albumConstructorTest(){
		List<Albums> albums= new ArrayList<>();
		albums.add(new Albums("Godzila","Eminem",20,240,"Link"));

		for (Albums a:albums
			 ) {
			assertEquals("Godzila",a.getTitle());
			assertEquals("Eminem",a.getArtist());
			assertEquals(20,a.getSongCount());
			assertEquals(240,a.getLength());
			assertEquals("Link",a.getImageUrl());
		}

	}

}
