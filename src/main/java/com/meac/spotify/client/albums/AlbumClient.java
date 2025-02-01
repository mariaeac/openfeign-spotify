package com.meac.spotify.client.albums;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "AlbumSpotifyClient", url = "${spotify.url}")
public interface AlbumClient {

    @GetMapping("/v1/browse/new-releases")
    AlbumResponse getAlbumsNewReleases(@RequestHeader("Authorization") String auth);

}
