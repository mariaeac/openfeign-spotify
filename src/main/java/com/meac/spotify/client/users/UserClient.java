package com.meac.spotify.client.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "UserClient", url = "${spotify.url}")
public interface UserClient {

    @GetMapping("v1/users/{user_id}")
    UserResponse getUserInfo(@RequestHeader("Authorization") String auth, @PathVariable("user_id") String userId);
}
