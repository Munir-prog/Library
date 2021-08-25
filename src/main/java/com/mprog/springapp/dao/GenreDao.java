package com.mprog.springapp.dao;

import com.mprog.springapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Integer> {
}
