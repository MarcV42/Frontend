package com.example.backend.Entities;


import lombok.With;

public record ToDo(
        String id,
        @With
        String description,

        @With
        Status status
) {

}
