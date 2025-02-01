package com.meac.spotify.services;

import com.meac.spotify.client.AuthSpotifyClient;
import com.meac.spotify.client.LoginRequest;
import com.meac.spotify.client.albums.Album;
import com.meac.spotify.client.albums.AlbumClient;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServices {

    Dotenv dotenv = Dotenv.configure().load();

    public final String GRANT_TYPE = "client_credentials";
    public final String CLIENT_ID = dotenv.get("SPOTIFY_CLIENT_ID");
    public final String CLIENT_SECRET =  dotenv.get("SPOTIFY_CLIENT_SECRET");


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



