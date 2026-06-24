package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.Repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("/albums")
    public List<Album> getAllItems() {
        return albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getItem(@PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping("/albums")
    public Album addItem(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @PutMapping("/albums/{id}")
    public Album updateItem(@PathVariable int id, @RequestBody Album album) {
        album.setId(id);
        return albumRepository.save(album);
    }

    @DeleteMapping("/albums/{id}")
    public void deleteItem(@PathVariable int id) {
        albumRepository.deleteById(id);
    }

}
