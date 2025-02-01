package com.meac.spotify.services;

import com.meac.spotify.client.AuthSpotifyClient;
import com.meac.spotify.client.LoginRequest;
import com.meac.spotify.client.users.UserClient;
import com.meac.spotify.client.users.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    public static final String GRANT_TYPE = "client_credentials";
    public static final String CLIENT_ID = "your_client_id";
    public static final String CLIENT_SECRET = "your_client_secret";

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
