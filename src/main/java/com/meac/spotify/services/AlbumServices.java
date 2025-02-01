package com.meac.spotify.services;

import com.meac.spotify.client.AuthSpotifyClient;
import com.meac.spotify.client.LoginRequest;
import com.meac.spotify.client.albums.Album;
import com.meac.spotify.client.albums.AlbumClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServices {
    public static final String GRANT_TYPE = "client_credentials";
    public static final String CLIENT_ID = "your_client_id";
    public static final String CLIENT_SECRET = "your_client_secret";


    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumClient albumSpotifyClient;

    public AlbumServices (AuthSpotifyClient authSpotifyClient, AlbumClient albumSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.albumSpotifyClient = albumSpotifyClient;
    }

    public List<Album> getAlbumsNewReleases() {


        LoginRequest loginRequest = new LoginRequest("client_credentials", CLIENT_ID, CLIENT_SECRET);
        var token = "Bearer " + authSpotifyClient.login(loginRequest).getAccessToken();

        var response = albumSpotifyClient.getAlbumsNewReleases(token);
        return response.getAlbums().getItems();

    }


    }



