package com.mprog.springapp.dao;

import com.mprog.springapp.model.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(value = "select * from genre",
            countQuery = "SELECT count(*) FROM author",
        nativeQuery = true)
    Page<Genre> findAll(Pageable pageable);

}
