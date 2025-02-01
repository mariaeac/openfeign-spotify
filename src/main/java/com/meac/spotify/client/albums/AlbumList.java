package com.meac.spotify.client.albums;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class AlbumList {

    private List<Album> items;

    public AlbumList() {

    }

    public AlbumList(List<Album> items) {
        this.items = items;
    }

    public List<Album> getItems() {
        return items;
    }

    public void setItems(List<Album> items) {
        this.items = items;
    }
}
