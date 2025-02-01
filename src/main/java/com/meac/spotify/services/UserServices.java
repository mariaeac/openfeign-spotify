package com.meac.spotify.services;

import com.meac.spotify.client.AuthSpotifyClient;
import com.meac.spotify.client.LoginRequest;
import com.meac.spotify.client.users.UserClient;
import com.meac.spotify.client.users.UserResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    Dotenv dotenv = Dotenv.configure().load();


    public final String GRANT_TYPE = "client_credentials";
    public final String CLIENT_ID = dotenv.get("SPOTIFY_CLIENT_ID");
    public final String CLIENT_SECRET =  dotenv.get("SPOTIFY_CLIENT_SECRET");

    private UserClient userClient;
    private AuthSpotifyClient authSpotifyClient;

    public UserServices(UserClient userClient, AuthSpotifyClient authSpotifyClient) {
        this.userClient = userClient;
        this.authSpotifyClient = authSpotifyClient;
    }

    public UserResponse getUser(String userId) {

        LoginRequest loginRequest = new LoginRequest(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET);
        var token = "Bearer " + authSpotifyClient.login(loginRequest).getAccessToken();
        var response = userClient.getUserInfo(token, userId);
        return response;

    }



}
