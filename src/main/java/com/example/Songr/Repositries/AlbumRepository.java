package com.example.Songr.Repositries;

import com.example.Songr.Models.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Albums,Long> {
    Albums findAlbumByTitle(String title);
}
