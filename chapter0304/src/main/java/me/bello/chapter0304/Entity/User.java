package me.bello.chapter0304.Entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private MultipartFile header;

    public User() {
    }

    public User(String name, MultipartFile header) {
        this.name = name;
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getHeader() {
        return header;
    }

    public void setHeader(MultipartFile header) {
        this.header = header;
    }
}
