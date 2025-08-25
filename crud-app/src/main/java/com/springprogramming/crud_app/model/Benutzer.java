package com.springprogramming.crud_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity

public class Benutzer {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String email;
}
