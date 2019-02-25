package com.endava.jguzman.jhonatan.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Pokemon {
    private int id;
    private String name;
    private String category;

    public Pokemon(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
