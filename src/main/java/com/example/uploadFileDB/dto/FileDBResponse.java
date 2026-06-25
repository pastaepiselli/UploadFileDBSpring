package com.example.uploadFileDB.dto;

public record FileDBResponse(
        Long id,
        String nome,
        String type,
        byte[] data
) {}
