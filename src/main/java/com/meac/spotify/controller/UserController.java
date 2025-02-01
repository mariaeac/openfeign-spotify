package com.meac.spotify.controller;

import com.meac.spotify.client.users.UserResponse;
import com.meac.spotify.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify/api")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("user/{user_id}")
    public ResponseEntity<UserResponse> getUserInfo(@PathVariable("user_id") String userId) {
        UserResponse user = userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }

}
