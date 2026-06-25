package com.example.uploadFileDB.service;

import com.example.uploadFileDB.PathConfiguration;
import com.example.uploadFileDB.mapper.FileDBMapper;
import com.example.uploadFileDB.dto.FileDBResponse;
import com.example.uploadFileDB.entity.FileDB;
import com.example.uploadFileDB.exception.FileDBException;
import com.example.uploadFileDB.repository.FileDBRepository;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class FileStorageService {

    @Autowired
    private PathConfiguration path;

    @Autowired
    private FileDBRepository repo;

    @Autowired
    private FileDBMapper mapper;

    public FileDBResponse salva(MultipartFile file){
        try {
            FileDB fileDB = mapper.daMultiPartFileAFileDB(file);
            return mapper.daEntityADTO(repo.save(fileDB));
        } catch (IOException e) {
            throw new FileDBException("Impossibile salvare il file", e);
        }
    }

    public FileDBResponse findById(Long id){
        try {
            return mapper.daEntityADTO(repo.getReferenceById(id));
        } catch (DataAccessException e){
            throw new FileDBException("Errore di accesso al db", e);
        } catch (PersistenceException e){ // non trova il file con id tot
            throw new FileDBException("File con id: " + id + " non trovato", e);
        }

    }

    public List<FileDBResponse> findAllFiles(){
        try{
            return repo.findAll().stream()
                    .map(f -> mapper.daEntityADTO(f))
                    .toList();
        } catch (DataAccessException e){
            throw new FileDBException(e.getMessage(), e);
        }
    }

    // WARN: Metodo solo a scopo illustrativo angelini pharma
    public boolean scaricaLocale(Long id) {
        FileDBResponse file = findById(id);
        try {
            Path pathCompleto = path.getPathLocation().resolve(file.nome());
            Files.write(pathCompleto,  file.data());
            return true;
        } catch (IOException e) {
            throw new FileDBException(e.getMessage(), e);
        }
    }
}
