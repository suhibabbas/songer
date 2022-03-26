package com.example.Songr.web;


import com.example.Songr.Models.Albums;
import com.example.Songr.Models.Song;
import com.example.Songr.Repositries.AlbumRepository;
import com.example.Songr.Repositries.AlbumRepositoryCrud;
import com.example.Songr.Repositries.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongrController {

//    @Autowired
//    AlbumRepositoryCrud albumRepository;

    private final AlbumRepositoryCrud albumRepositoryCrud;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    public SongrController(AlbumRepositoryCrud albumRepositoryCrud, AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepositoryCrud = albumRepositoryCrud;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    @PostMapping("/addalbum")
    public RedirectView addAlbum(@ModelAttribute Albums albums){
        albumRepositoryCrud.save(albums);
        return new RedirectView("allAlbum");
    }

    @GetMapping("/allAlbum")
    public String gitAllAlbum(Model model){
        model.addAttribute("albumsList", albumRepositoryCrud.findAll());
        return "index";
    }

    @ResponseBody
    @GetMapping("/Album")
    List<Albums> albums(Model model){
        List<Albums>albums= new ArrayList<>();
        albums.add(new Albums("Godzila","Eminem",20,240,"Link"));

        return albums;
    }

    @ResponseBody
    @PostMapping("/album")
    Albums createNewAlbum(@RequestBody Albums albums){
        return albumRepository.save(albums);
    }

    @ResponseBody
    @GetMapping("/album")
    List<Albums> GetAllAlbum(){
        return albumRepository.findAll();
    }

    /**
     * Create a new song
     * @param song
     * @return
     */
    @ResponseBody
    @PostMapping("/song")
    Song createNewSong(@RequestBody Song song){
        return songRepository.save(song);
    }

    /**
     * Gets all the carts
     * @return
     */
    @ResponseBody
    @GetMapping("/song")
    List<Song> GetAllSongs(){
        return songRepository.findAll();
    }

    @ResponseBody
    @PostMapping("/album/{id}")
    Song addNewSongToAlbum(@RequestBody Song song, @PathVariable Long id){
        Albums album =  albumRepository.findById(id).orElseThrow();

        song.setAlbum(album);

        return songRepository.save(song);
    }

    @ResponseBody
    @GetMapping("/album/{title}")
    Albums findAlbumByTitle(@PathVariable String title){
        return albumRepository.findAlbumByTitle(title);
    }
}
