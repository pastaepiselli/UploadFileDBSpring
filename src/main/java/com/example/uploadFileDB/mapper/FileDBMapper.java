package com.example.uploadFileDB.mapper;

import com.example.uploadFileDB.dto.FileDBResponse;
import com.example.uploadFileDB.entity.FileDB;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class FileDBMapper {
    public FileDB daMultiPartFileAFileDB(MultipartFile file) throws IOException {
        return new FileDB(
                null,
                StringUtils.cleanPath(file.getOriginalFilename()),
                file.getContentType(),
                file.getBytes()
        );
    }
    public FileDBResponse daEntityADTO(FileDB file){
        return new FileDBResponse(
                file.getId(),
                file.getName(),
                file.getType(),
                file.getData()
        );
    }
}
