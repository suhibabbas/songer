package com.example.Songr.Repositries;

import com.example.Songr.Models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

    Song findAllByAlbum_Id(Long id);
}
