package com.example.uploadFileDB.exception;

public class FileDBException extends RuntimeException {
    public FileDBException(String message) {
        super(message);
    }
    public FileDBException(String message, Throwable cause){
        super(message, cause);
    }
}

