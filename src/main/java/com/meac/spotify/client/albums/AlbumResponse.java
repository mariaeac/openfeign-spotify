package com.meac.spotify.client.albums;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class AlbumResponse {

    private AlbumList albums;

    public AlbumResponse() {

    }

    public AlbumResponse(AlbumList albums) {
        this.albums = albums;
    }

    public AlbumList getAlbums() {
        return albums;
    }

    public void setAlbums(AlbumList albums) {
        this.albums = albums;
    }
}
