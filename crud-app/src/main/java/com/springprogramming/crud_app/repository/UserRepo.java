package com.springprogramming.crud_app.repository;

import com.springprogramming.crud_app.model.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Benutzer, Long> {
}
