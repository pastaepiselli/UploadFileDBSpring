package com.example.uploadFileDB.repository;

import com.example.uploadFileDB.entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {
}
