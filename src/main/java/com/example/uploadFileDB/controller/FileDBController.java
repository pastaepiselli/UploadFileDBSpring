package com.example.uploadFileDB.controller;

import com.example.uploadFileDB.dto.FileDBResponse;
import com.example.uploadFileDB.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/files")
public class FileDBController {

    @Autowired
    private FileStorageService service;

    @PostMapping(path = "/upload")
    public FileDBResponse carica(@RequestParam("file") MultipartFile file){
        return service.salva(file);
    }

    @GetMapping(path = "/{id}")
    public FileDBResponse findId(@PathVariable Long id){
       return service.findById(id);
    }

    @GetMapping(path = "")
    public List<FileDBResponse> findAll(){
        return service.findAllFiles();
    }

    @GetMapping(path = "/{id}/scarica")
    public boolean scaricaFile(@PathVariable Long id){
        return service.scaricaLocale(id);
    }
}

