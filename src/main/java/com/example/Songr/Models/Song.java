package com.example.Songr.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.apache.catalina.authenticator.SavedRequest;

import javax.persistence.*;


//@Setter
//@Getter
//@NoArgsConstructor
//@RequiredArgsConstructor

/*
Entities in JPA are nothing but POJOs representing data that can be persisted to the database.
An entity represents a table stored in a database.
Every instance of an entity represents a row in the table.
https://www.baeldung.com/jpa-entities
 */

@JsonIgnoreProperties({"album"})
@Entity
public class Song {

//    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

     // @NonNull it to require the java to make a constructor
    private String title;
    private String length;
    private int trackNumber;

    public Song() {
    }

    public Song(String title, String length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    //the relation is many "the songs" to one "the album"
    @ManyToOne
    Albums album;// this name

    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums album) {
        this.album = album;
    }
}
