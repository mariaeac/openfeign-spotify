package com.meac.spotify.controller;

import com.meac.spotify.client.albums.Album;
import com.meac.spotify.services.AlbumServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final AlbumServices albumServices;
    public AlbumController(AlbumServices albumServices) {
        this.albumServices = albumServices;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getReleasesAlbums() {
        List<Album> albums = albumServices.getAlbumsNewReleases();
        return ResponseEntity.ok(albums);
    }

}
